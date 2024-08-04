package org.diegovelu.hibernateapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name="forma_pago")
    private String formaPago;

    @Embedded
    private Auditoria auditoria = new Auditoria();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "id_cliente")
    @JoinTable(name = "tbl_clientes_direcciones"
            ,joinColumns = @JoinColumn(name = "id_cliente")
            , inverseJoinColumns = @JoinColumn(name = "id_direccion")
            ,uniqueConstraints = @UniqueConstraint(columnNames = {"id_direccion"}))
    private List<Direccion> direcciones;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "cliente")
    private List<Factura> facturas;


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "cliente")

    private ClienteDetalle detalle;



    public Cliente() {
        direcciones = new ArrayList<Direccion>();
        facturas = new ArrayList<Factura>();
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public ClienteDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
        factura.setCliente(this);
    }

    public void removeFactura(Factura factura) {
        this.facturas.remove(factura);
        factura.setCliente(null);
    }

    public void addDetalle (ClienteDetalle detalle){
        this.detalle = detalle;
        detalle.setCliente(this);
    }

    public void removeDetalle (){
        detalle.setCliente(null);
        this.detalle = null;
    }

    @Override
    public String toString() {
        LocalDateTime creado = this.auditoria != null ? auditoria.getCreadoEn():null;
        LocalDateTime modificado = this.auditoria != null ? auditoria.getModificadoEn():null;
        return "{"  + "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", creadoEn='" + creado + '\'' +
                ", modificadoEn='" + modificado + '\'' +
                ", direcciones='" + direcciones + '\'' +
                ", facturas='" + facturas + '\'' +
                ", detalle='" + detalle + '\'' +
                "}";
    }
}
