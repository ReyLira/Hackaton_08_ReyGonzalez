package modelo;

import java.sql.Date;

public class VentaDetalle {

    private Integer IDVENDET;
    private Date FECHVEN;
    private Cliente cliente = new Cliente();
    private String ESTVEN;
    private Empleado empleado = new Empleado();
    private int CANTVENDET;
    private Venta venta = new Venta();
    private Subfamilia subfamilia = new Subfamilia();
    private Double subtotal;
    private Double total;

    public Integer getIDVENDET() {
        return IDVENDET;
    }

    public void setIDVENDET(Integer IDVENDET) {
        this.IDVENDET = IDVENDET;
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

    public int getCANTVENDET() {
        return CANTVENDET;
    }

    public void setCANTVENDET(int CANTVENDET) {
        this.CANTVENDET = CANTVENDET;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Subfamilia getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(Subfamilia subfamilia) {
        this.subfamilia = subfamilia;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
