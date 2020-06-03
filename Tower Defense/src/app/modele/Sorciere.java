package app.modele;

import javafx.scene.image.ImageView;

public class Sorciere extends Ennemi{

	public Sorciere(int x, int y, Environnement environnement) {
		super(400, 30, 4, x, y, environnement);
	}

	@Override
	public void agit() {
		int ax=this.getX();
		int ay= this.getY();
		//this.seDeplace();
	}
	
	
	

}
