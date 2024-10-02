package saudeconectada.fatec.ms_sistema.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import saudeconectada.fatec.ms_sistema.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientCpf;
    private String healthProfessionalCpf;
    private LocalDateTime appointmentDate;
    private String description;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private String convenio;

    @ManyToOne // Relação com a Especialidade
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @ManyToOne // Relação com a Unidade
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
}
