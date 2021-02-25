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
@Table(name = "REPORTESVENTAS", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportesventas.findAll", query = "SELECT r FROM Reportesventas r")
    , @NamedQuery(name = "Reportesventas.findByCodrv", query = "SELECT r FROM Reportesventas r WHERE r.codrv = :codrv")
    , @NamedQuery(name = "Reportesventas.findByFechareportv", query = "SELECT r FROM Reportesventas r WHERE r.fechareportv = :fechareportv")})
public class Reportesventas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODRV", nullable = false, precision = 0, scale = -127)
    private BigDecimal codrv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREPORTV", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareportv;
    @JoinColumn(name = "CODVENTAS", referencedColumnName = "CODVENTA")
    @ManyToOne
    private Venta codventas;

    public Reportesventas() {
    }

    public Reportesventas(BigDecimal codrv) {
        this.codrv = codrv;
    }

    public Reportesventas(BigDecimal codrv, Date fechareportv) {
        this.codrv = codrv;
        this.fechareportv = fechareportv;
    }

    public BigDecimal getCodrv() {
        return codrv;
    }

    public void setCodrv(BigDecimal codrv) {
        this.codrv = codrv;
    }

    public Date getFechareportv() {
        return fechareportv;
    }

    public void setFechareportv(Date fechareportv) {
        this.fechareportv = fechareportv;
    }

    public Venta getCodventas() {
        return codventas;
    }

    public void setCodventas(Venta codventas) {
        this.codventas = codventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrv != null ? codrv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportesventas)) {
            return false;
        }
        Reportesventas other = (Reportesventas) object;
        if ((this.codrv == null && other.codrv != null) || (this.codrv != null && !this.codrv.equals(other.codrv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reportesventas[ codrv=" + codrv + " ]";
    }
    
}
