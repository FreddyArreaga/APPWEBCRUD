/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "DETALLEVENTA", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByCoddv", query = "SELECT d FROM Detalleventa d WHERE d.coddv = :coddv")
    , @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalleventa.findByPrecioventa", query = "SELECT d FROM Detalleventa d WHERE d.precioventa = :precioventa")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDV", nullable = false, precision = 0, scale = -127)
    private BigDecimal coddv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false, precision = 6, scale = 2)
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOVENTA", nullable = false, precision = 6, scale = 2)
    private BigDecimal precioventa;
    @OneToMany(mappedBy = "coddetalleventa")
    private List<Venta> ventaList;
    @JoinColumn(name = "CODPRODUCTO", referencedColumnName = "CODIGOP")
    @ManyToOne
    private Producto codproducto;

    public Detalleventa() {
    }

    public Detalleventa(BigDecimal coddv) {
        this.coddv = coddv;
    }

    public Detalleventa(BigDecimal coddv, BigDecimal cantidad, BigDecimal precioventa) {
        this.coddv = coddv;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
    }

    public BigDecimal getCoddv() {
        return coddv;
    }

    public void setCoddv(BigDecimal coddv) {
        this.coddv = coddv;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Producto getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Producto codproducto) {
        this.codproducto = codproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddv != null ? coddv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.coddv == null && other.coddv != null) || (this.coddv != null && !this.coddv.equals(other.coddv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detalleventa[ coddv=" + coddv + " ]";
    }
    
}
