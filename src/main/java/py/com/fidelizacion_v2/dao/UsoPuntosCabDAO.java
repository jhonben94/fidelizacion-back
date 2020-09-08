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
     public List<UsoPuntosDet> consultaUso( ConsultaUsoPuntosParam param){
         System.out.println("val :" +param.getIdCliente());
         List<UsoPuntosDet> respuesta = (List<UsoPuntosDet>) em.createNamedQuery("UsoPuntosCab.Consulta.Uso")
                                        .setParameter("idCliente", param.getIdCliente())
                                        .setParameter("fechaUso", param.getFecha())
                                        .setParameter("idConcepto", param.getIdConcepto())   
                                        .getResultList();
        return respuesta;
    }
    
}
