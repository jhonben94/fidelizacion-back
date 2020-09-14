/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import py.com.fidelizacion_v2.entities.BolsaPuntos;
import py.com.fidelizacion_v2.entities.UsoPuntosCab;
import py.com.fidelizacion_v2.entities.UsoPuntosDet;
import py.com.fidelizacion_v2.model.params.ConsultaUsoPuntosParam;
import py.com.fidelizacion_v2.util.Globales;

/**
 *
 * 
 */
@Stateless
public class UsoPuntosCabDAO extends AbstractDAO<UsoPuntosCab >{
    
    @PersistenceContext(unitName = Globales.unitName)
    private EntityManager em;

    public UsoPuntosCabDAO() {
        super(UsoPuntosCab.class);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }
     public List<UsoPuntosCab> consultaUso( ConsultaUsoPuntosParam param){
         List<UsoPuntosCab> respuesta = (List<UsoPuntosCab>) em.createNamedQuery("UsoPuntosCab.Consulta.Uso")
                                        .setParameter("idCliente", param.getIdCliente())
                                        .setParameter("fechaUso",Globales.localToTimeStamp(param.getFecha()))
                                        .setParameter("idConcepto", param.getIdConcepto())
                                        .getResultList();
        return respuesta;
    }
     
     public UsoPuntosCab obtener( ConsultaUsoPuntosParam param){
         UsoPuntosCab respuesta = (UsoPuntosCab) em.createNamedQuery("UsoPuntosCab.Consulta.Cab")
                                        .setParameter("idConcepto", param.getIdConcepto())
                                        .getSingleResult();
        return respuesta;
    }
     public List<UsoPuntosDet> detalleUsoConcepto(ConsultaUsoPuntosParam param){
         
           List<UsoPuntosDet> respuesta = (List<UsoPuntosDet>) em.createNamedQuery("UsoPuntosDet.DetalleUso")
                                        .setParameter("idCliente", param.getIdCliente())
                                        .getResultList();
        return respuesta;
     }
   
    
}
