package com.informaticonfig.spring.app1.springboot_aplications.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Dentista;
import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Paciente;
import com.informaticonfig.spring.app1.springboot_aplications.services.ClinicaService;

@RestController
@RequestMapping("/api")
public class PacienteApiController {

    private final ClinicaService service;

    public PacienteApiController(ClinicaService service) {
        this.service = service;
    }

    @PostMapping("/dentistas")
    public Dentista crearDentista(@RequestBody Dentista d) { return service.guardarDentista(d); }

    @GetMapping("/dentistas")
    public List<Dentista> listarDentistas() { return service.listarDentistas(); }

    @PostMapping("/pacientes")
    public Paciente crear(@RequestBody Paciente p) { return service.crearPaciente(p); }

    @GetMapping("/pacientes")
    public List<Paciente> listar() { return service.listarPacientes(); }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> ver(@PathVariable Long id) {
        return service.buscarPaciente(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente p) {
        return service.actualizarPaciente(id, p).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminarPaciente(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}