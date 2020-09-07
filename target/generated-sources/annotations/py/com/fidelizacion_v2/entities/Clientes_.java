package py.com.fidelizacion_v2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clientes.class)
public abstract class Clientes_ {

	public static volatile SingularAttribute<Clientes, String> tipoDocumento;
	public static volatile SingularAttribute<Clientes, Integer> idCliente;
	public static volatile SingularAttribute<Clientes, Date> fechaNacimiento;
	public static volatile CollectionAttribute<Clientes, UsoPuntosCab> usoPuntosCabCollection;
	public static volatile SingularAttribute<Clientes, String> apellido;
	public static volatile SingularAttribute<Clientes, String> documento;
	public static volatile CollectionAttribute<Clientes, BolsaPuntos> bolsaPuntosCollection;
	public static volatile SingularAttribute<Clientes, String> telefono;
	public static volatile SingularAttribute<Clientes, String> nombre;
	public static volatile SingularAttribute<Clientes, String> email;
	public static volatile SingularAttribute<Clientes, String> nacionalidad;

	public static final String TIPO_DOCUMENTO = "tipoDocumento";
	public static final String ID_CLIENTE = "idCliente";
	public static final String FECHA_NACIMIENTO = "fechaNacimiento";
	public static final String USO_PUNTOS_CAB_COLLECTION = "usoPuntosCabCollection";
	public static final String APELLIDO = "apellido";
	public static final String DOCUMENTO = "documento";
	public static final String BOLSA_PUNTOS_COLLECTION = "bolsaPuntosCollection";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String EMAIL = "email";
	public static final String NACIONALIDAD = "nacionalidad";

}

