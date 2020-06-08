package app.modele;

import java.util.ArrayList;

public class Manche {
	
	private ArrayList<Ennemi> ennemis;
	
	private ArrayList<Tour> defenses;
	
	private Carte carte; 
	
	private Environnement environnement;
	
	public Manche(ArrayList<Ennemi> e, Carte c, Environnement env) {
		
		ennemis= e;
		carte =c;
		environnement=env;
		
	}

}
