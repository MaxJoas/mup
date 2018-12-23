package nozama;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Nozama {

	private List<Artikel> artikel;
	private TreeMap<String, Integer> tagcount;
	
	public Nozama(){
		this.artikel = new ArrayList<Artikel>();
		// use empty treemap for the tag count anf fill the Treemap in the main function with buildTag method
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
			
			// check if article is film and build newId with Film specific attributes (
			if( this.artikel.get(i) instanceof Film ) {
				Film currentArtikel = (Film) this.artikel.get(i);
				String first_letter = "F-";
				newId.append( first_letter );
				String[] secondPart =  currentArtikel.getRegie().split( " " );

				// loop through name of the director and add first letters of director to newID
				for ( int j = 0; j < secondPart.length; j++ ) {

					String currentWord = secondPart[j];
					newId.append( currentWord.substring( 0, 1 ) );
				}
				// adding dash 
				newId.append( "-" );
			}

			// if articles is an Album do basically the same as with Film, but Album specific
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

			// building String array with words in the title
			String[] titel = this.artikel.get(i).getTitel().split( " " );
			// looping titel and getting relevant substring
			for ( int k = 0; k < titel.length; k++ ) {
				String currentWord = titel[k];

				// checking if word has at least 3 letters to avoid out of range bug
				if ( currentWord.length() > 2 ) {
				newId.append( currentWord.substring( 0 , 3 ) );
					}
				
				// if word has less than tree letter use all letters of the word to add to id
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

	// idea: swap neighbor elements in aticle array as long as the latter neighbor is "smaller" (based on given criteria) than the former neighbir
	// doing this by looping as long through the article array as long we need to swap neighbour elements
	public void sortArticle() {
		
		int n = this.artikel.size(); // local variable for for loop in line 100
		boolean swapped;

		do {
			// init swapped to false in order to use do while as long as we need do swap elements
			swapped = false; 
			for ( int i = 0; i < n - 1 ; ++i ) {

				// seting local variables 
				Artikel currentArticle = this.artikel.get(i);
				Artikel nextArticle = this.artikel.get( i + 1 );

				// check first search criteria and apply bubble sort for this criteria
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

			// checking for every tag if it is allready in tagcount
			for(int j = 0; j < currentTags.size(); j++) {
				if( this.tagcount.containsKey( currentTags.get(j) ) ) {
					//increasing old count by one and set it as new count
					Integer newValue = this.tagcount.get( currentTags.get(j) ) + 1;
					this.tagcount.put( currentTags.get(j), newValue );
				}

				// in case the tag is not in the treemap, we add the tag as key and begin to count
				else {
					this.tagcount.put( currentTags.get(j), 1 );
				}
			}
		}
		System.out.println( this.tagcount );
	}

	public List<Artikel> filter( List<Artikel> articlelist, String criteria ){
		// init List we want to return
		List<Artikel> returnList = new ArrayList<Artikel>();

		// check if valid filter crtiteria are given
		// this could be implement mor clever via a map so "sd", "Sd", etc could be a key to "SD" so the filter could work for bad user input, but this was not asked
		if ( ! criteria.equals( "Album" ) && ! criteria.equals( "SD" ) && ! criteria.equals( "HD" ) ) {
			System.out.println( "Please provide a valid criteria: Album, SD, or HD" );
		}
		
		// loop throug every article in given article list and check for filter critera
		for( int i = 0; i < articlelist.size(); i++ ) {
			Artikel currentArtikel = articlelist.get(i);

			if ( ( criteria.equals("Album") ) && ( currentArtikel instanceof Album ) ) {
					returnList.add( currentArtikel );
			}
			 // when article is Film typecast to film and check for Format and add article accordingly to returnList
			else if ( currentArtikel instanceof Film ) {
				Film currentFilm = (Film) currentArtikel; // typecast in order to use getFromat method
				if( currentFilm.getFormat().equals( "SD" ) && criteria.equals("SD") ){
					returnList.add(currentArtikel);
				}
				if( currentFilm.getFormat().equals( "HD" ) && criteria.equals("HD") ){
					returnList.add(currentArtikel);
		
			}
			}
			
		}
		//System.out.println( returnList );
			return returnList;
	}

	// overload filter method in order to filter for price range
	public List<Artikel> filter( List<Artikel> articles, double lowPrice, double highPrice ) {
		// init List we want to return
		List<Artikel> returnList = new ArrayList<Artikel>();
		for( int i = 0; i < articles.size(); i++ ) {
			Artikel currentArticle = articles.get(i); // local variable for readability
			// check if price of article is greater or equals to low Price limit and smaller or equal as upper limit
			if( ( currentArticle.getPreis() <= highPrice ) && ( currentArticle.getPreis() >= lowPrice ) ) {
				returnList.add( currentArticle );
			}
		}
		//System.out.println(returnList);
		return returnList;
	}

	// overloading filter method to filter articles based on how often they have been bougth
	public List<Artikel> filter( List <Artikel> articles, int criteria ) {
		// init List we want to return
		List <Artikel>returnList = new ArrayList<Artikel>();
		for(int i = 0; i < articles.size(); i++ ) {
			Artikel currentArtikel = articles.get(i);
			if( currentArtikel.getKaeufe() >= criteria ) {
				returnList.add( currentArtikel );
			}
		}
		//System.out.println( returnList );
		return returnList;
	}

	// overloading filter method to filter based on a given List oft tags
	public List<Artikel> filter( List<Artikel> articles, String[] tags ) {
		// init List we want to return
		List<Artikel> returnList = new ArrayList<Artikel>();
		// nesting for loops to loop through every given tag in every article
		for( int i = 0; i < articles.size(); i++ ) {
			Artikel currentArtikel = articles.get(i); // local variable for readability
			// lopping trhough given tags
			for( int j = 0; j < tags.length; j++ ) {
				String currentTag = tags[j];
				if( currentArtikel.getTags().contains( currentTag ) ) {
					returnList.add( currentArtikel );
				}
			}
		}
		//System.out.println(returnList);
		return returnList;
	}
}
