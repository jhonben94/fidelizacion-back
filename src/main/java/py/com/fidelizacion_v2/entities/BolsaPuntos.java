/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.entities;

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
@Table(name = "bolsa_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BolsaPuntos.findAll", query = "SELECT b FROM BolsaPuntos b")
    , @NamedQuery(name = "BolsaPuntos.findByIdBolsa", query = "SELECT b FROM BolsaPuntos b WHERE b.idBolsa = :idBolsa")
    , @NamedQuery(name = "BolsaPuntos.findByIdCliente", query = "SELECT b FROM BolsaPuntos b WHERE b.idCliente.idCliente = :idCliente")
    , @NamedQuery(name = "BolsaPuntos.findByFechaAsignacion", query = "SELECT b FROM BolsaPuntos b WHERE b.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "BolsaPuntos.findByFechaCaducidad", query = "SELECT b FROM BolsaPuntos b WHERE b.fechaCaducidad = :fechaCaducidad")
    , @NamedQuery(name = "BolsaPuntos.findByPuntajeAsignado", query = "SELECT b FROM BolsaPuntos b WHERE b.puntajeAsignado = :puntajeAsignado")
    , @NamedQuery(name = "BolsaPuntos.findByPuntajeUtilizado", query = "SELECT b FROM BolsaPuntos b WHERE b.puntajeUtilizado = :puntajeUtilizado")
    , @NamedQuery(name = "BolsaPuntos.findBySaldoPuntos", query = "SELECT b FROM BolsaPuntos b WHERE b.saldoPuntos = :saldoPuntos")
    , @NamedQuery(name = "BolsaPuntos.findByMontoOperacion", query = "SELECT b FROM BolsaPuntos b WHERE b.montoOperacion = :montoOperacion")})
public class BolsaPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bolsa")
    private Integer idBolsa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_asignado")
    private int puntajeAsignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_puntos")
    private int saldoPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_operacion")
    private int montoOperacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBolsa")
    private List<UsoPuntosDet> usoPuntosDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public BolsaPuntos() {
    }

    public BolsaPuntos(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }

    public BolsaPuntos(Integer idBolsa, Date fechaAsignacion, Date fechaCaducidad, int puntajeAsignado, int puntajeUtilizado, int saldoPuntos, int montoOperacion) {
        this.idBolsa = idBolsa;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaCaducidad = fechaCaducidad;
        this.puntajeAsignado = puntajeAsignado;
        this.puntajeUtilizado = puntajeUtilizado;
        this.saldoPuntos = saldoPuntos;
        this.montoOperacion = montoOperacion;
    }

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(int puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public int getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(int saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public int getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(int montoOperacion) {
        this.montoOperacion = montoOperacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBolsa != null ? idBolsa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsaPuntos)) {
            return false;
        }
        BolsaPuntos other = (BolsaPuntos) object;
        if ((this.idBolsa == null && other.idBolsa != null) || (this.idBolsa != null && !this.idBolsa.equals(other.idBolsa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.fidelizacion_v2.entities.BolsaPuntos[ idBolsa=" + idBolsa + " ]";
    }
    
}
