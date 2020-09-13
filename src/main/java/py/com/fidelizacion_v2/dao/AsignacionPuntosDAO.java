/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.com.fidelizacion_v2.entities.AsignacionPuntos;
import py.com.fidelizacion_v2.entities.BolsaPuntos;
import py.com.fidelizacion_v2.model.params.ConsultaBolsaPuntosParam;
import py.com.fidelizacion_v2.util.Globales;

import java.util.List;

/**
 *
 * 
 */
@Stateless
public class AsignacionPuntosDAO extends AbstractDAO<AsignacionPuntos>{
    
    @PersistenceContext(unitName = Globales.unitName)
    private EntityManager em;

    public AsignacionPuntosDAO() {
        super(AsignacionPuntos.class);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }

    public Integer consultaasignacion(ConsultaAsignacionPuntosParam param){
        Query q=this.em.createQuery("select p.montoEquivalencia / :param from AsignacionPuntos p where :param BETWEEN :limiteInf AND :limiteSup")
                .setParameter("montoEquivalencia", param.getMontoEquivalencia());

        return (Integer) q.getSingleResult();
    }
}
