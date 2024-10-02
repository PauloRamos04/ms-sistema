package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saudeconectada.fatec.ms_sistema.domain.dto.AppointmentDTO;
import saudeconectada.fatec.ms_sistema.service.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO,
                                                            @RequestHeader("X-Patient-Cpf") String patientCpf) {
        try {
            AppointmentDTO createdAppointment = agendamentoService.createAppointment(appointmentDTO, patientCpf);
            return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/unidade/{unidadeId}")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByUnit(@PathVariable Long unidadeId) {
        List<AppointmentDTO> appointments = agendamentoService.listarAgendamentosPorUnidade(unidadeId)
                .stream()
                .map(agendamentoService::mapToDTO)
                .toList();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByPatientCpf(@RequestHeader("X-Patient-Cpf") String patientCpf) {
        List<AppointmentDTO> appointments = agendamentoService.listarAgendamentosPorCpfDTO(patientCpf);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
