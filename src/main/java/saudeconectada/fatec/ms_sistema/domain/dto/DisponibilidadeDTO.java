package saudeconectada.fatec.ms_sistema.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class DisponibilidadeDTO {
    private Long id;
    private LocalDate data;
    private LocalTime horario;
}
