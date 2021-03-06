package app.vue;

import app.modele.Archer;
import app.modele.Catapulte;
import app.modele.Chevalier;
import app.modele.Mage;
import app.modele.Tour;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TourVue {
	
	private ImageView sprite;
	private Pane pane;
	private Tour tour;
	
	public TourVue(Tour t, Pane p) {
		this.tour=t;
		this.pane =p;
		this.creerSpriteTour();
	}
	
	private void attribuerImageEnnemi() {
		if (tour instanceof Archer ) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/archer.png");
		}
		else if (tour instanceof Mage) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/mage.png");
		}
		else if (tour instanceof Catapulte) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/catapulte.png");
		}
		else if (tour instanceof Chevalier) { 
			sprite = new ImageView("file:Tower Defense/src/app/ressources/chevalier.png");
		}		
	}
	
	public void creerSpriteTour() {
		this.attribuerImageEnnemi();
		sprite.setTranslateX(tour.getX());
		sprite.setTranslateY(tour.getY());
		pane.getChildren().add(sprite);
	}
	
	public void deplacementSprite() {
		sprite.setTranslateX(tour.getX());
		sprite.setTranslateY(tour.getY());
	}
	
	public void setSprite(ImageView s) {
		sprite=s;
	}
	
	public ImageView getSprite() {
		return sprite;
	}
	
	public Tour getTour() {
		return tour;
	}
}
