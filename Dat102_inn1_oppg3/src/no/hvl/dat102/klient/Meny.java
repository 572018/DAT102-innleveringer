package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmSamling;
	public Meny(FilmarkivADT filmSamling){ tekstgr = new Tekstgrensesnitt();
	this.filmSamling = filmSamling; }
	
	public void start(){
		System.out.println("\nSkriv inn en kommando...");
		
		
		while (true) {
			
			
			switch (Tekstgrensesnitt.SC.nextLine()) {
			
			case "kommando":
				System.out.println("Kommandoer: viser kommandolisten\nlesinnfilm: Legger til en film til arkivet\nExit: Stopper programmet");
				break;
				
			case "lesinnfilm":
				tekstgr.lesFilm(filmSamling);
				break;
				
			case "avslutt":
				System.out.println("Avslutter...");
				System.exit(0);
				break;
	
		default: 
			System.out.println("Ugyldig kommando");
			}
			
		}
	}
	
}

