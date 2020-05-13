package app.modele;

public class Ennemi {
	
	private int x,y;
	
	private int dx,dy ;// direction 
	
	private int pv;
	
	private int attaque;
	
	private int vitesse;
	
	public Ennemi(int p, int a, int v) {
		pv=p;
		attaque=a;
		vitesse=v;
	}
	
	public  int getX() {
		return x;
	}

	public  void setX(int n){
		x=n;
	}

	public  int getY() {
		return y;
	}
	public  void setY(int n){
		y=n;
	}
	
	public void seDeplace() {
		
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
