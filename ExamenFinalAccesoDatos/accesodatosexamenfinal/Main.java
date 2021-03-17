package accesodatosexamenfinal;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int opcion=EntradaSalida.mostrarMenu();
		
		while(opcion!=4)
		{
			switch(opcion)
			{
			case 1://1-Buscar Significado Palabra
				Palabra palabra=EntradaSalida.pedirPalabra();
				Palabra palabra_llena=AccesoInternet.pedirDatos(palabra);
				AccesoMongo.insertarPalabra(palabra_llena);
				break;
			case 2:
				//2-Listar Palabras
				ArrayList<Palabra> lista_palabras_1=AccesoMongo.sacarPalbras();
				System.out.println(lista_palabras_1.toString());
				ArrayList<Palabra> lista_palabras_ordenadas=EntradaSalida.ordenarPalabras(lista_palabras_1);
				String tabla=PintaHTML.crearTabla(lista_palabras_ordenadas);
				AccesoFichero.grabarFichero(tabla);
				break;
			case 3:
				//Comprar producto(relacionar el cliente con el producto que compró)
				ArrayList<Palabra> lista_palabras_2=AccesoMongo.sacarPalbras();
				AccesoHibernate.inicializarBD();
				AccesoHibernate.insertarDatos(lista_palabras_2);
				break;
			}
			opcion=EntradaSalida.mostrarMenu();
		}
	}

	}


