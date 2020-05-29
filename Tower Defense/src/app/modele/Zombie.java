package app.modele;

import javafx.scene.image.ImageView;

public class Zombie extends Ennemi {

	public Zombie(int x, int y) {
		super(100, 40, 2, x, y);
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
