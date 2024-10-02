package saudeconectada.fatec.ms_sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saudeconectada.fatec.ms_sistema.domain.model.Disponibilidade;
import saudeconectada.fatec.ms_sistema.domain.model.Especialidade;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;
import saudeconectada.fatec.ms_sistema.repository.DisponibilidadeRepository;
import saudeconectada.fatec.ms_sistema.repository.EspecialidadeRepository;
import saudeconectada.fatec.ms_sistema.repository.UnidadeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Disponibilidade> getDisponibilidades(String especialidadeNome, String unidadeNome, LocalDate data) {
        Especialidade especialidade = especialidadeRepository.findByNome(especialidadeNome);
        Unidade unidade = unidadeRepository.findByNome(unidadeNome);

        if (especialidade == null || unidade == null) {
            return List.of(); // Retorna uma lista vazia caso não encontre a especialidade ou unidade
        }

        return disponibilidadeRepository.findByEspecialidadeAndUnidadeAndData(especialidade, unidade, data);
    }

    public List<Disponibilidade> getDisponibilidades(String especialidadeNome, String unidadeNome) {
        Especialidade especialidade = especialidadeRepository.findByNome(especialidadeNome);
        Unidade unidade = unidadeRepository.findByNome(unidadeNome);

        if (especialidade == null || unidade == null) {
            return List.of(); // Retorna uma lista vazia caso não encontre a especialidade ou unidade
        }

        // Aqui você também pode decidir se quer passar o parâmetro de disponibilidade
        return disponibilidadeRepository.findByEspecialidadeNomeAndUnidadeNomeAndUnidadeDisponivel(especialidadeNome, unidadeNome, unidade.isDisponivel());
    }

    public List<Disponibilidade> findByEspecialidadeAndUnidade(String especialidadeNome, String unidadeNome) {
        return disponibilidadeRepository.findByEspecialidadeNomeAndUnidadeNomeAndUnidadeDisponivel(especialidadeNome, unidadeNome, true);
    }
}
