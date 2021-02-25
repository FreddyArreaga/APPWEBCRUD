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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "PRODUCTO", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigop", query = "SELECT p FROM Producto p WHERE p.codigop = :codigop")
    , @NamedQuery(name = "Producto.findByNombrep", query = "SELECT p FROM Producto p WHERE p.nombrep = :nombrep")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")
    , @NamedQuery(name = "Producto.findByDetalle", query = "SELECT p FROM Producto p WHERE p.detalle = :detalle")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOP", nullable = false, precision = 0, scale = -127)
    private BigDecimal codigop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREP", nullable = false, length = 30)
    private String nombrep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO", nullable = false, precision = 6, scale = 2)
    private BigDecimal precio;
    @Column(name = "STOCK", precision = 6, scale = 2)
    private BigDecimal stock;
    @Size(max = 30)
    @Column(name = "DETALLE", length = 30)
    private String detalle;
    @OneToMany(mappedBy = "codproducto")
    private List<Detalleventa> detalleventaList;
    @OneToMany(mappedBy = "codproducto")
    private List<Detallecompra> detallecompraList;

    public Producto() {
    }

    public Producto(BigDecimal codigop) {
        this.codigop = codigop;
    }

    public Producto(BigDecimal codigop, String nombrep, BigDecimal precio) {
        this.codigop = codigop;
        this.nombrep = nombrep;
        this.precio = precio;
    }

    public BigDecimal getCodigop() {
        return codigop;
    }

    public void setCodigop(BigDecimal codigop) {
        this.codigop = codigop;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    @XmlTransient
    public List<Detallecompra> getDetallecompraList() {
        return detallecompraList;
    }

    public void setDetallecompraList(List<Detallecompra> detallecompraList) {
        this.detallecompraList = detallecompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigop != null ? codigop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigop == null && other.codigop != null) || (this.codigop != null && !this.codigop.equals(other.codigop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto[ codigop=" + codigop + " ]";
    }
    
}
