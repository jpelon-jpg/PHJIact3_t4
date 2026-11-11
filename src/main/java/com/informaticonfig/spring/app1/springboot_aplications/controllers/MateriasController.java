package com.informaticonfig.spring.app1.springboot_aplications.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriasController {

    // Endpoint b) Lista simulada (se devuelve como JSON)
    @GetMapping("/materias")
    public List<Map<String, Object>> materias() {
        return List.of(
            Map.of("nombre", "Programación Web", "creditos", 5),
            Map.of("nombre", "PLF", "creditos", 5),
            Map.of("nombre", "Conmutación", "creditos", 5)
        );
    }
}
