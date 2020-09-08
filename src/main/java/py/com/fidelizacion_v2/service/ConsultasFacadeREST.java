/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import py.com.fidelizacion_v2.dao.UsoPuntosCabDAO;
import py.com.fidelizacion_v2.entities.UsoPuntosCab;
import py.com.fidelizacion_v2.entities.UsoPuntosDet;
import py.com.fidelizacion_v2.model.params.ConsultaUsoPuntosParam;

/**
 *
 * 
 */
@Stateless
@Path("consultas")
public class ConsultasFacadeREST {

    @Inject
    private UsoPuntosCabDAO usoDao;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<UsoPuntosDet> consulta (ConsultaUsoPuntosParam param) {
        return usoDao.consultaUso(param);
    }

   
    
}
