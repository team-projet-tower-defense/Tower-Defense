package app.modele;

import javafx.scene.image.ImageView;

public class Squelette extends Ennemi {
	
	public Squelette(int x, int y, Environnement environnement) {
		super(200, 40, 2, x, y, environnement);
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
