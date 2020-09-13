/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.web;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import py.com.fidelizacion_v2.dao.UsoPuntosCabDAO;
import py.com.fidelizacion_v2.entities.UsoPuntosCab;

/**
 *
 * 
 */
@Stateless
@Path("uso-puntos")
public class UsoPuntosCabFacadeREST {
    
    @Inject
    private UsoPuntosCabDAO dao;

    @POST
    @Path("consulta")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UsoPuntosCab entity) {
        dao.create(entity);
    }

    
}
