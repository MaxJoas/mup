package nozama;

public class Film extends Artikel {

	private String format;
	private String regie;
	private String genre;
	
	public Film(String id, String titel, int jahr, float preis, int kaeufe, String format, String genre, String regie) {
		super(id, titel, jahr, preis, kaeufe);
		this.format = format;
		this.regie = regie;
		this.genre = genre;
	}

	public String getRegie(){
		return this.regie;
	}
	
	public String getFormat(){
		return this.format;
	}
	
	public String getGenre(){
		return this.genre;
	}
	
	public String toString(){
		return super.toString() + " (Film, "+this.format+", Regie: "+this.regie+", Genre: "+this.genre+")";  
	}
	
}