package saudeconectada.fatec.ms_sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;
import saudeconectada.fatec.ms_sistema.repository.UnidadeRepository;

import java.util.List;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> listarUnidadesDisponiveis() {
        return unidadeRepository.findByDisponivelTrue();
    }
}
