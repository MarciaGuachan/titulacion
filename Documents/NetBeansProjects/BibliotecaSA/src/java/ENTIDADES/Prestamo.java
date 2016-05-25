/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARCIAELIZABETH
 */
@Entity
@Table(name = "PRESTAMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByPresCodigo", query = "SELECT p FROM Prestamo p WHERE p.presCodigo = :presCodigo"),
    @NamedQuery(name = "Prestamo.findByPresFechaReserva", query = "SELECT p FROM Prestamo p WHERE p.presFechaReserva = :presFechaReserva"),
    @NamedQuery(name = "Prestamo.findByPresFechaFinReserva", query = "SELECT p FROM Prestamo p WHERE p.presFechaFinReserva = :presFechaFinReserva"),
    @NamedQuery(name = "Prestamo.findByPresFechaEntrega", query = "SELECT p FROM Prestamo p WHERE p.presFechaEntrega = :presFechaEntrega"),
    @NamedQuery(name = "Prestamo.findByPresFechaMaxRecepcion", query = "SELECT p FROM Prestamo p WHERE p.presFechaMaxRecepcion = :presFechaMaxRecepcion"),
    @NamedQuery(name = "Prestamo.findByPresEstado", query = "SELECT p FROM Prestamo p WHERE p.presEstado = :presEstado"),
    @NamedQuery(name = "Prestamo.findByPresObservacion", query = "SELECT p FROM Prestamo p WHERE p.presObservacion = :presObservacion"),
    @NamedQuery(name = "Prestamo.findByPresFechaRecepcion", query = "SELECT p FROM Prestamo p WHERE p.presFechaRecepcion = :presFechaRecepcion")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "PRES_CODIGO")
    private Integer presCodigo;
    @Column(name = "PRES_FECHA_RESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaReserva;
    @Column(name = "PRES_FECHA_FIN_RESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaFinReserva;
    @Column(name = "PRES_FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaEntrega;
    @Column(name = "PRES_FECHA_MAX_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaMaxRecepcion;
    @Size(max = 30)
    @Column(name = "PRES_ESTADO")
    private String presEstado;
    @Size(max = 30)
    @Column(name = "PRES_OBSERVACION")
    private String presObservacion;
    @Column(name = "PRES_FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaRecepcion;
    @OneToMany(mappedBy = "presCodigo")
    private Collection<DetallePrestamo> detallePrestamoCollection;
    @JoinColumn(name = "USER_CODIGO", referencedColumnName = "USER_CODIGO")
    @ManyToOne
    private Usuario userCodigo;

    public Prestamo() {
    }

    public Prestamo(Integer presCodigo) {
        this.presCodigo = presCodigo;
    }

    public Integer getPresCodigo() {
        return presCodigo;
    }

    public void setPresCodigo(Integer presCodigo) {
        this.presCodigo = presCodigo;
    }

    public Date getPresFechaReserva() {
        return presFechaReserva;
    }

    public void setPresFechaReserva(Date presFechaReserva) {
        this.presFechaReserva = presFechaReserva;
    }

    public Date getPresFechaFinReserva() {
        return presFechaFinReserva;
    }

    public void setPresFechaFinReserva(Date presFechaFinReserva) {
        this.presFechaFinReserva = presFechaFinReserva;
    }

    public Date getPresFechaEntrega() {
        return presFechaEntrega;
    }

    public void setPresFechaEntrega(Date presFechaEntrega) {
        this.presFechaEntrega = presFechaEntrega;
    }

    public Date getPresFechaMaxRecepcion() {
        return presFechaMaxRecepcion;
    }

    public void setPresFechaMaxRecepcion(Date presFechaMaxRecepcion) {
        this.presFechaMaxRecepcion = presFechaMaxRecepcion;
    }

    public String getPresEstado() {
        return presEstado;
    }

    public void setPresEstado(String presEstado) {
        this.presEstado = presEstado;
    }

    public String getPresObservacion() {
        return presObservacion;
    }

    public void setPresObservacion(String presObservacion) {
        this.presObservacion = presObservacion;
    }

    public Date getPresFechaRecepcion() {
        return presFechaRecepcion;
    }

    public void setPresFechaRecepcion(Date presFechaRecepcion) {
        this.presFechaRecepcion = presFechaRecepcion;
    }

    @XmlTransient
    public Collection<DetallePrestamo> getDetallePrestamoCollection() {
        return detallePrestamoCollection;
    }

    public void setDetallePrestamoCollection(Collection<DetallePrestamo> detallePrestamoCollection) {
        this.detallePrestamoCollection = detallePrestamoCollection;
    }

    public Usuario getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(Usuario userCodigo) {
        this.userCodigo = userCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presCodigo != null ? presCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.presCodigo == null && other.presCodigo != null) || (this.presCodigo != null && !this.presCodigo.equals(other.presCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.Prestamo[ presCodigo=" + presCodigo + " ]";
    }
    
}
