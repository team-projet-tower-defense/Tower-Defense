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
import javafx.scene.input.MouseEvent;

public class CarteVue {
	
	private Carte carte;
	private TilePane decor ;
	
	public CarteVue(Carte c, TilePane d) {
		carte= c;
		decor= d;
	}
// Mettre en switch case
	public void afficherCarte() {
		for (int x = 0; x < carte.getHauteur(); x++) {
			for (int y = 0; y < carte.getLargeur(); y++) {
				
				int codeCase = carte.getCase(x, y);

				if (codeCase == 6) {
					
					ajouterImage("sable.png");
				}

				else if (codeCase == 8) {
					ajouterImage("herbe.png");
				}

				else if (codeCase == 7) {
					ajouterImage("roche.png");
				}
				
				else if (codeCase == 10) {
					ajouterImage("nether.png");
				}
				
				else if (codeCase == 11) {
					ajouterImage("stone.png");
				}	
			}
		}
	}
	
	public void ajouterImage(String URL) {
		ImageView  img = new ImageView("file:Tower Defense/src/app/ressources/"+URL);
		if(URL == "stone.png") {
			img.setId("stone");
		}
		decor.getChildren().add(img);		
	}
}
