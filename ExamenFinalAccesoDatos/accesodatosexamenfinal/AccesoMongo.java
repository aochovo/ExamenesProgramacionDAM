package accesodatosexamenfinal;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AccesoMongo {
	static MongoClient m=new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	static MongoDatabase bd=m.getDatabase("ExamenAccesoDatos");
	static MongoCollection coleccion=bd.getCollection("diccionario");

	public static ArrayList<Palabra> sacarPalbras() {
		ArrayList<Palabra> palabras=new ArrayList();
		FindIterable diccionario=coleccion.find();
		MongoCursor c=diccionario.iterator();
		
		while(c.hasNext())
		{
			Document d=(Document)c.next();
			String palabra=d.getString("palabra");
			String definicion=d.getString("definicion");
			String img=d.getString("ruta_img");
			Palabra p=new Palabra(palabra,definicion,img);
			palabras.add(p);
		}
		
		return palabras;
		}
	
	public static void insertarPalabra(Palabra p)
	{
		Document doc=new Document();
		doc.put("palabra", p.getPalabra());
		doc.put("definicion", p.getDef());
		doc.put("ruta_img", p.getImg());
		coleccion.insertOne(doc);
	}

}
