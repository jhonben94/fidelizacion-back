/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author jhony
 */
@Entity
@Table(name = "concepto_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptoPuntos.findAll", query = "SELECT c FROM ConceptoPuntos c")
    , @NamedQuery(name = "ConceptoPuntos.findByIdConcepto", query = "SELECT c FROM ConceptoPuntos c WHERE c.idConcepto = :idConcepto")
    , @NamedQuery(name = "ConceptoPuntos.findByDescripcion", query = "SELECT c FROM ConceptoPuntos c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ConceptoPuntos.findByPuntosRequeridos", query = "SELECT c FROM ConceptoPuntos c WHERE c.puntosRequeridos = :puntosRequeridos")})
public class ConceptoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_concepto")
    private Integer idConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "puntos_requeridos")
    private String puntosRequeridos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private List<UsoPuntosCab> usoPuntosCabList;

    public ConceptoPuntos() {
    }

    public ConceptoPuntos(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public ConceptoPuntos(Integer idConcepto, String descripcion, String puntosRequeridos) {
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(String puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    @XmlTransient
    public List<UsoPuntosCab> getUsoPuntosCabList() {
        return usoPuntosCabList;
    }

    public void setUsoPuntosCabList(List<UsoPuntosCab> usoPuntosCabList) {
        this.usoPuntosCabList = usoPuntosCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcepto != null ? idConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptoPuntos)) {
            return false;
        }
        ConceptoPuntos other = (ConceptoPuntos) object;
        if ((this.idConcepto == null && other.idConcepto != null) || (this.idConcepto != null && !this.idConcepto.equals(other.idConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.ConceptoPuntos[ idConcepto=" + idConcepto + " ]";
    }
    
}
