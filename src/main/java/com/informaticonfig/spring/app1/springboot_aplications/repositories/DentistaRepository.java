package com.informaticonfig.spring.app1.springboot_aplications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informaticonfig.spring.app1.springboot_aplications.models.entity.Dentista;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}