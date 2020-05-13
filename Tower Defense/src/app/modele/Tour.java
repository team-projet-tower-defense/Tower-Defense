package app.modele;

public class Tour {
	
	private int pv;
	
	private int attaque;
	
	private int x,y;
	
	public Tour(int p, int a, int x, int y) {
		pv=p;
		attaque=a;
		this.x=x;
		this.y=y;
	}
	
	public int attaque(Ennemi e) {
		return attaque;
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
