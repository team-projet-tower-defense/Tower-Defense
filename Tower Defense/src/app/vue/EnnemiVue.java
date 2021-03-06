package app.vue;

import app.modele.Ennemi;
import app.modele.Pigman;
import app.modele.Sorciere;
import app.modele.Squelette;
import app.modele.Wither;
import app.modele.Zombie;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnnemiVue {
	
	private ImageView sprite;
	private Ennemi ennemi;
	private Pane pane;
	
	public EnnemiVue(Ennemi e, Pane p) {
		this.ennemi = e;
		this.pane = p;
	}
	
	private void attribuerImageEnnemi() {
		if (ennemi instanceof Zombie) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/zombie.png");
		}
		
		else if (ennemi instanceof Sorciere) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/sorciere.png");
		}
		
		else if (ennemi instanceof Wither) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/wither.png");
		}
		
		else if (ennemi instanceof Pigman) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/pigman.png");
		}
		
		else if  (ennemi instanceof Squelette) {
			sprite = new ImageView("file:Tower Defense/src/app/ressources/squelette.png");
		}	
	}
	
	public void creerSpriteEnnemi() {
		this.attribuerImageEnnemi();
		sprite.setTranslateX(ennemi.getX());
		sprite.setTranslateY(ennemi.getY());
		pane.getChildren().add(sprite);
	}
	
	public void deplacementSprite() {
		sprite.setTranslateX(ennemi.getX());
		sprite.setTranslateY(ennemi.getY());
	}
	
	public void setSprite(ImageView s) {
		sprite=s;
	}
	
	public ImageView getSprite() {
		return sprite;
	}
	
	public Ennemi getEnnemi() {
		return ennemi;
	}

	public void setNull() {
		this.sprite= null;
	}
}
