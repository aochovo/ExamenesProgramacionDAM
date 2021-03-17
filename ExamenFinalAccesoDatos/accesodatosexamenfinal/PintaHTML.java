package accesodatosexamenfinal;
import java.util.ArrayList;

public class PintaHTML {

	public static String crearTabla(ArrayList<Palabra> lista_palabras_ordenadas) {
		String html_pagina="<html><head><title>Diccionario</title></head><body><table border=1>";
		html_pagina+="<tr><th>Palabra</th><th>Definicion</th><th>Imagen</th></tr>";
		for (Palabra palabra : lista_palabras_ordenadas) {
			html_pagina+="<tr><th>"+palabra.getPalabra()+"</th><th>"+palabra.getDef()+"</th><th><img src='"+palabra.getImg()+"'/></th></tr>";
		}
		html_pagina+="</table></body></html>";
		return html_pagina;
		
	}

}
