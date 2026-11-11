package com.informaticonfig.spring.app1.springboot_aplications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/proyecto")
    public String proyecto() {
        return "Proyecto: Clinica dental | PHJI";
    }

    @GetMapping("/numero")
    public int numero() {
        return 2026;
    }
}