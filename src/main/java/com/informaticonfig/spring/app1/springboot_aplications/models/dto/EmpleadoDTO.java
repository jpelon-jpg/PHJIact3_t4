package com.informaticonfig.spring.app1.springboot_aplications.models.dto;

public class EmpleadoDTO {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    public EmpleadoDTO() {}

    public EmpleadoDTO(int id, String nombre, String puesto, double salario) {
        this.id = id; this.nombre = nombre; this.puesto = puesto; this.salario = salario;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}