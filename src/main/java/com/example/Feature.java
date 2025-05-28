package com.example;


public class Feature {
    private String id;
    private String epicaId;
    private String descripcion;
    private String nombre;

    public Feature(String id, String epicaId, String descripcion, String nombre) {
        this.id = id;
        this.epicaId = epicaId;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getEpicaId() { return epicaId; }
    public String getDescripcion() { return descripcion; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}
