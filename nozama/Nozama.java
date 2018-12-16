package nozama;

import java.util.ArrayList;
import java.util.List;

public class Nozama {

	private List<Artikel> artikel;
	
	public Nozama(){
		this.artikel = new ArrayList<Artikel>();
	}
	
	public List<Artikel> getArtikel(){
		return this.artikel;
	}
	
	public void addArtikel(Artikel a){
		this.artikel.add(a);
	}
		
}