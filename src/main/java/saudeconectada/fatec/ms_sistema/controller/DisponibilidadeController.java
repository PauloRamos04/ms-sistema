package saudeconectada.fatec.ms_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saudeconectada.fatec.ms_sistema.domain.dto.DisponibilidadeDTO;
import saudeconectada.fatec.ms_sistema.domain.model.Disponibilidade;
import saudeconectada.fatec.ms_sistema.service.DisponibilidadeService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DisponibilidadeController {

    @Autowired
    private DisponibilidadeService disponibilidadeService;

    @GetMapping("/disponibilidades")
    public ResponseEntity<List<Disponibilidade>> getDisponibilidades(
            @RequestParam("especialidade") String especialidade,
            @RequestParam("unidade") String unidade,
            @RequestParam(value = "data", required = false) String data // Data agora é opcional
    ) {
        List<Disponibilidade> disponibilidades;

        try {
            if (data != null && !data.isEmpty()) {
                LocalDate parsedDate = LocalDate.parse(data); // Certifique-se de que o formato da data é "yyyy-MM-dd"
                disponibilidades = disponibilidadeService.getDisponibilidades(especialidade, unidade, parsedDate);
            } else {
                disponibilidades = disponibilidadeService.getDisponibilidades(especialidade, unidade);
            }
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build(); // Se o formato da data estiver incorreto, retorne 400 Bad Request
        }

        return ResponseEntity.ok(disponibilidades);
    }

    @GetMapping("/datas-disponiveis")
    public ResponseEntity<List<DisponibilidadeDTO>> getDisponibilidades(
            @RequestParam String especialidade,
            @RequestParam String unidade) {
        List<Disponibilidade> disponibilidades = disponibilidadeService.findByEspecialidadeAndUnidade(especialidade, unidade);
        List<DisponibilidadeDTO> result = disponibilidades.stream()
                .map(d -> new DisponibilidadeDTO(d.getId(), d.getData(), d.getHorario()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }


}
