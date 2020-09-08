/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    
}
