package app.modele;

import javafx.scene.image.ImageView;

public class Sorciere extends Ennemi{

	public Sorciere(int x, int y, Environnement environnement) {
		super(400, 30, 4, x, y, environnement);
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