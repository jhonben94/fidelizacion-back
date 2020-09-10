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

         
//         String query ="SELECT u FROM UsoPuntosCab u ";
//         Boolean add = false;
////         if(param.getIdCliente() !=null){
////             query+= " WHERE u.idCliente.idCliente =" +param.getIdCliente() ;
////             add = true;
////         }
////  
//          if(param.getFecha() !=null){
//              
//            Date date = param.getFecha();  
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
//             String strDate = dateFormat.format(date);  
//             System.out.println("val :" +param.getFecha() + " otro val: " +strDate);
//
//             query+= !add?" WHERE function('date_format', u.fechaUso, '%Y, %m, %d') = '"+ strDate+"'": "  AND function('date_format', u.fechaUso, '%Y, %m, %d') ='"+ strDate+"'";
//         }

         List<UsoPuntosCab> respuesta = (List<UsoPuntosCab>) em.createNamedQuery("UsoPuntosCab.Consulta.Uso")
                                        .setParameter("idCliente", param.getIdCliente())
                                        .setParameter("fechaUso",Globales.localToTimeStamp(param.getFecha()))
                                        .setParameter("idConcepto", param.getIdConcepto())
                                        .getResultList();
        return respuesta;
    }
   
    
}
