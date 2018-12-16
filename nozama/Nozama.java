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

	public void changeID() {

		// looping through every article in de stream and assign new id
		for( int i = 0; i < artikel.size(); i++ ){

			// initialize Stringbuilder to add relevant substrings
			StringBuilder newId = new StringBuilder();
			
			// check if article is film or album
			if( this.artikel.get(i) instanceof Film ) {
				Film currentArtikel = (Film) this.artikel.get(i);
				String first_letter = "F-";
				newId.append( first_letter );
				String[] secondPart =  currentArtikel.getRegie().split( " " );

				// loop through name of the director and add first letters to newID
				for ( int j = 0; j < secondPart.length; j++ ) {

					String currentWord = secondPart[j];
					newId.append( currentWord.substring( 0, 1 ) );
				}
			}

			else {
				Album currentArtikel =  (Album) this.artikel.get(i);
				String first_letter = "A-";
				newId.append( first_letter );
				String[] secondPart = currentArtikel.getInterpret().split( " " );

				// loop through name of the director and add first letters to newID
				for ( int j = 0; j < secondPart.length; j++ ) {

					String currentWord = secondPart[j];
					newId.append( currentWord.substring( 0, 1 ) );
				}
			}

			String[] titel = this.artikel.get(i).getTitel().split( " " );
			
			
				// looping titel and getting relevant substring
				for ( int k = 0; k < titel.length; k++ ) {
					String currentWord = titel[k];

					// checking if word has at least 3 letters to avoid out of range bug
					if ( currentWord.length() > 2 ) {
					newId.append( currentWord.substring( 0 , 3 ) );
					}
					
					else {
						int length = currentWord.length();
						newId.append( currentWord.substring( 0, length ) );
					}

		}
		this.artikel.get(i).setID(newId.toString());
		System.out.println( this.artikel.get(i) );
	}
}
		
}