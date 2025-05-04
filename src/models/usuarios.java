package models;

public class usuarios {
    private String id;
    private String nombre_completo;
    private String correo;
    private String password;
    private String rol;

    public usuarios() {}

    public usuarios(String id, String nombre_completo, String correo, String password, String rol) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}


