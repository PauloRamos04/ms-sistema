package saudeconectada.fatec.ms_sistema.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {

    private Long id;
    private String patientCpf;
    private String healthProfessionalCpf;
    private LocalDateTime appointmentDate;
    private String description;
    private String status;
    private String especialidade;
    private String unidade;
    private String convenio;
}
