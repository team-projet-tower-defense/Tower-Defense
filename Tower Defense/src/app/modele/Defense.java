package app.modele;

public class Defense {
	
	private int pv;
	
	private int attaque;
	
	private int x,y;
	
	public Defense(int p, int a, int x, int y) {
		pv=p;
		attaque=a;
		this.x=x;
		this.y=y;
	}
	
	public int attaque(Ennemi e) {
		return attaque;
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}

}
