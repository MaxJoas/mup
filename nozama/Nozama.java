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

	public String changeID() {
		for( int i = 0; i < artikel.size(); i++ ){

			Artikel currentArtikel = this.artikel.get(i);
			String currentTitle = currentArtikel.getTitel();
			
			if( currentArtikel instanceof Film ) {
				String first_letter = "F";
				String second_part = currentArtikel.getRegie();
			}

			else {
				String first_letter = "A";
				String second_part = currentArtikel.getInterpret();
			}


			
		}
	}
		
}