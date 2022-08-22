package modelo;

public class Cliente {

    private Integer idcli;
    private String nombre;
    private String apellidos;
    private String celular;
    private Integer dni;

    private String direccion;
    private Ubigeo ubigeo = new Ubigeo();
    private String estado;

    public Cliente(Integer idcli, String nombre, String apellidos, Integer dni, String celular, String direccion, Ubigeo ubigeo, String estado) {
        this.idcli = idcli;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.estado = estado;

    }

    public Cliente() {
    }

    public Integer getIdcli() {
        return idcli;
    }

    public void setIdcli(Integer idcli) {
        this.idcli = idcli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
