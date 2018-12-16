package nozama;

public class Album extends Artikel {

	private String interpret;
	private int numtitel;
	private int laufzeit;
	
	public Album(String id, String titel, int jahr, float preis, int kaeufe, String interpret, int laufzeit, int numtitel) {
		super(id, titel, jahr, preis, kaeufe);
		this.numtitel = numtitel;
		this.laufzeit = laufzeit;
		this.interpret = interpret;
	}

	public int getNumTitel(){
		return this.numtitel;
	}
	
	public int getLaufzeit(){
		return this.laufzeit;
	}
	
	public String getInterpret(){
		return this.interpret;
	}
	
	public String toString(){
		return super.toString() + " (Album, Interpret: "+this.interpret+", "+this.numtitel+" Titel, Laufzeit: "+this.laufzeit+")";  
	}

}