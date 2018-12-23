package nozama;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Nozama sd = new Nozama();
		String[][] artikel = Data.getArtikel();
		List<Artikel> myarticles = new ArrayList<Artikel>();
		for( int i=0;i < artikel.length; i++ ){
			String[] m = artikel[i];
			if( m[0].equals("Album") ){
				Album currentAlbum = new Album( m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],Integer.parseInt(m[7]),Integer.parseInt(m[8]));
				currentAlbum.buildTags();
				myarticles.add( currentAlbum );
				sd.addArtikel(currentAlbum);
			}
			else if( m[0].equals("Film") ){
				Film currentFilm = new Film( m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],m[7],m[8] );
				currentFilm.buildTags();
				myarticles.add( currentFilm );
				sd.addArtikel( currentFilm );
			}
		}

// TESTING MEHTODS ------------------------------------------------------------------------------------------------------------------------------------------------7

		sd.changeID();
		
		sd.countTags();
		
		// filter all articles that have been buyed more than 700 times
		List<Artikel> sevenhundred = sd.filter( myarticles, 700 );
		// filter the filterd List by pricerange
		List <Artikel> finalFilterd = sd.filter( sevenhundred, 5.50, 7.50 );
		System.out.println( finalFilterd );

		// second filer task HD nd tags horror and blood)
		List <Artikel> hd = sd.filter( myarticles, "HD" );
		String[] tagList = {"horror", "blood"};
		List<Artikel> filtered2 = sd.filter( hd, tagList );
		System.out.println( filtered2 );

		sd.sortArticle();
				
	}

}
