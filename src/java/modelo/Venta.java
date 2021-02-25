/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "VENTA", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodventa", query = "SELECT v FROM Venta v WHERE v.codventa = :codventa")
    , @NamedQuery(name = "Venta.findByFechaventa", query = "SELECT v FROM Venta v WHERE v.fechaventa = :fechaventa")
    , @NamedQuery(name = "Venta.findByMonto", query = "SELECT v FROM Venta v WHERE v.monto = :monto")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODVENTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal codventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAVENTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO", nullable = false, precision = 6, scale = 2)
    private BigDecimal monto;
    @JoinColumn(name = "CODCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne
    private Cliente codcliente;
    @JoinColumn(name = "CODDETALLEVENTA", referencedColumnName = "CODDV")
    @ManyToOne
    private Detalleventa coddetalleventa;
    @JoinColumn(name = "CODUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario codusuario;
    @OneToMany(mappedBy = "codventas")
    private List<Reportesventas> reportesventasList;

    public Venta() {
    }

    public Venta(BigDecimal codventa) {
        this.codventa = codventa;
    }

    public Venta(BigDecimal codventa, Date fechaventa, BigDecimal monto) {
        this.codventa = codventa;
        this.fechaventa = fechaventa;
        this.monto = monto;
    }

    public BigDecimal getCodventa() {
        return codventa;
    }

    public void setCodventa(BigDecimal codventa) {
        this.codventa = codventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Cliente getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Cliente codcliente) {
        this.codcliente = codcliente;
    }

    public Detalleventa getCoddetalleventa() {
        return coddetalleventa;
    }

    public void setCoddetalleventa(Detalleventa coddetalleventa) {
        this.coddetalleventa = coddetalleventa;
    }

    public Usuario getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Usuario codusuario) {
        this.codusuario = codusuario;
    }

    @XmlTransient
    public List<Reportesventas> getReportesventasList() {
        return reportesventasList;
    }

    public void setReportesventasList(List<Reportesventas> reportesventasList) {
        this.reportesventasList = reportesventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codventa != null ? codventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codventa == null && other.codventa != null) || (this.codventa != null && !this.codventa.equals(other.codventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ codventa=" + codventa + " ]";
    }
    
}
