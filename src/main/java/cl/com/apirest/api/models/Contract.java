package cl.com.apirest.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contratos")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "fecha_contrato")
    private String fechaContrato;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "nombre_trabajador")
    private String nombreTrabajador;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "edad")
    private int edad;

    @Column(unique = true, name = "rut")
    private String rut;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "region")
    private String region;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "email")
    private String email;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "tipo_contrato")
    private String tipoContrato;

    @Column(name = "sueldo")
    private int sueldo;

    public Contract() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Id=" + Id +
                ", fechaContrato='" + fechaContrato + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", nombreTrabajador='" + nombreTrabajador + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                ", rut='" + rut + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", region='" + region + '\'' +
                ", numeroContacto='" + numeroContacto + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", tipoContrato='" + tipoContrato + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
