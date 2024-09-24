package saudeconectada.fatec.ms_sistema.domain.model;

import jakarta.persistence.*;
import saudeconectada.fatec.ms_sistema.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientCpf;
    private String healthProfessionalCpf;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private LocalDateTime appointmentDate;

    private String description;

    public Appointment() {}
}

