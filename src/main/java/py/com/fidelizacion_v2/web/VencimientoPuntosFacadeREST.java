/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.web;

import py.com.fidelizacion_v2.dao.AbstractDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import py.com.fidelizacion_v2.dao.VencimientoPuntosDAO;
import py.com.fidelizacion_v2.entities.VencimientoPuntos;

/**
 *
 * 
 */
@Stateless
@Path("vencimiento-puntos")
public class VencimientoPuntosFacadeREST {

    @Inject
    private VencimientoPuntosDAO dao;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VencimientoPuntos entity) {
        dao.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, VencimientoPuntos entity) {
        dao.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        dao.remove(dao.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public VencimientoPuntos find(@PathParam("id") Integer id) {
        return dao.find(id);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<VencimientoPuntos> findAll() {
        return dao.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<VencimientoPuntos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return dao.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(dao.count());
    }
    
}
