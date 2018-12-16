package nozama;

public class Main {

	public static void main(String[] args) {
		
		Nozama sd = new Nozama();
		String[][] artikel = Data.getArtikel();
		for( int i=0; i<artikel.length; i++ ){
			String[] m = artikel[i];
			if( m[0].equals("Album") ){
				sd.addArtikel(new Album(m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],Integer.parseInt(m[7]),Integer.parseInt(m[8])));
			}
			else if( m[0].equals("Film") ){
				sd.addArtikel(new Film(m[1],m[2],Integer.parseInt(m[3]),Float.parseFloat(m[4]),Integer.parseInt(m[5]),m[6],m[7],m[8]));
			}
		}
				
	}

}
