package saudeconectada.fatec.ms_sistema.domain.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisponibilidadeDTO {
    private Long id;
    private LocalDate data;
    private LocalTime horario;

    public DisponibilidadeDTO(Long id, LocalDate data, LocalTime horario) {
        this.id = id;
        this.data = data;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
