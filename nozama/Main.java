package nozama;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		
		Nozama sd = new Nozama();
		String[][] artikel = Data.getArtikel();

		for( int i=0; i<artikel.length; i++ ){
			String[] m = artikel[i];
			if( m[0].equals("Album") ){
				Album currentAlbum = new Album( m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],Integer.parseInt(m[7]),Integer.parseInt(m[8]));
				currentAlbum.buildTags();
				// I prited the tags for testing
				//currentAlbum.getTags();
				sd.addArtikel(currentAlbum);
			}
			else if( m[0].equals("Film") ){
				Film currentFilm = new Film( m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],m[7],m[8] );
				currentFilm.buildTags();
				// I prited the tags for testing
				// currentFilm.getTags();
				sd.addArtikel( currentFilm );
			}
		}

		

		//sd.changeID();
		//sd.sortArticle();
		sd.countTags();
				
	}

}
