package com.guillermomartin.gofoodapp;

public class Restaurante {
    private String nombre;
    private String tipoComida;
    private String menuDestacado; // Esto será para el desplegable
    private boolean isExpanded; // Para controlar si el desplegable está abierto

    public Restaurante(String nombre, String tipoComida, String menuDestacado) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.menuDestacado = menuDestacado;
        this.isExpanded = false; // Por defecto cerrado
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getTipoComida() { return tipoComida; }
    public String getMenuDestacado() { return menuDestacado; }
    public boolean isExpanded() { return isExpanded; }

    // Setter para la expansión
    public void setExpanded(boolean expanded) { isExpanded = expanded; }
}
