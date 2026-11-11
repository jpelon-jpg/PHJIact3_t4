package com.informaticonfig.spring.app1.springboot_aplications.controllers;

import org.springframework.web.bind.annotation.*;

import com.informaticonfig.spring.app1.springboot_aplications.models.dto.EmpleadoDTO;

@RestController
@RequestMapping("/api/clinica")
public class EmpleadoRestController {

    @PostMapping("/empleados")
    public EmpleadoDTO crear(@RequestBody EmpleadoDTO empleado) {
        return empleado;
    }
}