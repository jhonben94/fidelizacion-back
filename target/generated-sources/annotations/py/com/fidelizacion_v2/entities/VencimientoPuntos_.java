package py.com.fidelizacion_v2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VencimientoPuntos.class)
public abstract class VencimientoPuntos_ {

	public static volatile SingularAttribute<VencimientoPuntos, Date> fechaInicio;
	public static volatile SingularAttribute<VencimientoPuntos, Integer> diasDuracion;
	public static volatile SingularAttribute<VencimientoPuntos, Integer> idVencimiento;
	public static volatile SingularAttribute<VencimientoPuntos, Date> fechaFin;

	public static final String FECHA_INICIO = "fechaInicio";
	public static final String DIAS_DURACION = "diasDuracion";
	public static final String ID_VENCIMIENTO = "idVencimiento";
	public static final String FECHA_FIN = "fechaFin";

}

