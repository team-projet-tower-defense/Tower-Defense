package app.vue;

import java.util.ArrayList;
import app.modele.Carte;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

public class CarteVue {
	
	private Carte carte;
	private TilePane decor ;
	
	public CarteVue(Carte c, TilePane d) {
		carte= c;
		decor= d;
	}
	
	public void afficherCarte() {
		for (int x = 0; x < carte.getLargeur(); x++) {
			for (int y = 0; y < carte.getHauteur(); y++) {
				
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
				
				else if (codeCase == 11) {
					ajouterImage("stone.png");
				}
				
				else if (codeCase == 10) {
					ajouterImage("nether.png");
				}
			}
		}
	}
	
	private void ajouterImage(String URL) {
		decor.getChildren().add(new ImageView("file:src/app/ressources2/"+URL));
	}
}
