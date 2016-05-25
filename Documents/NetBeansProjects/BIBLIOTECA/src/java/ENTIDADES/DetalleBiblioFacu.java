/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author MARCIAELIZABETH
 */
@Entity
@Table(name = "DETALLE_BIBLIO_FACU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleBiblioFacu.findAll", query = "SELECT d FROM DetalleBiblioFacu d"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfCodigo", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfCodigo = :dtbfCodigo"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfStock", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfStock = :dtbfStock"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfEstado", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfEstado = :dtbfEstado")})
public class DetalleBiblioFacu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DTBF_CODIGO")
    private Integer dtbfCodigo;
    @Column(name = "DTBF_STOCK")
    private Integer dtbfStock;
    @Size(max = 30)
    @Column(name = "DTBF_ESTADO")
    private String dtbfEstado;
    @OneToMany(mappedBy = "dtbfCodigo")
    private Collection<DetallePrestamo> detallePrestamoCollection;
    @JoinColumn(name = "BIBL_CODIGO", referencedColumnName = "BIBL_CODIGO")
    @ManyToOne
    private Bibliografia biblCodigo;
    @JoinColumn(name = "FACU_CODIGO", referencedColumnName = "FACU_CODIGO")
    @ManyToOne
    private Facultad facuCodigo;

    public DetalleBiblioFacu() {
    }

    public DetalleBiblioFacu(Integer dtbfCodigo) {
        this.dtbfCodigo = dtbfCodigo;
    }

    public Integer getDtbfCodigo() {
        return dtbfCodigo;
    }

    public void setDtbfCodigo(Integer dtbfCodigo) {
        this.dtbfCodigo = dtbfCodigo;
    }

    public Integer getDtbfStock() {
        return dtbfStock;
    }

    public void setDtbfStock(Integer dtbfStock) {
        this.dtbfStock = dtbfStock;
    }

    public String getDtbfEstado() {
        return dtbfEstado;
    }

    public void setDtbfEstado(String dtbfEstado) {
        this.dtbfEstado = dtbfEstado;
    }

    @XmlTransient
    public Collection<DetallePrestamo> getDetallePrestamoCollection() {
        return detallePrestamoCollection;
    }

    public void setDetallePrestamoCollection(Collection<DetallePrestamo> detallePrestamoCollection) {
        this.detallePrestamoCollection = detallePrestamoCollection;
    }

    public Bibliografia getBiblCodigo() {
        return biblCodigo;
    }

    public void setBiblCodigo(Bibliografia biblCodigo) {
        this.biblCodigo = biblCodigo;
    }

    public Facultad getFacuCodigo() {
        return facuCodigo;
    }

    public void setFacuCodigo(Facultad facuCodigo) {
        this.facuCodigo = facuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtbfCodigo != null ? dtbfCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleBiblioFacu)) {
            return false;
        }
        DetalleBiblioFacu other = (DetalleBiblioFacu) object;
        if ((this.dtbfCodigo == null && other.dtbfCodigo != null) || (this.dtbfCodigo != null && !this.dtbfCodigo.equals(other.dtbfCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.DetalleBiblioFacu[ dtbfCodigo=" + dtbfCodigo + " ]";
    }
    
}
