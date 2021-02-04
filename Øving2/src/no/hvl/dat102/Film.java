package no.hvl.dat102;

import no.hvl.dat102.klient.Sjanger;

public class Film {


	private int filmNr;
	private String produsent;
	private String tittel;
	private int lanseringsAr;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film () {
		
	}
	
	public Film (int filmNr, String produsent, String tittel, int lanseringsAr, Sjanger sjanger, String filmselskap) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsAr = this.lanseringsAr;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsAr() {
		return lanseringsAr;
	}

	public void setLanseringsAr(int lanseringsAr) {
		this.lanseringsAr = lanseringsAr;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	
}

