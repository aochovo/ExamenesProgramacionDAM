package accesodatosexamenfinal;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoHibernate {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	public static void inicializarBD()
		{
			s=new StandardServiceRegistryBuilder().configure().build();
			sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		}
	public static void insertarDatos(ArrayList<Palabra> lista_palabras_2) {
		for (Palabra palabra : lista_palabras_2) {
			Session sesion=sf.openSession();
		   	Transaction t=sesion.beginTransaction();
		   	sesion.save(palabra);
		   	t.commit();
		}
	   	 
	   }
		
	}


