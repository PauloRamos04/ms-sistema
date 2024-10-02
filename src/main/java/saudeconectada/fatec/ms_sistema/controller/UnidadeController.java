package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;
import saudeconectada.fatec.ms_sistema.service.UnidadeService;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {
    @Autowired
    private UnidadeService unidadeService;

    @GetMapping("/disponiveis")
    public List<Unidade> listarUnidadesDisponiveis() {
        return unidadeService.listarUnidadesDisponiveis();
    }
}