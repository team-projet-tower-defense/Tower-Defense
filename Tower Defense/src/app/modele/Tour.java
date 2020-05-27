package app.modele;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Tour {
	
	private int pv;
	
	private int attaque;
	
	private int x,y;
	
	private ImageView sprite;
	
	public Tour(int p, int a, int x, int y, ImageView s) {
		
		pv=p;
		attaque=a;
		this.x=x;
		this.y=y;
		sprite=s;
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
