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
@Table(name = "asignacion_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionPuntos.findAll", query = "SELECT a FROM AsignacionPuntos a")
    , @NamedQuery(name = "AsignacionPuntos.findByIdAsignacion", query = "SELECT a FROM AsignacionPuntos a WHERE a.idAsignacion = :idAsignacion")
    , @NamedQuery(name = "AsignacionPuntos.findByLimiteInferior", query = "SELECT a FROM AsignacionPuntos a WHERE a.limiteInferior = :limiteInferior")
    , @NamedQuery(name = "AsignacionPuntos.findByMontoEquivalencia", query = "SELECT a FROM AsignacionPuntos a WHERE a.montoEquivalencia = :montoEquivalencia")
    , @NamedQuery(name = "AsignacionPuntos.findByLimitedaoior", query = "SELECT a FROM AsignacionPuntos a WHERE a.limitedaoior = :limitedaoior")})
public class AsignacionPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_inferior")
    private int limiteInferior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_equivalencia")
    private int montoEquivalencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_daoior")
    private int limitedaoior;

    public AsignacionPuntos() {
    }

    public AsignacionPuntos(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public AsignacionPuntos(Integer idAsignacion, int limiteInferior, int montoEquivalencia, int limitedaoior) {
        this.idAsignacion = idAsignacion;
        this.limiteInferior = limiteInferior;
        this.montoEquivalencia = montoEquivalencia;
        this.limitedaoior = limitedaoior;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(int limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public int getMontoEquivalencia() {
        return montoEquivalencia;
    }

    public void setMontoEquivalencia(int montoEquivalencia) {
        this.montoEquivalencia = montoEquivalencia;
    }

    public int getLimitedaoior() {
        return limitedaoior;
    }

    public void setLimitedaoior(int limitedaoior) {
        this.limitedaoior = limitedaoior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPuntos)) {
            return false;
        }
        AsignacionPuntos other = (AsignacionPuntos) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.AsignacionPuntos[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
