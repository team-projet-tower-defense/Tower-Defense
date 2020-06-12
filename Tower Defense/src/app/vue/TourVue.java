package app.vue;

import app.modele.Archer;
import app.modele.Catapulte;
import app.modele.Chevalier;
import app.modele.Ennemi;
import app.modele.Mage;
import app.modele.Pigman;
import app.modele.Sorciere;
import app.modele.Squelette;
import app.modele.Tour;
import app.modele.Wither;
import app.modele.Zombie;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TourVue {
	
	public ImageView sprite;
	@FXML
	private Pane pane1;
	
	private Pane pane;
	private Tour tour;
	
	public TourVue(Tour t, Pane p) {
		this.tour=t;
		this.pane =p;
	}
	
//	public String attribuerImageEnnemi(int idTour) {
//		
//		String URLImage = null;
//		
//		if (idTour == 1) { 
//			URLImage = "file:Tower Defense/src/app/ressources/archer.png";
//		}
//		
//		else if (idTour == 2) { 
//			URLImage = "file:Tower Defense/src/app/ressources/mage.png";
//		}
//		
//		else if (idTour == 3) { 
//			URLImage = "file:Tower Defense/src/app/ressources/catapulte.png";
//		}
//		
//		else if (idTour == 4) { 
//			URLImage = "file:Tower Defense/src/app/ressources/chevalier.png";
//		}
//		
//		return URLImage;		
//	}
	
//	public void creerSpriteTour() {
//		
//		this.attribuerImageEnnemi();
//		sprite.setTranslateX(tour.getX());
//		sprite.setTranslateY(tour.getY());
//		pane.getChildren().add(sprite);
//		
//	}
//	
//	public void deplacementSprite() {
//		sprite.setTranslateX(tour.getX());
//		sprite.setTranslateY(tour.getY());
//	}
	
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
