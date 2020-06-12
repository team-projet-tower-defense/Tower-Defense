package app.vue;

import java.util.ArrayList;
import app.modele.Carte;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CarteVue {
	
	private Carte carte;
	private TilePane decor ;
	
	public CarteVue(Carte c, TilePane d) {
		carte= c;
		decor= d;
	}
	
	public void afficherCarte() {
		for (int x = 0; x < carte.getHauteur(); x++) {
			for (int y = 0; y < carte.getLargeur(); y++) {
				
				int codeCase = carte.getCase(x, y);
				
				switch(codeCase){
					case 6:
						ajouterImage("sable.png");
						break;
					case 7:
						ajouterImage("roche.png");
						break;
					case 8:
						ajouterImage("herbe.png");
						break;
					case 10:
						ajouterImage("nether.png");
						break;
					case 11:
						ajouterImage("stone.png");
						break;
					case 12:
						ajouterImage("coffre.png");
						
				}

			}
		}
	}
	
	private void ajouterImage(String URL) {
		decor.getChildren().add(new ImageView("file:src/app/ressources2/"+URL));
	}
}
