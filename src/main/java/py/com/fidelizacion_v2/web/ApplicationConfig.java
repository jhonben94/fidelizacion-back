/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.web;

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
        resources.add(py.com.fidelizacion_v2.web.AsignacionPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.BolsaPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.ClientesFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.ConceptoPuntosFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.ConsultasFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.UsoPuntosCabFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.UsoPuntosDetFacadeREST.class);
        resources.add(py.com.fidelizacion_v2.web.VencimientoPuntosFacadeREST.class);
    }
    
}
