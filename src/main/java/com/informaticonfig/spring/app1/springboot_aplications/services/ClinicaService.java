package com.informaticonfig.spring.app1.springboot_aplications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Dentista;
import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Paciente;
import com.informaticonfig.spring.app1.springboot_aplications.repositories.DentistaRepository;
import com.informaticonfig.spring.app1.springboot_aplications.repositories.PacienteRepository;

@Service
public class ClinicaService {

    private final PacienteRepository pacienteRepo;
    private final DentistaRepository dentistaRepo;

    public ClinicaService(PacienteRepository pacienteRepo, DentistaRepository dentistaRepo) {
        this.pacienteRepo = pacienteRepo;
        this.dentistaRepo = dentistaRepo;
    }

    public List<Dentista> listarDentistas() { return dentistaRepo.findAll(); }

    public Dentista guardarDentista(Dentista d) { return dentistaRepo.save(d); }

    public List<Paciente> listarPacientes() { return pacienteRepo.findAll(); }

    public Optional<Paciente> buscarPaciente(Long id) { return pacienteRepo.findById(id); }

    public Paciente crearPaciente(Paciente p) {
        p.setId(null);
        asignarDentista(p);
        return pacienteRepo.save(p);
    }

    public Optional<Paciente> actualizarPaciente(Long id, Paciente datos) {
        return pacienteRepo.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setEdad(datos.getEdad());
            p.setDentista(datos.getDentista());
            asignarDentista(p);
            return pacienteRepo.save(p);
        });
    }

    public boolean eliminarPaciente(Long id) {
        if (!pacienteRepo.existsById(id)) return false;
        pacienteRepo.deleteById(id);
        return true;
    }

    private void asignarDentista(Paciente p) {
        if (p.getDentista() != null && p.getDentista().getId() != null) {
            p.setDentista(dentistaRepo.findById(p.getDentista().getId()).orElse(null));
        }
    }
}