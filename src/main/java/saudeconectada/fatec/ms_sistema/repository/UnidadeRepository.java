package saudeconectada.fatec.ms_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;

import java.util.List;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    List<Unidade> findByDisponivelTrue();

    @Query("SELECT u FROM Unidade u WHERE u.nome = :nome AND u.disponivel = true")
    Unidade findByNome(@Param("nome") String nome);

}
