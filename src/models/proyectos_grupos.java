package models;

public class proyectos_grupos {
    private String proyecto_id;
    private String grupo_id;

    public proyectos_grupos() {}

    public proyectos_grupos(String proyecto_id, String grupo_id) {
        this.proyecto_id = proyecto_id;
        this.grupo_id = grupo_id;
    }

    public String getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(String proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
    }
}

