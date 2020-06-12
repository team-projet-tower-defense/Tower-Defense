package app.modele;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Tour {
	
	private int pv;
	private int attaque;
	private double x,y;
	
	
	public Tour(int p, int a, double d, double e) {
		pv = p;
		attaque = a;
		this.x = d;
		this.y = e;
		
	}
	
	public abstract void agit();
	
	public void attaque(Ennemi e) {
		if(Math.sqrt(Math.pow(e.getX()-x, 2)+Math.pow(e.getY()-y,2))<=96) {
			
			e.decrementerPv(attaque);
			
		}
	}
	
	public int ressourcesDiamant() {
		
		if (this instanceof Chevalier) { 
			return 20;
		}
		
		else if (this instanceof Mage) { 
			return 15;
		}
		
		else if (this instanceof Archer) { 
			return 5;
		}
		
		else/* if (this instanceof Catapulte)*/ { 
			return 10;
		}	
		
	}
	
	public void recevoirDegats(int d) {
		pv-=d;
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return "x: " + x +" y: "+y;
	}

}
