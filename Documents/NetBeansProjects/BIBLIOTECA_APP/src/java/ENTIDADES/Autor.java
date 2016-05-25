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
@Table(name = "AUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByAutorCodigo", query = "SELECT a FROM Autor a WHERE a.autorCodigo = :autorCodigo"),
    @NamedQuery(name = "Autor.findByAutorNombre", query = "SELECT a FROM Autor a WHERE a.autorNombre = :autorNombre"),
    @NamedQuery(name = "Autor.findByAutorDescripcion", query = "SELECT a FROM Autor a WHERE a.autorDescripcion = :autorDescripcion")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "AUTOR_CODIGO")
    private Integer autorCodigo;
    @Size(max = 30)
    @Column(name = "AUTOR_NOMBRE")
    private String autorNombre;
    @Size(max = 30)
    @Column(name = "AUTOR_DESCRIPCION")
    private String autorDescripcion;
    @OneToMany(mappedBy = "autorCodigo")
    private Collection<Bibliografia> bibliografiaCollection;

    public Autor() {
    }

    public Autor(Integer autorCodigo) {
        this.autorCodigo = autorCodigo;
    }

    public Integer getAutorCodigo() {
        return autorCodigo;
    }

    public void setAutorCodigo(Integer autorCodigo) {
        this.autorCodigo = autorCodigo;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getAutorDescripcion() {
        return autorDescripcion;
    }

    public void setAutorDescripcion(String autorDescripcion) {
        this.autorDescripcion = autorDescripcion;
    }

    @XmlTransient
    public Collection<Bibliografia> getBibliografiaCollection() {
        return bibliografiaCollection;
    }

    public void setBibliografiaCollection(Collection<Bibliografia> bibliografiaCollection) {
        this.bibliografiaCollection = bibliografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorCodigo != null ? autorCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.autorCodigo == null && other.autorCodigo != null) || (this.autorCodigo != null && !this.autorCodigo.equals(other.autorCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.Autor[ autorCodigo=" + autorCodigo + " ]";
    }
    
}
