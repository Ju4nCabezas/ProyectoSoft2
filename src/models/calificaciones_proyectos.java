package models;

import java.sql.Timestamp;

public class calificaciones_proyectos {
    private String id;
    private String estudiante_id;
    private String proyecto_id;
    private float calificacion;
    private String comentario;
    private Timestamp fecha_calificacion; // Sigue siendo Timestamp

    public calificaciones_proyectos() {}

    public calificaciones_proyectos(String id, String estudiante_id, String proyecto_id, float calificacion, String comentario, Timestamp fecha_calificacion) {
        this.id = id;
        this.estudiante_id = estudiante_id;
        this.proyecto_id = proyecto_id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha_calificacion = fecha_calificacion;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getEstudiante_id() { return estudiante_id; }

    public void setEstudiante_id(String estudiante_id) { this.estudiante_id = estudiante_id; }

    public String getProyecto_id() { return proyecto_id; }

    public void setProyecto_id(String proyecto_id) { this.proyecto_id = proyecto_id; }

    public float getCalificacion() { return calificacion; }

    public void setCalificacion(float calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }

    public void setComentario(String comentario) { this.comentario = comentario; }

    public Timestamp getFecha_calificacion() { return fecha_calificacion; }

    public void setFecha_calificacion(Timestamp fecha_calificacion) { this.fecha_calificacion = fecha_calificacion; }
}
