package app.modele;

import java.util.ArrayList;

import app.vue.EnnemiVue;

public class Diamant {
	
	private ArrayList<Integer> barreDiamant;
	private Ennemi ennemi;
	private Tour tour;
	
	public Diamant() {

	}
	
	private void ajouterDiamant() {
		int nbrAajouter = ennemi.butin();
		
		do {
		
		for (int i = 0 ; i < nbrAajouter ; i ++)
			barreDiamant.add(1);
		
		}while(nbrAajouter < 20);	
	}
	
	private void decrementerDiamant() {
		int nbrAaDecrementer = tour.resourcesDiamant();
		
		do {
		
		for (int i = 0 ; i < nbrAaDecrementer ; i ++)
			barreDiamant.remove(1);
		
		}while(nbrAaDecrementer < 0);	
	}
	
	
	
	
}
