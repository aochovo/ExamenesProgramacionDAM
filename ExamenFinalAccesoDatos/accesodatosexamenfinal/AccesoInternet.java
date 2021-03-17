package accesodatosexamenfinal;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AccesoInternet {
	//https://www.bing.com/images/search?q=perro
	//https://dle.rae.es/perro
	public static Palabra pedirDatos(Palabra p) {
		String definicion="";
		Document doc1;
		try {
			doc1 = Jsoup.connect("https://dle.rae.es/"+p.getPalabra()).get();
			Element elemento_palabra=doc1.selectFirst("p.j");
	        Elements elemntos_definicion=elemento_palabra.select("mark");
	        for (Element def : elemntos_definicion) {
				definicion=definicion+def.text().toString()+" ";
			}
	        p.setDef(definicion);
	        Document doc2=  Jsoup.connect("https://www.bing.com/images/search?q="+p.getPalabra()).get();
	        Element elemento_img=doc2.selectFirst("img.mimg");
	        //https://th.bing.com/th/id/OIP.nyY_AYMPX0FK9QxubPPtYgHaHe?w=182&h=184&c=7&o=5&pid=1.7
	        String img=elemento_img.attr("src");
	        p.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return p;
	}

}
