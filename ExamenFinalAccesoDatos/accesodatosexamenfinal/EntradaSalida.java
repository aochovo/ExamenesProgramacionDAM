package accesodatosexamenfinal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EntradaSalida {

	public static int mostrarMenu() {
		System.out.println("1-Buscar Palabra\r\n"
				+ "2-Listar Palbras\r\n"
				+ "3-Subir a Hibernate\r\n"
				+ "4-SALIR");
		Scanner sc=new Scanner(System.in);
		int opcion=sc.nextInt();
		return opcion;
	}

	public static Palabra pedirPalabra() {
		Scanner sc=new Scanner(System.in);
		Palabra c=new Palabra();
		System.out.println("Introduzca la palabra");
		String nombre=sc.nextLine();
		c.setPalabra(nombre);
		return c;
	}

	public static ArrayList<Palabra> ordenarPalabras(ArrayList<Palabra> lista) {
		Collections.sort(lista, new Comparator<Palabra>() {
			@Override
			public int compare(Palabra p1, Palabra p2) {
				
				return new String(p1.getPalabra()).compareTo(new String(p2.getPalabra()));
			}
		});
		return lista;
	}

}
