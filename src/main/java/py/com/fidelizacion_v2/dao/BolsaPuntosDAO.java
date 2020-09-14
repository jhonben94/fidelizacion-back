/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.fidelizacion_v2.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.fidelizacion_v2.entities.BolsaPuntos;
import py.com.fidelizacion_v2.entities.Clientes;
import py.com.fidelizacion_v2.entities.UsoPuntosCab;
import py.com.fidelizacion_v2.entities.UsoPuntosDet;
import py.com.fidelizacion_v2.model.params.ConsultaBolsaPuntosParam;
import py.com.fidelizacion_v2.model.params.ConsultaUsoPuntosParam;
import py.com.fidelizacion_v2.util.Globales;

/**
 *
 * 
 */
@Stateless
public class BolsaPuntosDAO extends AbstractDAO<BolsaPuntos>{
    @Inject
    private ClientesDAO clieDao;
    
    @Inject
    private AsignacionPuntosDAO asigDao;
    
    @PersistenceContext(unitName = Globales.unitName)
    private EntityManager em;
    
    @Inject
    private BolsaPuntosDAO bdao;
    
    @Inject
    private UsoPuntosCabDAO usoCabDao;
    
    @Inject
    private UsoPuntosDetDAO usoDetCabDao;
    
    public BolsaPuntosDAO() {
        super(BolsaPuntos.class);
    }
    @Override
    protected EntityManager getEntityManager() {
       return this.em;
    }
     public List<BolsaPuntos> consultabolsa(ConsultaBolsaPuntosParam param){
           Query q=this.em.createQuery("select p from BolsaPuntos p where p.idCliente.idCliente = :idCliente AND p.saldoPuntos BETWEEN :limiteInf AND :limiteSup")
                    .setParameter("idCliente", param.getIdCliente())
                    .setParameter("limiteInf", param.getLimiteInferior())
                    .setParameter("limiteSup", param.getLimiteSuperior());

           List<BolsaPuntos> respuesta = (List<BolsaPuntos>) q.getResultList();
           return respuesta;
    }
     
      public BolsaPuntos usuarioBolsa(ConsultaUsoPuntosParam param){
           Query q=this.em.createQuery("select p from BolsaPuntos p where p.idCliente.idCliente = :idCliente")
                    .setParameter("idCliente", param.getIdCliente());

           BolsaPuntos respuesta = (BolsaPuntos) q.getSingleResult();
           return respuesta;
    }
     
    public void consultaBolsaVencida(){
           Query q=this.em.createQuery("UPDATE BolsaPuntos b SET b.puntajeAsignado=0 where b.fechaCaducidad < :hoy")
                    .setParameter("hoy", Globales.localToTimeStamp(new Date()));
           q.executeUpdate();
    }
    
    public void cargarPuntos( ConsultaUsoPuntosParam param){
        try {
          BolsaPuntos b = (BolsaPuntos) this.em.createNamedQuery("findByIdCliente").setParameter("idCliente", param.getIdCliente()).getSingleResult();
          if(b!=null){
            Integer puntos = asigDao.consultaasignacion(param.getMonto());
            b.setSaldoPuntos(b.getSaldoPuntos()+puntos);
            b.setPuntajeAsignado(puntos);
            b.setFechaAsignacion(new Date());
            b.setFechaCaducidad(new Date());
            bdao.edit(b);
          
          }else{
              crearNuevaBolsa(param.getIdCliente(), param.getMonto());
          }
                    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
         
         
    }
    public void crearNuevaBolsa(Integer clienteId,Integer monto){
            Clientes c = clieDao.find(clienteId);
            Integer montoReal =asigDao.consultaasignacion(monto);
            BolsaPuntos b = new BolsaPuntos();
            b.setIdCliente(c);
            b.setSaldoPuntos(montoReal);
            b.setPuntajeAsignado(montoReal);
            b.setPuntajeUtilizado(0);
            b.setFechaAsignacion(new Date());
            b.setFechaCaducidad(new Date());
            bdao.create(b);
    }
    
    public void usarPuntos(ConsultaUsoPuntosParam param){
        UsoPuntosCab usoCab = usoCabDao.obtener(param);
        BolsaPuntos bolsa = bdao.usuarioBolsa(param);
        UsoPuntosDet det = new UsoPuntosDet();
        det.setIdBolsa(bolsa);
        det.setPuntajeUtilizado(param.getMonto());
        det.setIdUsoPuntosCab(usoCab);
        usoDetCabDao.create(det);
       
        bolsa.setFechaAsignacion(new Date());
        bolsa.setFechaCaducidad(new Date());
        bolsa.setPuntajeUtilizado( param.getMonto());
        bolsa.setSaldoPuntos( bolsa.getSaldoPuntos() - param.getMonto());
        
        bdao.edit(bolsa);
    
    }
    
}
