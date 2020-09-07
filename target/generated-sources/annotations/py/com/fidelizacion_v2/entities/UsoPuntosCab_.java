package py.com.fidelizacion_v2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsoPuntosCab.class)
public abstract class UsoPuntosCab_ {

	public static volatile SingularAttribute<UsoPuntosCab, Integer> puntajeUtilizado;
	public static volatile CollectionAttribute<UsoPuntosCab, UsoPuntosDet> usoPuntosDetCollection;
	public static volatile SingularAttribute<UsoPuntosCab, Clientes> idCliente;
	public static volatile SingularAttribute<UsoPuntosCab, ConceptoPuntos> idConcepto;
	public static volatile SingularAttribute<UsoPuntosCab, Date> fechaUso;
	public static volatile SingularAttribute<UsoPuntosCab, Integer> idUsoPuntosCab;

	public static final String PUNTAJE_UTILIZADO = "puntajeUtilizado";
	public static final String USO_PUNTOS_DET_COLLECTION = "usoPuntosDetCollection";
	public static final String ID_CLIENTE = "idCliente";
	public static final String ID_CONCEPTO = "idConcepto";
	public static final String FECHA_USO = "fechaUso";
	public static final String ID_USO_PUNTOS_CAB = "idUsoPuntosCab";

}

