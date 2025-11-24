package com.guillermomartin.gofoodapp;

public class Restaurante {
    private String nombre;
    private String tipoComida;
    private String menuDestacado;
    private boolean isExpanded;

    public Restaurante(String nombre, String tipoComida, String menuDestacado) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.menuDestacado = menuDestacado;
        this.isExpanded = false;
    }

    public String getNombre() { return nombre; }
    public String getTipoComida() { return tipoComida; }
    public String getMenuDestacado() { return menuDestacado; }
    public boolean isExpanded() { return isExpanded; }

    // Setter para la expansión
    public void setExpanded(boolean expanded) { isExpanded = expanded; }
}
