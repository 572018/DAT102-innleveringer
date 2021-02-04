package no.hvl.dat102.klient;

import java.util.Scanner;
import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;


public class Tekstgrensesnitt {
	public final static Scanner SC = new Scanner(System.in);
	// leser inn opplysningene om en FILM fra tastatur og returnerer et film objekt som skal sende til leggTil() 
	public void lesFilm(FilmarkivADT filmSamling){
		
		int filmNr = filmSamling.antall();
		System.out.println("Informasjon on ny film legges inn her.\nSkriv inn navnet på produsenten:");
		String produsent = SC.nextLine();
		System.out.println("Skriv inn tittelen på filmen:");
		String tittel = SC.nextLine();
		System.out.println("Skriv inn lanseringsÅr:");
		int lanseringsAr = Integer.parseInt(SC.nextLine());
		System.out.println("Velg sjanger fra listen {ACTION, DRAMA, HISTORY, SCIFI} på filmen:");
		Sjanger sjanger = Sjanger.finnSjanger(SC.nextLine());
		System.out.println("Skriv inn filmselskap:");
		String filmselskap = SC.nextLine();
		
		Film nyFilm = new Film(filmNr, produsent, tittel, lanseringsAr, sjanger, filmselskap);
		filmSamling.leggTil(filmSamling.antall(), nyFilm);
				
	}
	
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film){
		String str  = (film.getFilmNr()+"#"+ film.getProdusent() + "#"
				+ film.getTittel() + "#" + film.getLanseringsAr() + "#"
				+ film.getSjanger() + "#" + film.getFilmselskap());
		System.out.println(str);
	}
	
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filmSamling, String delstreng){
		Film[] tittel = filmSamling.søkTittel(delstreng);
		for (int i = 0; i < tittel.length; i++) {
			System.out.println(tittel[i].getTittel() + "\n");
		}
		
	}
	
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filmSamling, String delstreng) {
		Film[] tittel = filmSamling.søkProdusent(delstreng);
		for (int i = 0; i < tittel.length; i++) {
			System.out.println(tittel[i].getProdusent() + "\n");
		}
	}
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt // og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filmSamling){
		System.out.println(filmSamling.antall());
		System.out.println(filmSamling.antall(Sjanger.ACTION));
		System.out.println(filmSamling.antall(Sjanger.DRAMA));
		System.out.println(filmSamling.antall(Sjanger.HISTORY));
		System.out.println(filmSamling.antall(Sjanger.SCIFI));
		
	}
	//… Ev. andre metoder
}