package com.informaticonfig.spring.app1.springboot_aplications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.informaticonfig.spring.app1.springboot_aplications.models.dto.EmpleadoDTO;

@Controller
@RequestMapping("/clinica")
public class EmpleadoViewController {

    @Value("${proyecto.nombre}")
    private String nombreProyecto;

    @Value("${proyecto.autor}")
    private String autor;

    private final List<EmpleadoDTO> empleados = List.of(
        new EmpleadoDTO(1, "Ana López", "Dentista", 18000),
        new EmpleadoDTO(2, "Luis Pérez", "Recepcionista", 9000),
        new EmpleadoDTO(3, "María Ruiz", "Dentista", 19000),
        new EmpleadoDTO(4, "Carlos Gómez", "Asistente", 8000)
    );

    @GetMapping("/empleados")
    public String lista(@RequestParam(required = false) String puesto, Model model) {
        List<EmpleadoDTO> resultado = (puesto == null || puesto.isBlank())
            ? empleados
            : empleados.stream().filter(e -> e.getPuesto().equalsIgnoreCase(puesto)).toList();
        model.addAttribute("empleados", resultado);
        model.addAttribute("nombreProyecto", nombreProyecto);
        model.addAttribute("autor", autor);
        model.addAttribute("filtro", puesto);
        return "lista";
    }

    @GetMapping("/empleados/{id}")
    public String detalle(@PathVariable int id, Model model) {
        EmpleadoDTO empleado = empleados.stream()
            .filter(e -> e.getId() == id).findFirst().orElse(null);
        model.addAttribute("empleado", empleado);
        return "detalle";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("empleado", new EmpleadoDTO());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("empleado") EmpleadoDTO empleado) {
        return "resultado";
    }
}