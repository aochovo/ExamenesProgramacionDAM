package accesodatosexamenfinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Palabra {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String palabra;
    private String def;
    private String img;
	public Palabra(int id, String palabra, String def, String img) {
		super();
		this.id = id;
		this.palabra = palabra;
		this.def = def;
		this.img = img;
	}
	
	public Palabra(String palabra, String def, String img) {
		super();
		this.palabra = palabra;
		this.def = def;
		this.img = img;
	}

	public Palabra() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Palabra [id=" + id + ", palabra=" + palabra + ", def=" + def + ", img=" + img + "]";
	}
    
}
