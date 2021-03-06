package nozama;

import java.util.List;
import java.util.ArrayList;

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

	public List<String> getTags() {
		//System.out.println(super.getTags());
		return super.getTags();
	}
	
	public String getInterpret(){
		return this.interpret;
	}
	
	public String toString(){
		return super.toString() + " (Album, Interpret: "+this.interpret+", "+this.numtitel+" Titel, Laufzeit: "+this.laufzeit+")";  
	}

	@Override
	public void buildTags() {

		// build tags for title
		super.buildTags();
		// getting array of words for tag building
		String[] tagInterpret = this.getInterpret().split( " " );

		for( int i = 0; i < tagInterpret.length; ++i ) {
			// replace numbers special characters and make all letters lowercase
			tagInterpret[i] = tagInterpret[i].toLowerCase();
			tagInterpret[i] = tagInterpret[i].replaceAll( "[^a-zA-Z]+", "" );

			// add tags, if it is not a stopword and not already in the taglist
			if ( ( Data.getStoppworte().contains(tagInterpret[i]) == false ) &&  ( super.getTags().contains( tagInterpret[i] ) == false ) ) {
				super.addTags( tagInterpret[i] );
			}
		}
	}
}