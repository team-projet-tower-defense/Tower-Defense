package app.modele;

import javafx.scene.image.ImageView;

public class Pigman extends Ennemi{

	public Pigman(int x, int y, Environnement environnement) {
		super(300, 40, 1, x, y, environnement);
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
