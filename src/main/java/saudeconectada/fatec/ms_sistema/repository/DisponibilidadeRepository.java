package saudeconectada.fatec.ms_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import saudeconectada.fatec.ms_sistema.domain.model.Disponibilidade;
import saudeconectada.fatec.ms_sistema.domain.model.Especialidade;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

    List<Disponibilidade> findByEspecialidadeAndUnidadeAndData(Especialidade especialidade, Unidade unidade, LocalDate data);

    @Query("SELECT d FROM Disponibilidade d WHERE d.especialidade = :especialidade AND d.unidade = :unidade")
    List<Disponibilidade> findByEspecialidadeAndUnidade(@Param("especialidade") Especialidade especialidade, @Param("unidade") Unidade unidade);

    List<Disponibilidade> findByEspecialidadeNomeAndUnidadeNome(String especialidadeNome, String unidadeNome);

    // Adicione o parâmetro 'disponivel'
    List<Disponibilidade> findByEspecialidadeNomeAndUnidadeNomeAndUnidadeDisponivel(
            String especialidadeNome, String unidadeNome, boolean unidadeDisponivel);
}
