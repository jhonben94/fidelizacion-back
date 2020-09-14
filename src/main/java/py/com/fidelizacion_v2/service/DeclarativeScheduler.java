/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import py.com.fidelizacion_v2.dao.BolsaPuntosDAO;
import py.com.fidelizacion_v2.entities.BolsaPuntos;

/**
 *
 * @author jhony
 */

@Singleton
public class DeclarativeScheduler {
    @Inject
    private BolsaPuntosDAO bDao;
    
    
    @Schedule(second = "*",minute = "*",hour = "12",persistent = false)
    public void atSchedule() throws InterruptedException {
        bDao.consultaBolsaVencida();
        System.out.println("Ejecutado proceso diario de actualizacion de bolsas");
    }
    
}
