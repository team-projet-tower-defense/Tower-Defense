package app.modele;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Tour {
	
	private int pv;
	
	private int attaque;
	
	private int x,y;
	
	private String nomDefense;
	
	private Group groupe;
	
	private ImageView sprite;
	
	public Tour(String nomDefense, int p, int a, int x, int y) {
		nomDefense=nomDefense;
		pv=p;
		attaque=a;
		this.x=x;
		this.y=y;
	}
	
	public abstract void agit();
	
	public int attaque(Ennemi e) {
		return attaque;
	}
	
	public void recevoirDegats(int d) {
		pv-=d;
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setGroup(Group g) {
		groupe=g;
	}
	
	public void setSprite(ImageView s) {
		sprite=s;
	}
	
	public ImageView getSprite() {
		return sprite;
	}
	
	public Group getGroup() {
		return groupe;
	}
}
