/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import py.com.fidelizacion_v2.entities.BolsaPuntos;
import py.com.fidelizacion_v2.model.params.ConsultaBolsaPuntosParam;
import py.com.fidelizacion_v2.util.Globales;

/**
 *
 * 
 */
@Stateless
public class BolsaPuntosDAO extends AbstractDAO<BolsaPuntos>{
    
    @PersistenceContext(unitName = Globales.unitName)
    private EntityManager em;

    public BolsaPuntosDAO() {
        super(BolsaPuntos.class);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }
     public List<BolsaPuntos> consultabolsa(ConsultaBolsaPuntosParam param){
           Query q=this.em.createQuery("select p from BolsaPuntos p where p.idCliente.idCliente = :idCliente AND p.saldoPuntos BETWEEN :limiteInf AND :limiteSup")
                    .setParameter("idCliente", param.getIdCliente())
                    .setParameter("limiteInf", param.getLimiteInferior())
                    .setParameter("limiteSup", param.getLimiteSuperior());

           List<BolsaPuntos> respuesta = (List<BolsaPuntos>) q.getResultList();
           return respuesta;
    }
     
     public List<BolsaPuntos> consultaBolsaVencida(){
           Query q=this.em.createQuery("select p from BolsaPuntos p where p.fechaCaducidad < :hoy")
                    .setParameter("hoy", Globales.localToTimeStamp(new Date()));

           List<BolsaPuntos> respuesta = (List<BolsaPuntos>) q.getResultList();
           return respuesta;
    }
    
}
