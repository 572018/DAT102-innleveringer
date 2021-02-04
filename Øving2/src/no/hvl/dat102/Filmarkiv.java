package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.klient.Sjanger;


public class Filmarkiv implements FilmarkivADT {

	private Film [] filmSamling;
	private int nesteLedig;
	
	public Filmarkiv (int Antall) {
		filmSamling = new Film[Antall];
		nesteLedig = 0;
	}
	
	public void leggTil (int nesteLedig, Film xFilm) {
		if (nesteLedig == filmSamling.length){
			utvidKapasitet();
		}
		filmSamling[nesteLedig] = xFilm;
		nesteLedig++;
	}
	
	public boolean slettFilm (int filmNr) {
		for(int i = 0; i <= filmSamling.length; i++) {
			if (filmNr == filmSamling[i].getFilmNr()) {
				filmSamling[i] = filmSamling[nesteLedig-1];
				nesteLedig--;
				return true;
			}
		}
		return false;
	}
	
	public Film[] søkTittel (String delstreng) {
		
		Film[] tittel = new Film[filmSamling.length];
		int j = 0;
		for(int i = 0; i <= filmSamling.length; i++) {
			if(delstreng == filmSamling[i].getTittel().substring(0)) {
				tittel[j] = filmSamling[i];
				j++;
			}
		}
		return tittel;
	}
	
	public Film[] søkProdusent (String delstreng) {
		Film[] produsent = new Film[filmSamling.length];
		int j = 0;
		for(int i = 0; i <= filmSamling.length; i++) {
			if(delstreng == filmSamling[i].getProdusent().substring(0)) {
				produsent[j] = filmSamling[i];
				j++;
			}
		}
		return produsent;
	}

	public Film[] hentFilmTabell() {
		Film[] trimTab = new Film[nesteLedig-1];
		int i = 0;
		while(i <= trimTab.length) {
			trimTab[i] = filmSamling[i];
		}
		return trimTab;
	}

	public int antall(Sjanger sjanger) {
		int antall = 0;
		for(int i = 0; i <= filmSamling.length; i++) {
			if(sjanger == filmSamling[i].getSjanger()) {
				antall++;
			}
		}
		return antall;
	}
	
	public int antall() {
		return nesteLedig;
	}
	
	private void utvidKapasitet(){//eks. utvide 10%
		Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 * filmSamling.length)];
		for (int i = 0; i < filmSamling.length; i++){
		hjelpetabell[i] = filmSamling[i];
		}
		filmSamling = hjelpetabell;
		}
	
	public Film[] getFilmSamling() {
		return filmSamling;
	}

	public void setFilmSamling(Film[] filmSamling) {
		this.filmSamling = filmSamling;
	}
}
