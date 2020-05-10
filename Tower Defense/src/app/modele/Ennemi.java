package app.modele;

public class Ennemi {
	
	private int pv;
	
	private int attaque;
	
	private int vitesse;
	
	public Ennemi(int p, int a, int v) {
		pv=p;
		attaque=a;
		vitesse=v;
	}
	
	public void seDeplace() {
		
	}
	
	public int attaque(Defense d) {
		return attaque;
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}

}
