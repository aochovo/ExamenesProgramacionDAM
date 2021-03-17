package accesodatosexamenfinal;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {
	static String ruta="C:\\proyectosjava\\AccesoDatosFinal\\fichero.html";
	public static void grabarFichero(String tabla) {
		try 
        {   
	FileWriter fw=new FileWriter(ruta, false);
	
	fw.write(tabla);
	fw.close();
} 
        
        catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

}
