package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saudeconectada.fatec.ms_sistema.domain.dto.AppointmentDTO;
import saudeconectada.fatec.ms_sistema.service.AppointmentService;

@RestController
@RequestMapping("/api/agendamentos")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<String> agendar(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.agendar(appointmentDTO);
        return ResponseEntity.ok("agendado");

    }
}
