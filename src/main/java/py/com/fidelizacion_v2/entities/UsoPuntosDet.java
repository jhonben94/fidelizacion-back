/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "uso_puntos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoPuntosDet.findAll", query = "SELECT u FROM UsoPuntosDet u")
    , @NamedQuery(name = "UsoPuntosDet.findByIdUsoPuntosDet", query = "SELECT u FROM UsoPuntosDet u WHERE u.idUsoPuntosDet = :idUsoPuntosDet")
    , @NamedQuery(name = "UsoPuntosDet.findByPuntajeUtilizado", query = "SELECT u FROM UsoPuntosDet u WHERE u.puntajeUtilizado = :puntajeUtilizado")})
public class UsoPuntosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uso_puntos_det")
    private Integer idUsoPuntosDet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @JoinColumn(name = "id_bolsa", referencedColumnName = "id_bolsa")
    @ManyToOne(optional = false)
    private BolsaPuntos idBolsa;
    @JoinColumn(name = "id_uso_puntos_cab", referencedColumnName = "id_uso_puntos_cab")
    @ManyToOne(optional = false)
    private UsoPuntosCab idUsoPuntosCab;

    public UsoPuntosDet() {
    }

    public UsoPuntosDet(Integer idUsoPuntosDet) {
        this.idUsoPuntosDet = idUsoPuntosDet;
    }

    public UsoPuntosDet(Integer idUsoPuntosDet, int puntajeUtilizado) {
        this.idUsoPuntosDet = idUsoPuntosDet;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getIdUsoPuntosDet() {
        return idUsoPuntosDet;
    }

    public void setIdUsoPuntosDet(Integer idUsoPuntosDet) {
        this.idUsoPuntosDet = idUsoPuntosDet;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public BolsaPuntos getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(BolsaPuntos idBolsa) {
        this.idBolsa = idBolsa;
    }

    public UsoPuntosCab getIdUsoPuntosCab() {
        return idUsoPuntosCab;
    }

    public void setIdUsoPuntosCab(UsoPuntosCab idUsoPuntosCab) {
        this.idUsoPuntosCab = idUsoPuntosCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsoPuntosDet != null ? idUsoPuntosDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoPuntosDet)) {
            return false;
        }
        UsoPuntosDet other = (UsoPuntosDet) object;
        if ((this.idUsoPuntosDet == null && other.idUsoPuntosDet != null) || (this.idUsoPuntosDet != null && !this.idUsoPuntosDet.equals(other.idUsoPuntosDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.UsoPuntosDet[ idUsoPuntosDet=" + idUsoPuntosDet + " ]";
    }
    
}
