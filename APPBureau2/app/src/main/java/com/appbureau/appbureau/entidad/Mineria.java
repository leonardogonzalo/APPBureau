package com.appbureau.appbureau.entidad;

public class Mineria {

    private String nombre;
    private String ciudad;
    private String fechas;
    private String normas;

    public Mineria() { }

    public Mineria(String nombre, String ciudad, String fechas, String normas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechas = fechas;
        this.normas = normas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }
}
