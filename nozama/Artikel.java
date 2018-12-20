package nozama;

import java.util.HashSet;
import java.util.List;

public class Artikel {

	private String id;
	private String titel;
	private int jahr;
	private float preis;
	private int kaeufe;
	private HashSet<String> tags;
	
	public Artikel(String id, String titel, int jahr, float preis, int kaeufe){
		this.id = id;
		this.titel = titel;
		this.jahr = jahr;
		this.preis = preis;
		this.kaeufe = kaeufe;
		this.tags = new HashSet<String>();
	}
	
	public String getTitel(){
		return this.titel;
	}
	
	public int getJahr(){
		return this.jahr;
	}
	
	public float getPreis(){
		return this.preis;
	}
	
	public void setPreis(float preis){
		this.preis = preis;
	}

	public void setID(String id){
		this.id = id;
	}

	public int getKaeufe(){
		return this.kaeufe;
	}
	
	public void addKauf(){
		this.kaeufe++;
	}
	
	public String toString(){
		return this.id+": "+this.titel+" ("+this.jahr+", Preis: "+this.preis+" Euro, Kaeufe: "+this.kaeufe+")";  
	}
	
	// implementing help funcion for bubblesort
	
	public int getSortValue( Artikel artikel ) {
		int value = 4;
		if ( artikel instanceof Album){
			value = 0;
		}

		else if ( artikel instanceof Film ) {
			Film myFilm = (Film) artikel;
			if ( myFilm.getFormat().equals( "HD" ) ){
				value =  1;
			}

			else {
				value = 2;
			}
		}
		return value;
	}

	public HashSet<String> getTags() {
		System.out.println(this.tags);
		return tags;
	}
	public void addTags(String tag) {
		this.tags.add( tag );
	}

	public void buildTags() {

		String[] title = this.getTitel().split(" ");
		for( int i = 0; i < title.length; ++i ) {
			title[i] = title[i].toLowerCase();
			title[i] = title[i].replaceAll( "[^a-zA-Z]+", "");
			if ( Data.getStoppworte().contains(title[i] ) == false ) {
				this.tags.add(title[i]);
			}

		}


	}
	
}