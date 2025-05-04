package models;

public class features {
    private String id;
    private String epica_id;
    private String descripcion;
    private String nombre;

    public features() {}

    public features(String id, String epica_id, String descripcion, String nombre) {
        this.id = id;
        this.epica_id = epica_id;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpica_id() {
        return epica_id;
    }

    public void setEpica_id(String epica_id) {
        this.epica_id = epica_id;
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
