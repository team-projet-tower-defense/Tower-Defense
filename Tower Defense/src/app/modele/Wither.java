package app.modele;

public class Wither extends Ennemi {

	public Wither(String nomEnnemi, int p, int a, int v, int x, int y) {
		super("Wither",1000, 500, v, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agit() {
		// TODO Auto-generated method stub
		int ax=this.getX();
		int ay= this.getY();
		//this.seDeplace();
	}

}
