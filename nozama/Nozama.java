package nozama;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.HashSet;

public class Nozama {

	private List<Artikel> artikel;
	private TreeMap<String, Integer> tagcount;
	
	public Nozama(){
		this.artikel = new ArrayList<Artikel>();
		this.tagcount = new TreeMap<String, Integer>();
	}
	
	public List<Artikel> getArtikel(){
		System.out.println(this.artikel);
		return this.artikel;
	}
	
	public void addArtikel(Artikel a){
		this.artikel.add(a);
	}

	public void changeID() {

		// looping through every article in the stream and assign new id
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
				newId.append( "-" );
			}

			else {
				Album currentArtikel =  (Album) this.artikel.get(i);
				String first_letter = "A-";
				newId.append( first_letter );
				String[] secondPart = currentArtikel.getInterpret().split( " " );

				// loop through name of the director and add first letters to newID
				for ( int j = 0; j < secondPart.length; j++ ) {

					String currentWord = secondPart[j];
					newId.append( currentWord.substring( 0, 1 )  );
				}
				newId.append( "-" );
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
		// set new ID that we generated above
		this.artikel.get(i).setID(newId.toString());
		System.out.println( this.artikel.get(i) );
	}
}


	public void sortArticle() {
		
		int n = this.artikel.size();
		boolean swapped;

		do {
			swapped = false;
			for ( int i = 0; i < n - 1 ; ++i ) {

				// seting local variables 
				Artikel currentArticle = this.artikel.get(i);
				Artikel nextArticle = this.artikel.get( i + 1 );

				// check first search criteria and apply bubblse sort for this criteria
				if( currentArticle.getSortValue( currentArticle ) > nextArticle.getSortValue( nextArticle) ) {
					this.artikel.set( i, nextArticle );
					this.artikel.set( i + 1, currentArticle );
					swapped = true;
					}
				
				// in case first criteria is ambiguous, apply bubble sort for second criteria
				else if( currentArticle.getSortValue( currentArticle ) == nextArticle.getSortValue( nextArticle) ) {
					
					if( currentArticle.getJahr() > nextArticle.getJahr() ) {
						this.artikel.set( i, nextArticle );
						this.artikel.set( i + 1, currentArticle );
						swapped = true;
						}

						// in case second criteria is also ambiguos, apply bubble sort for third criteria
						else if( currentArticle.getJahr() == nextArticle.getJahr() ) {

							if ( currentArticle.getTitel().compareTo( nextArticle.getTitel() ) > 0 ) {
								this.artikel.set( i, nextArticle );
								this.artikel.set( i + 1, currentArticle );
								swapped = true;
							} 
						}
					}
				}
			 } while( swapped );
		System.out.println( this.artikel );
	
	}

	public void countTags() {
		for( int i = 0;i <  this.artikel.size(); i++ ) {

			// Setting local variables to increase readability fo code
			Artikel currentArtikel = this.artikel.get(i);
			List<String> currentTags = currentArtikel.getTags();

			// checking for every tag ig it is allready in tagcount
			for(int j = 0; j < currentTags.size(); j++) {
				if( this.tagcount.containsKey( currentTags.get(j) ) ) {
					//increasing old count by one and set it as new count
					Integer newValue = this.tagcount.get( currentTags.get(j) ) + 1;
					this.tagcount.put( currentTags.get(j), newValue );
				}

				// in case the tag is not in the treemap, we add the tag s key and begin to count
				else {
					this.tagcount.put( currentTags.get(j), 1 );
				}
			}
		}
		System.out.println( this.tagcount );
	}
}