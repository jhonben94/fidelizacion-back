/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.service;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * 
 */
@ApplicationPath("fidesys")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(py.com.fidelizacion_v2.service.AsignacionPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.BolsaPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.ClientesFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.ConceptoPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.ConsultasFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.UsoPuntosCabFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.UsoPuntosDetFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.service.VencimientoPuntosFacadeREST.class);
    }
    
}
