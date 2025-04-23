package models;

public class epicas {
    private String id;
    private String proyecto_id;
    private String descripcion;

    public epicas() {}

    public epicas(String id, String proyecto_id, String descripcion) {
        this.id = id;
        this.proyecto_id = proyecto_id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(String proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

