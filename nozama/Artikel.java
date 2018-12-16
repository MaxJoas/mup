package nozama;

public class Artikel {

	private String id;
	private String titel;
	private int jahr;
	private float preis;
	private int kaeufe;
	
	public Artikel(String id, String titel, int jahr, float preis, int kaeufe){
		this.id = id;
		this.titel = titel;
		this.jahr = jahr;
		this.preis = preis;
		this.kaeufe = kaeufe;
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
	
}