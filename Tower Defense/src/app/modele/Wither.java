package app.modele;

import javafx.scene.image.ImageView;

public class Wither extends Ennemi {

	public Wither(int x, int y) {
		super(1000, 500, 1, x, y, new ImageView("file:src/app/ressources/wither.png"));
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
