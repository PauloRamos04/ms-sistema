package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saudeconectada.fatec.ms_sistema.domain.model.Especialidade;
import saudeconectada.fatec.ms_sistema.repository.EspecialidadeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    @PostMapping
    public Especialidade createEspecialidade(@RequestBody Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }
}
