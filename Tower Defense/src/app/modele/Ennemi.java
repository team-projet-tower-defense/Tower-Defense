package app.modele;

import java.util.Random;

import app.vue.CarteVue;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Ennemi {
	
	private int x,y;
	
	private Group groupe;
	
	private ImageView sprite;
	
	private int dx,dy ;// direction 
	
	private int pv;
	
	private int attaque;
	
	private int vitesse;
	
	
	public Ennemi(int p, int a, int v, int x, int y, ImageView s) {
		
		
		pv=p;
		attaque=a;
		vitesse=v;
		this.x=x;
		this.y=y;
		sprite=s;
		
	}
	
	@Override
	public String toString() {
		return "Ennemi [x=" + x + ", y=" + y + ", groupe=" + groupe + ", dx=" + dx + ", dy=" + dy
				+ ", pv=" + pv + ", attaque=" + attaque + ", vitesse=" + vitesse + "]";
	}

	public void butin() {
		//faire tomber butin 
	}
	

	public abstract void agit();
	
	
	public int getX() {
		return x;
	}

	public  void setX(int n){
		x=n;
	}
	
	public void setGroup(Group g) {
		groupe=g;
	}
	
	public void setSprite(ImageView s) {
		sprite=s;
	}
	
	public ImageView getSprite() {
		return sprite;
	}
	
	public Group getGroup() {
		return groupe;
	}

	public  int getY() {
		return y;
	}
	public  void setY(int n){
		y=n;
	}
	
	public void decrementerPv(int n) {
		this.pv-=n;	
	}

	public void incrementerPv(int n) {
		this.pv+=n;	
	}

	public boolean estVivant() {
		return this.pv>0;
	}

	public void meurt(){
		this.pv=0;
	}
	
	public void attaqueTour(Tour d) {
		d.recevoirDegats(attaque);
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}

}
