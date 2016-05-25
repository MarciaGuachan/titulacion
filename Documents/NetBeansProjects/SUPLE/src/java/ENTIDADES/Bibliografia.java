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
@Table(name = "BIBLIOGRAFIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b"),
    @NamedQuery(name = "Bibliografia.findByBiblCodigo", query = "SELECT b FROM Bibliografia b WHERE b.biblCodigo = :biblCodigo"),
    @NamedQuery(name = "Bibliografia.findByBiblTitulo", query = "SELECT b FROM Bibliografia b WHERE b.biblTitulo = :biblTitulo"),
    @NamedQuery(name = "Bibliografia.findByBiblEditorial", query = "SELECT b FROM Bibliografia b WHERE b.biblEditorial = :biblEditorial"),
    @NamedQuery(name = "Bibliografia.findByBiblFechaPublicacion", query = "SELECT b FROM Bibliografia b WHERE b.biblFechaPublicacion = :biblFechaPublicacion"),
    @NamedQuery(name = "Bibliografia.findByBiblIdioma", query = "SELECT b FROM Bibliografia b WHERE b.biblIdioma = :biblIdioma"),
    @NamedQuery(name = "Bibliografia.findByBiblDescripcion", query = "SELECT b FROM Bibliografia b WHERE b.biblDescripcion = :biblDescripcion")})
public class Bibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BIBL_CODIGO")
    private Integer biblCodigo;
    @Size(max = 30)
    @Column(name = "BIBL_TITULO")
    private String biblTitulo;
    @Size(max = 30)
    @Column(name = "BIBL_EDITORIAL")
    private String biblEditorial;
    @Column(name = "BIBL_FECHA_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date biblFechaPublicacion;
    @Size(max = 30)
    @Column(name = "BIBL_IDIOMA")
    private String biblIdioma;
    @Size(max = 30)
    @Column(name = "BIBL_DESCRIPCION")
    private String biblDescripcion;
    @OneToMany(mappedBy = "biblCodigo")
    private Collection<DetalleBiblioFacu> detalleBiblioFacuCollection;
    @JoinColumn(name = "AREA_CODIGO", referencedColumnName = "AREA_CODIGO")
    @ManyToOne
    private Area areaCodigo;
    @JoinColumn(name = "AUTOR_CODIGO", referencedColumnName = "AUTOR_CODIGO")
    @ManyToOne
    private Autor autorCodigo;
    @JoinColumn(name = "TIBI_CODIGO", referencedColumnName = "TIBI_CODIGO")
    @ManyToOne
    private TipoBibliografia tibiCodigo;

    public Bibliografia() {
    }

    public Bibliografia(Integer biblCodigo) {
        this.biblCodigo = biblCodigo;
    }

    public Integer getBiblCodigo() {
        return biblCodigo;
    }

    public void setBiblCodigo(Integer biblCodigo) {
        this.biblCodigo = biblCodigo;
    }

    public String getBiblTitulo() {
        return biblTitulo;
    }

    public void setBiblTitulo(String biblTitulo) {
        this.biblTitulo = biblTitulo;
    }

    public String getBiblEditorial() {
        return biblEditorial;
    }

    public void setBiblEditorial(String biblEditorial) {
        this.biblEditorial = biblEditorial;
    }

    public Date getBiblFechaPublicacion() {
        return biblFechaPublicacion;
    }

    public void setBiblFechaPublicacion(Date biblFechaPublicacion) {
        this.biblFechaPublicacion = biblFechaPublicacion;
    }

    public String getBiblIdioma() {
        return biblIdioma;
    }

    public void setBiblIdioma(String biblIdioma) {
        this.biblIdioma = biblIdioma;
    }

    public String getBiblDescripcion() {
        return biblDescripcion;
    }

    public void setBiblDescripcion(String biblDescripcion) {
        this.biblDescripcion = biblDescripcion;
    }

    @XmlTransient
    public Collection<DetalleBiblioFacu> getDetalleBiblioFacuCollection() {
        return detalleBiblioFacuCollection;
    }

    public void setDetalleBiblioFacuCollection(Collection<DetalleBiblioFacu> detalleBiblioFacuCollection) {
        this.detalleBiblioFacuCollection = detalleBiblioFacuCollection;
    }

    public Area getAreaCodigo() {
        return areaCodigo;
    }

    public void setAreaCodigo(Area areaCodigo) {
        this.areaCodigo = areaCodigo;
    }

    public Autor getAutorCodigo() {
        return autorCodigo;
    }

    public void setAutorCodigo(Autor autorCodigo) {
        this.autorCodigo = autorCodigo;
    }

    public TipoBibliografia getTibiCodigo() {
        return tibiCodigo;
    }

    public void setTibiCodigo(TipoBibliografia tibiCodigo) {
        this.tibiCodigo = tibiCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biblCodigo != null ? biblCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliografia)) {
            return false;
        }
        Bibliografia other = (Bibliografia) object;
        if ((this.biblCodigo == null && other.biblCodigo != null) || (this.biblCodigo != null && !this.biblCodigo.equals(other.biblCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.Bibliografia[ biblCodigo=" + biblCodigo + " ]";
    }
    
}
