/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * 
 */
@Entity
@Table(name = "uso_puntos_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoPuntosCab.findAll", query = "SELECT u FROM UsoPuntosCab u")
    , @NamedQuery(name = "UsoPuntosCab.findByIdUsoPuntosCab", query = "SELECT u FROM UsoPuntosCab u WHERE u.idUsoPuntosCab = :idUsoPuntosCab")
    , @NamedQuery(name = "UsoPuntosCab.Consulta.Uso", 
            // AND u.fechaUso =:fechaUso AND u.idConcepto.idConcepto =:idConcepto
            query = "SELECT u FROM UsoPuntosCab u  WHERE u.idCliente.idCliente = :idCliente AND u.fechaUso = :fechaUso")
    , @NamedQuery(name = "UsoPuntosCab.findByPuntajeUtilizado", query = "SELECT u FROM UsoPuntosCab u WHERE u.puntajeUtilizado = :puntajeUtilizado")
    , @NamedQuery(name = "UsoPuntosCab.findByFechaUso", query = "SELECT u FROM UsoPuntosCab u WHERE u.fechaUso = :fechaUso")})
public class UsoPuntosCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uso_puntos_cab")
    private Integer idUsoPuntosCab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_uso")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaUso;
    
    @JsonBackReference("usoPuntosCabecera")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsoPuntosCab")
    private List<UsoPuntosDet> usoPuntosDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")
    @ManyToOne(optional = false)
    private ConceptoPuntos idConcepto;

    public UsoPuntosCab() {
    }

    public UsoPuntosCab(Integer idUsoPuntosCab) {
        this.idUsoPuntosCab = idUsoPuntosCab;
    }

    public UsoPuntosCab(Integer idUsoPuntosCab, int puntajeUtilizado, Date fechaUso) {
        this.idUsoPuntosCab = idUsoPuntosCab;
        this.puntajeUtilizado = puntajeUtilizado;
        this.fechaUso = fechaUso;
    }

    public Integer getIdUsoPuntosCab() {
        return idUsoPuntosCab;
    }

    public void setIdUsoPuntosCab(Integer idUsoPuntosCab) {
        this.idUsoPuntosCab = idUsoPuntosCab;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    @XmlTransient
    public List<UsoPuntosDet> getUsoPuntosDetList() {
        return usoPuntosDetList;
    }

    public void setUsoPuntosDetList(List<UsoPuntosDet> usoPuntosDetList) {
        this.usoPuntosDetList = usoPuntosDetList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public ConceptoPuntos getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(ConceptoPuntos idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsoPuntosCab != null ? idUsoPuntosCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoPuntosCab)) {
            return false;
        }
        UsoPuntosCab other = (UsoPuntosCab) object;
        if ((this.idUsoPuntosCab == null && other.idUsoPuntosCab != null) || (this.idUsoPuntosCab != null && !this.idUsoPuntosCab.equals(other.idUsoPuntosCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.UsoPuntosCab[ idUsoPuntosCab=" + idUsoPuntosCab + " ]";
    }
    
}
