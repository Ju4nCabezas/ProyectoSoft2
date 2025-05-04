package models;

public class planificaciones_proyectos {
    private String id;
    private String proyecto_id;
    private String objetivos;
    private String metas;
    private String metodologia;

    public planificaciones_proyectos() {}

    public planificaciones_proyectos(String id, String proyecto_id, String objetivos, String metas, String metodologia) {
        this.id = id;
        this.proyecto_id = proyecto_id;
        this.objetivos = objetivos;
        this.metas = metas;
        this.metodologia = metodologia;
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

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }
}
