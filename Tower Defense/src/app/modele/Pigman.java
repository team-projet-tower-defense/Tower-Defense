package app.modele;

import javafx.scene.image.ImageView;

public class Pigman extends Ennemi{

	public Pigman(int p, int a, int v, int x, int y) {
		super(300, 40, v, x, y, new ImageView("file:src/app/ressources/pigman.png"));
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
