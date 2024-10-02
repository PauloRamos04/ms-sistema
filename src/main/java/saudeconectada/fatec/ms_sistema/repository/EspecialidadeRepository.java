package saudeconectada.fatec.ms_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saudeconectada.fatec.ms_sistema.domain.model.Especialidade;

import java.util.Optional;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Especialidade findByNome(String nome);
}
