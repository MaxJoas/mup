package nozama;

import java.util.ArrayList;
import java.util.List;

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

	public List<String> getTags() {
		//System.out.println(super.getTags());
		return super.getTags();
	}
	
	public String toString(){
		return super.toString() + " (Film, "+this.format+", Regie: "+this.regie+", Genre: "+this.genre+")";  
	}

	@Override
	public void buildTags() {

		super.buildTags();
		String[] genreRegie =  ( this.getGenre() +" " + this.getRegie() ).split( " " );

		for ( int i = 0; i < genreRegie.length; ++i ) {

			// replace numbers special characters and make all letters lowercase
			genreRegie[i] = genreRegie[i].toLowerCase();
			genreRegie[i] = genreRegie[i].replaceAll("[^a-zA-Z]+", "" );

			// add tags, if it is not a stopword and not already in the taglist
			if( ( Data.getStoppworte().contains( genreRegie[i] ) == false ) && ( super.getTags().contains( genreRegie[i] ) == false ) ) {
				super.addTags( genreRegie[i] );
			}
		}
	}
}