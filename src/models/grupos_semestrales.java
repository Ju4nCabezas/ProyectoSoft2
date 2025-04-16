package models;

public class grupos_semestrales {
     private String id;
     private String nombre;
     private String profesor_id;
     private String materia;
     private String descripcion;
     private String semestre;

     public grupos_semestrales() {}

    public grupos_semestrales(String id, String nombre, String profesor_id, String materia, String descripcion, String semestre) {
        this.id = id;
        this.nombre = nombre;
        this.profesor_id = profesor_id;
        this.materia = materia;
        this.descripcion = descripcion;
        this.semestre = semestre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(String profesor_id) {
        this.profesor_id = profesor_id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}


