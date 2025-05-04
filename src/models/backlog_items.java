package models;

public class backlog_items {
    private String id;
    private String feature_id;
    private int puntos_esfuerzo;
    private String descripcion;
    private String nombre;

    public backlog_items() {}

    public backlog_items(String id, String feature_id, int puntos_esfuerzo, String descripcion, String nombre) {
        this.id = id;
        this.feature_id = feature_id;
        this.puntos_esfuerzo = puntos_esfuerzo;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(String feature_id) {
        this.feature_id = feature_id;
    }

    public int getPuntos_esfuerzo() {
        return puntos_esfuerzo;
    }

    public void setPuntos_esfuerzo(int puntos_esfuerzo) {
        this.puntos_esfuerzo = puntos_esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
