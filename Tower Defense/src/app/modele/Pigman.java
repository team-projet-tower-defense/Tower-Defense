package app.modele;

public class Pigman extends Ennemi{

	public Pigman(String nomEnnemi, int p, int a, int v, int x, int y) {
		super("Pigman",300, 40, v, x, y);
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
