package app.modele;

import java.util.ArrayList;

public class Carte {
	
	private int largeur=20;
	private int hauteur=15;
	
	private int[][] terrain = {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
			 {10, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10}, 
			 {10, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 9, 9, 7, 7, 7, 7, 7, 7, 7}, 
			 {10, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 9, 9, 7, 7, 7, 7, 7, 7, 7},
			 {10, 9, 9, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 7, 7, 9, 9, 9, 9, 10},
			 {11, 7, 7, 7, 7, 7, 7, 9, 9, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 10},
			 {11, 7, 7, 7, 7, 7, 7, 9, 9, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10},
			 {10, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10},
			 {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}}; 
	

	public Carte() {
		
	}
	

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
	
	public int getCase(int x, int y) {
		return terrain[x][y];
	}

	
	
	
	
	

}
