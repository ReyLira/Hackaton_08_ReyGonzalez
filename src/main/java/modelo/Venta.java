package modelo;

import java.sql.Date;

public class Venta {

    private Integer IDVEN;
    private Date FECHVEN;
    private Cliente cliente = new Cliente();
    private String ESTVEN;
    private Empleado empleado = new Empleado();

    public Integer getIDVEN() {
        return IDVEN;
    }

    public void setIDVEN(Integer IDVEN) {
        this.IDVEN = IDVEN;
    }

    public Date getFECHVEN() {
        return FECHVEN;
    }

    public void setFECHVEN(Date FECHVEN) {
        this.FECHVEN = FECHVEN;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getESTVEN() {
        return ESTVEN;
    }

    public void setESTVEN(String ESTVEN) {
        this.ESTVEN = ESTVEN;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
