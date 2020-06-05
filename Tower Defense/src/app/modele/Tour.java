package app.modele;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Tour {
	
	private int pv;
	private int attaque;
	private int x,y;
	private ImageView sprite;
	protected Environnement environnement;
	
	public Tour(int p, int a, int x, int y, Environnement environnement) {
		pv = p;
		attaque = a;
		this.x = x;
		this.y = y;
		this.environnement = environnement;
	}
	
	public abstract void agit();
	
	public int attaque(Ennemi e) {
		return attaque;
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setSprite(ImageView s) {
		sprite=s;
	}

}
