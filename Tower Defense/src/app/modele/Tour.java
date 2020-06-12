package app.modele;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Tour {
	
	private int pv;
	private int attaque;
	private double x,y;
	private ImageView sprite;
	
	public Tour(int p, int a, double d, double e) {
		pv = p;
		attaque = a;
		this.x = d;
		this.y = e;
		
	}
	
	public abstract void agit();
	
	public int attaque(Ennemi e) {
		return attaque;
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
	
	public ImageView getSprite() {
		return sprite;
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
	
	public void setSprite(ImageView s) {
		sprite=s;
	}

}
