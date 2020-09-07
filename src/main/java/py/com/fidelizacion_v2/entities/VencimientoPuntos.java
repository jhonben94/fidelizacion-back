/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "vencimiento_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VencimientoPuntos.findAll", query = "SELECT v FROM VencimientoPuntos v")
    , @NamedQuery(name = "VencimientoPuntos.findByIdVencimiento", query = "SELECT v FROM VencimientoPuntos v WHERE v.idVencimiento = :idVencimiento")
    , @NamedQuery(name = "VencimientoPuntos.findByFechaInicio", query = "SELECT v FROM VencimientoPuntos v WHERE v.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "VencimientoPuntos.findByFechaFin", query = "SELECT v FROM VencimientoPuntos v WHERE v.fechaFin = :fechaFin")
    , @NamedQuery(name = "VencimientoPuntos.findByDiasDuracion", query = "SELECT v FROM VencimientoPuntos v WHERE v.diasDuracion = :diasDuracion")})
public class VencimientoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vencimiento")
    private Integer idVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_duracion")
    private int diasDuracion;

    public VencimientoPuntos() {
    }

    public VencimientoPuntos(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public VencimientoPuntos(Integer idVencimiento, Date fechaInicio, Date fechaFin, int diasDuracion) {
        this.idVencimiento = idVencimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasDuracion = diasDuracion;
    }

    public Integer getIdVencimiento() {
        return idVencimiento;
    }

    public void setIdVencimiento(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(int diasDuracion) {
        this.diasDuracion = diasDuracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVencimiento != null ? idVencimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VencimientoPuntos)) {
            return false;
        }
        VencimientoPuntos other = (VencimientoPuntos) object;
        if ((this.idVencimiento == null && other.idVencimiento != null) || (this.idVencimiento != null && !this.idVencimiento.equals(other.idVencimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.VencimientoPuntos[ idVencimiento=" + idVencimiento + " ]";
    }
    
}
