package app.modele;

public class Sorcière extends Ennemi{

	public Sorcière(String nomEnnemi,int p, int a, int v, int x, int y) {
		super("Sorcière",400, 30, v, x, y);
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
