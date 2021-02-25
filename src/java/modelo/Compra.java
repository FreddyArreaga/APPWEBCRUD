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
@Table(name = "COMPRA", catalog = "", schema = "DATABASEG3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByCodcompra", query = "SELECT c FROM Compra c WHERE c.codcompra = :codcompra")
    , @NamedQuery(name = "Compra.findByFechacompra", query = "SELECT c FROM Compra c WHERE c.fechacompra = :fechacompra")
    , @NamedQuery(name = "Compra.findByMonto", query = "SELECT c FROM Compra c WHERE c.monto = :monto")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCOMPRA", nullable = false, precision = 0, scale = -127)
    private BigDecimal codcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACOMPRA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO", nullable = false, precision = 6, scale = 2)
    private BigDecimal monto;
    @OneToMany(mappedBy = "codcompra")
    private List<Reportescompras> reportescomprasList;
    @JoinColumn(name = "CODDETALLECOMPRA", referencedColumnName = "CODDC")
    @ManyToOne
    private Detallecompra coddetallecompra;
    @JoinColumn(name = "CODPROVEEDOR", referencedColumnName = "IDPROVEEDOR")
    @ManyToOne
    private Proveedor codproveedor;

    public Compra() {
    }

    public Compra(BigDecimal codcompra) {
        this.codcompra = codcompra;
    }

    public Compra(BigDecimal codcompra, Date fechacompra, BigDecimal monto) {
        this.codcompra = codcompra;
        this.fechacompra = fechacompra;
        this.monto = monto;
    }

    public BigDecimal getCodcompra() {
        return codcompra;
    }

    public void setCodcompra(BigDecimal codcompra) {
        this.codcompra = codcompra;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @XmlTransient
    public List<Reportescompras> getReportescomprasList() {
        return reportescomprasList;
    }

    public void setReportescomprasList(List<Reportescompras> reportescomprasList) {
        this.reportescomprasList = reportescomprasList;
    }

    public Detallecompra getCoddetallecompra() {
        return coddetallecompra;
    }

    public void setCoddetallecompra(Detallecompra coddetallecompra) {
        this.coddetallecompra = coddetallecompra;
    }

    public Proveedor getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(Proveedor codproveedor) {
        this.codproveedor = codproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcompra != null ? codcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.codcompra == null && other.codcompra != null) || (this.codcompra != null && !this.codcompra.equals(other.codcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ codcompra=" + codcompra + " ]";
    }
    
}
