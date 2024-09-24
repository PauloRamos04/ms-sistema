package saudeconectada.fatec.ms_sistema.domain.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;
    private String patientCpf;
    private String healthProfessionalCpf;
    private LocalDateTime appointmentDate;
    private String description;
    private String status;
}
