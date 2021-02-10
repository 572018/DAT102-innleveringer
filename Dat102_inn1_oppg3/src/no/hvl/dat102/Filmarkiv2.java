package no.hvl.dat102;


import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.klient.Sjanger;


public class Filmarkiv2 implements FilmarkivADT{
	private int nesteLedig;
	private LinearNode<Film> start;
	//Film film blir brukt i konstruktør, hvorfor gir java en warning her?
	@SuppressWarnings("unused")
	private Film film;
	//OBS! Ingen referanse til siste, kun start …
		/* Klassen skal ha de samme operasjoner som for Filmarkiv i øving 2,
		 *  men pass på at implementeringen av alle metoder blir tilpasset den nye strukturen. */

	public Filmarkiv2 () {
		film = new Film();
		nesteLedig = 0;
	}
	
	public void leggTil (Film xFilm) {
		LinearNode<Film> nyFilm = new LinearNode<Film>(xFilm);
		nyFilm.setNeste(start);
		start = nyFilm;
		nesteLedig++;
	}
	
	public boolean slettFilm (int filmNr) {
		boolean finnes = false;
		LinearNode<Film> denne = start;
		//Hvis første filmen er den som skal slettes kjøres denne koden
		
		if (denne.getElement().getFilmNr()==filmNr) {
			finnes = true;
			denne.setNeste(start);
		}
		while(denne != null) {
			if (denne.getNeste().getElement().getFilmNr()==filmNr) {
				denne.setNeste(denne.getNeste().getNeste());
				finnes = true;
			}
			denne = denne.getNeste();
		}
		nesteLedig--;
		return finnes;
	}
	
	public Film[] søkTittel (String delstreng) {
		LinearNode<Film> forrige = start;
		LinearNode<Film> denne = start.getNeste();
		Film[] result = new Film[nesteLedig];
	
		int i = 0;
		if (forrige.getElement().getTittel().contains(delstreng)) {
			result[i] = forrige.getElement();
			i++;
		}
		while(denne != null) {
			if (denne.getElement().getTittel().contains(delstreng)) {				
				result[i] = denne.getElement();
				i++;
			}
			denne = denne.getNeste();
		}
		trimTab(result,i);
		return result;
	}
	
	public Film[] søkProdusent (String delstreng) {
		LinearNode<Film> forrige = start;
		LinearNode<Film> denne = start.getNeste();
		Film[] result = new Film[nesteLedig];
		int i = 0;
		if (forrige.getElement().getProdusent().contains(delstreng)) {
			result[i] = forrige.getElement();
			i++;
		}
		while(denne != null) {
			if (denne.getElement().getProdusent().contains(delstreng)) {				
				result[i] = denne.getElement();
				i++;
			}
			denne = denne.getNeste();
		}
		trimTab(result,i);
		return result;
	}

	public Film[] hentFilmTabell() {
		LinearNode<Film> denne = start;
		Film[] result = new Film[nesteLedig];
		int i = 0;
		while(denne != null) {
			result[i] = denne.getElement();
			denne.getNeste();
			i++;
		}
		return result;
	}

	public int antall(Sjanger sjanger) {
		LinearNode<Film> denne = start;
		int antall = 0;
		while(denne != null) {
			if(denne.getElement().getSjanger().equals(sjanger)) {
				antall++;
			}
			denne = denne.getNeste();
		}
		return antall;
	}
	
	public int antall() {
		return nesteLedig;
	}

	public Film[] trimTab(Film[] tab, int n) { // n er antall elementer
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
		filmtab2[i] = tab[i];
		i++;
		}//while
		return filmtab2;
		}//
	
}