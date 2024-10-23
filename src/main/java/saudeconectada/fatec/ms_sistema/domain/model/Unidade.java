package saudeconectada.fatec.ms_sistema.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "unidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean disponivel; // ou Boolean disponivel;
}
