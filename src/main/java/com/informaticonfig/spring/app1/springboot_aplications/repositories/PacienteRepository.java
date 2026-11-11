package com.informaticonfig.spring.app1.springboot_aplications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}