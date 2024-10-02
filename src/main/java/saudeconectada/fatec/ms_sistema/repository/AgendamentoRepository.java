package saudeconectada.fatec.ms_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saudeconectada.fatec.ms_sistema.domain.model.Agendamento;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByUnidadeId(Long unidadeId);
    List<Agendamento> findByPatientCpf(String patientCpf);

}
