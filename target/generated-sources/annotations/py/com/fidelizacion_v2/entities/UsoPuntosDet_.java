package py.com.fidelizacion_v2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsoPuntosDet.class)
public abstract class UsoPuntosDet_ {

	public static volatile SingularAttribute<UsoPuntosDet, Integer> puntajeUtilizado;
	public static volatile SingularAttribute<UsoPuntosDet, BolsaPuntos> idBolsa;
	public static volatile SingularAttribute<UsoPuntosDet, UsoPuntosCab> idUsoPuntosCab;
	public static volatile SingularAttribute<UsoPuntosDet, Integer> idUsoPuntosDet;

	public static final String PUNTAJE_UTILIZADO = "puntajeUtilizado";
	public static final String ID_BOLSA = "idBolsa";
	public static final String ID_USO_PUNTOS_CAB = "idUsoPuntosCab";
	public static final String ID_USO_PUNTOS_DET = "idUsoPuntosDet";

}

