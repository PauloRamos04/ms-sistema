package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import saudeconectada.fatec.ms_sistema.domain.model.Appointment;
import saudeconectada.fatec.ms_sistema.service.AppointmentService;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public String createAppointment(Authentication authentication, @RequestBody Appointment appointment) {
        String cpf = null;

        // Verifica se o Principal é uma instância de UserDetails
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            cpf = userDetails.getUsername();  // O método `getUsername()` retorna o identificador (neste caso, o CPF)
        } else if (authentication.getPrincipal() instanceof String) {
            cpf = (String) authentication.getPrincipal();  // Se for diretamente uma String, assumimos que é o CPF
        }

        if (cpf == null) {
            throw new IllegalStateException("Unable to extract CPF from the authenticated principal.");
        }

        // Utilize o CPF para associar o agendamento ao paciente/profissional
        appointmentService.createAppointment(cpf, appointment);

        return "Appointment created successfully!";
    }
}
