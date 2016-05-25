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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUserCodigo", query = "SELECT u FROM Usuario u WHERE u.userCodigo = :userCodigo"),
    @NamedQuery(name = "Usuario.findByUserNombre", query = "SELECT u FROM Usuario u WHERE u.userNombre = :userNombre"),
    @NamedQuery(name = "Usuario.findByUserApellido", query = "SELECT u FROM Usuario u WHERE u.userApellido = :userApellido"),
    @NamedQuery(name = "Usuario.findByUserEmail", query = "SELECT u FROM Usuario u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Usuario.findByUserTelefono", query = "SELECT u FROM Usuario u WHERE u.userTelefono = :userTelefono"),
    @NamedQuery(name = "Usuario.findByUserDireccion", query = "SELECT u FROM Usuario u WHERE u.userDireccion = :userDireccion"),
    @NamedQuery(name = "Usuario.findByUserUsername", query = "SELECT u FROM Usuario u WHERE u.userUsername = :userUsername"),
    @NamedQuery(name = "Usuario.findByUserPassword", query = "SELECT u FROM Usuario u WHERE u.userPassword = :userPassword")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "USER_CODIGO")
    private Integer userCodigo;
    @Size(max = 30)
    @Column(name = "USER_NOMBRE")
    private String userNombre;
    @Size(max = 30)
    @Column(name = "USER_APELLIDO")
    private String userApellido;
    @Size(max = 30)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Size(max = 30)
    @Column(name = "USER_TELEFONO")
    private String userTelefono;
    @Size(max = 30)
    @Column(name = "USER_DIRECCION")
    private String userDireccion;
    @Size(max = 30)
    @Column(name = "USER_USERNAME")
    private String userUsername;
    @Size(max = 30)
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @OneToMany(mappedBy = "userCodigo")
    private Collection<Prestamo> prestamoCollection;
    @JoinColumn(name = "TIUS_CODIGO", referencedColumnName = "TIUS_CODIGO")
    @ManyToOne
    private TipoUsuario tiusCodigo;

    public Usuario() {
    }

    public Usuario(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public Integer getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTelefono() {
        return userTelefono;
    }

    public void setUserTelefono(String userTelefono) {
        this.userTelefono = userTelefono;
    }

    public String getUserDireccion() {
        return userDireccion;
    }

    public void setUserDireccion(String userDireccion) {
        this.userDireccion = userDireccion;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    public TipoUsuario getTiusCodigo() {
        return tiusCodigo;
    }

    public void setTiusCodigo(TipoUsuario tiusCodigo) {
        this.tiusCodigo = tiusCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCodigo != null ? userCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.userCodigo == null && other.userCodigo != null) || (this.userCodigo != null && !this.userCodigo.equals(other.userCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.Usuario[ userCodigo=" + userCodigo + " ]";
    }
    
}
