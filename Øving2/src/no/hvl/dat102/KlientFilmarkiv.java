package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.klient.Meny;

public class KlientFilmarkiv{

	public static void main(String[] args){ 
		
		FilmarkivADT filmSamling = new Filmarkiv(10);
		Meny meny = new Meny(filmSamling);
		meny.start();
	}
}

