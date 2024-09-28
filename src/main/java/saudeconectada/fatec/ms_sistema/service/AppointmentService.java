package saudeconectada.fatec.ms_sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saudeconectada.fatec.ms_sistema.domain.dto.AppointmentDTO;
import saudeconectada.fatec.ms_sistema.domain.model.Appointment;
import org.modelmapper.ModelMapper;
import saudeconectada.fatec.ms_sistema.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    public void applyToEntity(AppointmentDTO dto, Appointment appointment){
        modelMapper.map(dto, appointment);
    }


    @Autowired
    private AppointmentRepository appointmentRepository;

    private final List<AppointmentDTO> appointments = new ArrayList<>();

    public void agendar(AppointmentDTO appointmentDTO){
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }
}
