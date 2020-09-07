package py.com.fidelizacion_v2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConceptoPuntos.class)
public abstract class ConceptoPuntos_ {

	public static volatile SingularAttribute<ConceptoPuntos, String> descripcion;
	public static volatile SingularAttribute<ConceptoPuntos, Integer> idConcepto;
	public static volatile CollectionAttribute<ConceptoPuntos, UsoPuntosCab> usoPuntosCabCollection;
	public static volatile SingularAttribute<ConceptoPuntos, String> puntosRequeridos;

	public static final String DESCRIPCION = "descripcion";
	public static final String ID_CONCEPTO = "idConcepto";
	public static final String USO_PUNTOS_CAB_COLLECTION = "usoPuntosCabCollection";
	public static final String PUNTOS_REQUERIDOS = "puntosRequeridos";

}

