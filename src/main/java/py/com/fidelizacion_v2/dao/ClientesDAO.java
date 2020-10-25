/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.fidelizacion_v2.entities.Clientes;
import py.com.fidelizacion_v2.util.Globales;

/**
 *
 * 
 */
@Stateless
public class ClientesDAO extends AbstractDAO<Clientes>{
    
    @PersistenceContext(unitName = Globales.unitName)
    private EntityManager em;

    public ClientesDAO() {
        super(Clientes.class);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }
    public List<Clientes> buscarClienteVencimiento(Integer dias){

        Date today = new Date();
        Date nexDay = new Date(today.getTime() + dias*(1000 * 60 * 60 * 24));
       
        Query q=this.em.createQuery("SELECT  c from BolsaPuntos p INNER JOIN p.idCliente c  where p.fechaCaducidad  BETWEEN :limiteInf AND :limiteSup ")
                .setParameter("limiteInf", Globales.localToTimeStamp(today))
                .setParameter("limiteSup", Globales.localToTimeStamp(nexDay));
        
        List<Clientes> respuesta = q.getResultList();
                
        return respuesta;
    } 
    
       public List<Clientes> buscaCliente(Clientes c){

   
        Query q;
        q = this.em.createQuery("SELECT  c from Clientes c where c.nombre like :nombre OR c.apellido like :apellido OR c.documento like :documento OR c.fechaNacimiento = :cumple")
                .setParameter("nombre", "%"+c.getNombre()+"%")
                .setParameter("apellido", "%"+c.getApellido()+"%" )
                .setParameter("documento", "%"+c.getDocumento()+"%" )
                .setParameter("cumple", Globales.localToTimeStamp(c.getFechaNacimiento()));
        
        List<Clientes> respuesta = q.getResultList();
                
        return respuesta;
    } 
    
   
    
}
