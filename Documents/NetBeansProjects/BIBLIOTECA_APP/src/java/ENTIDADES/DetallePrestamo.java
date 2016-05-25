/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARCIAELIZABETH
 */
@Entity
@Table(name = "DETALLE_PRESTAMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePrestamo.findAll", query = "SELECT d FROM DetallePrestamo d"),
    @NamedQuery(name = "DetallePrestamo.findByDeprCodigo", query = "SELECT d FROM DetallePrestamo d WHERE d.deprCodigo = :deprCodigo"),
    @NamedQuery(name = "DetallePrestamo.findByDeprEstado", query = "SELECT d FROM DetallePrestamo d WHERE d.deprEstado = :deprEstado")})
public class DetallePrestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "DEPR_CODIGO")
    private Integer deprCodigo;
    @Size(max = 30)
    @Column(name = "DEPR_ESTADO")
    private String deprEstado;
    @JoinColumn(name = "DTBF_CODIGO", referencedColumnName = "DTBF_CODIGO")
    @ManyToOne
    private DetalleBiblioFacu dtbfCodigo;
    @JoinColumn(name = "PRES_CODIGO", referencedColumnName = "PRES_CODIGO")
    @ManyToOne
    private Prestamo presCodigo;

    public DetallePrestamo() {
    }

    public DetallePrestamo(Integer deprCodigo) {
        this.deprCodigo = deprCodigo;
    }

    public Integer getDeprCodigo() {
        return deprCodigo;
    }

    public void setDeprCodigo(Integer deprCodigo) {
        this.deprCodigo = deprCodigo;
    }

    public String getDeprEstado() {
        return deprEstado;
    }

    public void setDeprEstado(String deprEstado) {
        this.deprEstado = deprEstado;
    }

    public DetalleBiblioFacu getDtbfCodigo() {
        return dtbfCodigo;
    }

    public void setDtbfCodigo(DetalleBiblioFacu dtbfCodigo) {
        this.dtbfCodigo = dtbfCodigo;
    }

    public Prestamo getPresCodigo() {
        return presCodigo;
    }

    public void setPresCodigo(Prestamo presCodigo) {
        this.presCodigo = presCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deprCodigo != null ? deprCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrestamo)) {
            return false;
        }
        DetallePrestamo other = (DetallePrestamo) object;
        if ((this.deprCodigo == null && other.deprCodigo != null) || (this.deprCodigo != null && !this.deprCodigo.equals(other.deprCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.DetallePrestamo[ deprCodigo=" + deprCodigo + " ]";
    }
    
}
