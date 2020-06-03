package app.modele;

import java.util.Random;

import app.vue.CarteVue;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Ennemi {
	
	private int x,y;
	private int dx,dy ; // direction 
	private int pv;
	private int attaque;
	private int vitesse;
	private ImageView sprite;
	
	protected Environnement environnement;
	
	public Ennemi(int p, int a, int v, int x, int y, Environnement env) {
		this.pv = p;
		this.attaque = a;
		this.vitesse = v;
		this.x = x;
		this.y = y;
		this.environnement = env;
	}
	
	@Override
	public String toString() {
		return "Ennemi [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy
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
		x = n;
	}

	public  int getY() {
		return y;
	}
	
	public  void setY(int n){
		y = n;
	}
	
	public void decrementerPv(int n) {
		this.pv -= n;	
	}

	public void incrementerPv(int n) {
		this.pv += n;	
	}

	public boolean estVivant() {
		return this.pv > 0;
	}

	public void meurt(){
		this.pv = 0;
	}
	
	public void attaqueTour(Tour d) {
		d.recevoirDegats(attaque);
	}
	
	public boolean estEnVie() {
		if(pv != 0) {
			return true;
		}
		return false;
	}
	
	public void seDeplace() {
		Random random = new Random();
		int randomInt = random.nextInt(3);
		int PosX = this.getX() + this.vitesse * randomInt;
		int PosY = this.getY() + this.vitesse * randomInt;
		
		while(!(environnement.dansTerrain(PosX, PosY))) {
			PosX = this.getX() + this.vitesse * randomInt;
			PosY = this.getY() + this.vitesse * randomInt;
		}
		
		this.setX(PosX);
		this.setY(PosY);
	}
}
