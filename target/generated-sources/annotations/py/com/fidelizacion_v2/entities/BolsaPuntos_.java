package py.com.fidelizacion_v2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BolsaPuntos.class)
public abstract class BolsaPuntos_ {

	public static volatile SingularAttribute<BolsaPuntos, Date> fechaCaducidad;
	public static volatile SingularAttribute<BolsaPuntos, Integer> puntajeUtilizado;
	public static volatile SingularAttribute<BolsaPuntos, Date> fechaAsignacion;
	public static volatile SingularAttribute<BolsaPuntos, Integer> puntajeAsignado;
	public static volatile SingularAttribute<BolsaPuntos, Integer> montoOperacion;
	public static volatile CollectionAttribute<BolsaPuntos, UsoPuntosDet> usoPuntosDetCollection;
	public static volatile SingularAttribute<BolsaPuntos, Clientes> idCliente;
	public static volatile SingularAttribute<BolsaPuntos, Integer> saldoPuntos;
	public static volatile SingularAttribute<BolsaPuntos, Integer> idBolsa;

	public static final String FECHA_CADUCIDAD = "fechaCaducidad";
	public static final String PUNTAJE_UTILIZADO = "puntajeUtilizado";
	public static final String FECHA_ASIGNACION = "fechaAsignacion";
	public static final String PUNTAJE_ASIGNADO = "puntajeAsignado";
	public static final String MONTO_OPERACION = "montoOperacion";
	public static final String USO_PUNTOS_DET_COLLECTION = "usoPuntosDetCollection";
	public static final String ID_CLIENTE = "idCliente";
	public static final String SALDO_PUNTOS = "saldoPuntos";
	public static final String ID_BOLSA = "idBolsa";

}

