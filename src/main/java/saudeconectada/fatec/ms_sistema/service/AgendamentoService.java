package saudeconectada.fatec.ms_sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saudeconectada.fatec.ms_sistema.domain.dto.AppointmentDTO;
import saudeconectada.fatec.ms_sistema.domain.enums.AppointmentStatus;
import saudeconectada.fatec.ms_sistema.domain.model.Agendamento;
import saudeconectada.fatec.ms_sistema.domain.model.Especialidade;
import saudeconectada.fatec.ms_sistema.domain.model.Unidade;
import saudeconectada.fatec.ms_sistema.repository.AgendamentoRepository;
import saudeconectada.fatec.ms_sistema.repository.EspecialidadeRepository;
import saudeconectada.fatec.ms_sistema.repository.UnidadeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, String patientCpf) throws Exception {
        Agendamento agendamento = new Agendamento();
        mapToEntity(appointmentDTO, agendamento, patientCpf); // Passando o CPF do paciente
        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        return mapToDTO(savedAgendamento);
    }

    private void mapToEntity(AppointmentDTO dto, Agendamento agendamento, String patientCpf) throws Exception {
        agendamento.setPatientCpf(patientCpf);
        agendamento.setHealthProfessionalCpf(dto.getHealthProfessionalCpf());
        agendamento.setAppointmentDate(dto.getAppointmentDate());
        agendamento.setDescription(dto.getDescription());
        agendamento.setStatus(AppointmentStatus.valueOf(dto.getStatus()));
        agendamento.setConvenio(dto.getConvenio());

        // Buscando e setando a especialidade pelo ID (ou nome, se necessário)
        Especialidade especialidade = findEspecialidadeByName(dto.getEspecialidade());
        agendamento.setEspecialidade(especialidade);

        // Buscando e setando a unidade pelo ID (ou nome, se necessário)
        Unidade unidade = findUnidadeByName(dto.getUnidade());
        agendamento.setUnidade(unidade);
    }


    private Especialidade findEspecialidadeByName(String especialidadeName) throws Exception {
        Especialidade especialidade = especialidadeRepository.findByNome(especialidadeName);
        if (especialidade == null) {
            throw new Exception("Especialidade não encontrada: " + especialidadeName);
        }
        return especialidade;
    }

    private Unidade findUnidadeByName(String unidadeName) throws Exception {
        Unidade unidade = unidadeRepository.findByNome(unidadeName);
        if (unidade == null) {
            throw new Exception("Unidade não encontrada: " + unidadeName);
        }
        return unidade;
    }

    public List<Agendamento> listarAgendamentosPorUnidade(Long unidadeId) {
        return agendamentoRepository.findByUnidadeId(unidadeId);
    }

    public AppointmentDTO mapToDTO(Agendamento agendamento) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setPatientCpf(agendamento.getPatientCpf());
        dto.setHealthProfessionalCpf(agendamento.getHealthProfessionalCpf());
        dto.setAppointmentDate(agendamento.getAppointmentDate());
        dto.setDescription(agendamento.getDescription());
        dto.setStatus(agendamento.getStatus().name());

        // Certifique-se de que você está acessando os objetos de Unidade e Especialidade corretamente
        dto.setEspecialidade(agendamento.getEspecialidade() != null ? agendamento.getEspecialidade().getNome() : null);
        dto.setUnidade(agendamento.getUnidade() != null ? agendamento.getUnidade().getNome() : null);
        dto.setConvenio(agendamento.getConvenio());

        return dto;
    }


    public List<Agendamento> listarAgendamentosPorCpf(String patientCpf) {
        return agendamentoRepository.findByPatientCpf(patientCpf);
    }

    public List<AppointmentDTO> listarAgendamentosPorCpfDTO(String patientCpf) {
        return listarAgendamentosPorCpf(patientCpf).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
