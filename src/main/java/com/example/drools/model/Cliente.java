package com.example.drools.model;

public class Cliente {
    private String nombre;
    private int edad;
    private double descuento;

    public Cliente() {
    }

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.descuento = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años) - Descuento: " + descuento + "%";
    }
}
