package com.informaticonfig.spring.app1.springboot_aplications.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informaticonfig.spring.app1.springboot_aplications.models.dto.ClaseDTO;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController 
@RequestMapping("/api")

public class EjemploRestController {

    @GetMapping(path = "/detalles_info2")
    
    public ClaseDTO detalles_info() {
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Administrador");
        usuario1.setUsuario("Informaticonfig");

        return usuario1;

    }


}
