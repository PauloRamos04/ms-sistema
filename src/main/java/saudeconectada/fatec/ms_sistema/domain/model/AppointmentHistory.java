package saudeconectada.fatec.ms_sistema.domain.model;

import jakarta.persistence.*;
import saudeconectada.fatec.ms_sistema.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Entity
public class AppointmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private LocalDateTime statusChangeDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus oldStatus;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus newStatus;

    private String changedBy;
}
