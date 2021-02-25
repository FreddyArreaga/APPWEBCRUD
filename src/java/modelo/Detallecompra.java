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
@Table(name = "DETALLECOMPRA", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompra.findAll", query = "SELECT d FROM Detallecompra d")
    , @NamedQuery(name = "Detallecompra.findByCoddc", query = "SELECT d FROM Detallecompra d WHERE d.coddc = :coddc")
    , @NamedQuery(name = "Detallecompra.findByCantidad", query = "SELECT d FROM Detallecompra d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallecompra.findByPreciocompra", query = "SELECT d FROM Detallecompra d WHERE d.preciocompra = :preciocompra")})
public class Detallecompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDC", nullable = false, precision = 0, scale = -127)
    private BigDecimal coddc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false, precision = 6, scale = 2)
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOCOMPRA", nullable = false, precision = 6, scale = 2)
    private BigDecimal preciocompra;
    @OneToMany(mappedBy = "coddetallecompra")
    private List<Compra> compraList;
    @JoinColumn(name = "CODPRODUCTO", referencedColumnName = "CODIGOP")
    @ManyToOne
    private Producto codproducto;

    public Detallecompra() {
    }

    public Detallecompra(BigDecimal coddc) {
        this.coddc = coddc;
    }

    public Detallecompra(BigDecimal coddc, BigDecimal cantidad, BigDecimal preciocompra) {
        this.coddc = coddc;
        this.cantidad = cantidad;
        this.preciocompra = preciocompra;
    }

    public BigDecimal getCoddc() {
        return coddc;
    }

    public void setCoddc(BigDecimal coddc) {
        this.coddc = coddc;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(BigDecimal preciocompra) {
        this.preciocompra = preciocompra;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
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
        hash += (coddc != null ? coddc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompra)) {
            return false;
        }
        Detallecompra other = (Detallecompra) object;
        if ((this.coddc == null && other.coddc != null) || (this.coddc != null && !this.coddc.equals(other.coddc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detallecompra[ coddc=" + coddc + " ]";
    }
    
}
