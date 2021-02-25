/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "REPORTESCOMPRAS", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportescompras.findAll", query = "SELECT r FROM Reportescompras r")
    , @NamedQuery(name = "Reportescompras.findByCodrc", query = "SELECT r FROM Reportescompras r WHERE r.codrc = :codrc")
    , @NamedQuery(name = "Reportescompras.findByFechareportc", query = "SELECT r FROM Reportescompras r WHERE r.fechareportc = :fechareportc")})
public class Reportescompras implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODRC", nullable = false, precision = 0, scale = -127)
    private BigDecimal codrc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREPORTC", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareportc;
    @JoinColumn(name = "CODCOMPRA", referencedColumnName = "CODCOMPRA")
    @ManyToOne
    private Compra codcompra;

    public Reportescompras() {
    }

    public Reportescompras(BigDecimal codrc) {
        this.codrc = codrc;
    }

    public Reportescompras(BigDecimal codrc, Date fechareportc) {
        this.codrc = codrc;
        this.fechareportc = fechareportc;
    }

    public BigDecimal getCodrc() {
        return codrc;
    }

    public void setCodrc(BigDecimal codrc) {
        this.codrc = codrc;
    }

    public Date getFechareportc() {
        return fechareportc;
    }

    public void setFechareportc(Date fechareportc) {
        this.fechareportc = fechareportc;
    }

    public Compra getCodcompra() {
        return codcompra;
    }

    public void setCodcompra(Compra codcompra) {
        this.codcompra = codcompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrc != null ? codrc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportescompras)) {
            return false;
        }
        Reportescompras other = (Reportescompras) object;
        if ((this.codrc == null && other.codrc != null) || (this.codrc != null && !this.codrc.equals(other.codrc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reportescompras[ codrc=" + codrc + " ]";
    }
    
}
