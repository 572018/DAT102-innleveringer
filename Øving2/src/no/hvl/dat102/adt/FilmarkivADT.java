package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.klient.Sjanger;

public interface FilmarkivADT {

	//Legger til en film i samlingen
	void leggTil (int nesteLedig, Film xFilm);
	
	//Sletter en film fra samlingen
	boolean slettFilm (int filmNr);
	
	//Søker etter titteler i samlingen og returnerer tittler med en gitt delstreng
	Film [] søkTittel (String delstreng);

	// Returnere en tabell av Filmer
	Film[] hentFilmTabell();
	
	// Søker og henter produsenter med en gitt delstreng
	Film[] søkProdusent(String delstreng);
	
	// Henter antall Filmer for en gitt sjanger
	int antall (Sjanger sjanger); 
	
	// Returnerer antall Filmer 
	int antall();
}


