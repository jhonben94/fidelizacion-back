/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.fidelizacion_v2.entities.Clientes;

/**
 *
 * @author jhony
 */
public class ClientesDAO extends AbstractFacade<Clientes>{
    
    @PersistenceContext(unitName = "py.com_fidelizacion_v2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ClientesDAO(Class<Clientes> entityClass) {
        super(entityClass);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }
    
}
