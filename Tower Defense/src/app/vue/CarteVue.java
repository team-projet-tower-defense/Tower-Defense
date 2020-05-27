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
import javafx.scene.shape.Circle;

public class CarteVue {
	
	private Carte carte;
	
	private TilePane tilePane ;
	
	//private Pane pane;
	 
	private StackPane stackPane;
	
	public CarteVue(Carte c, TilePane g/*, Pane p*/) {
		
		carte= c;
		tilePane=  g;
		//pane=p ; 
		
	}
	
	public void afficherCarte() {

		for (int x = 0; x < carte.getHauteur(); x++) {
			for (int y = 0; y < carte.getLargeur(); y++) {
				
				
				int codeCase = carte.getCase(x, y);

				if (codeCase == 7) {
					
					ajouterImage("sable.png");
					
				}

				else if (codeCase == 9) {
					
					ajouterImage("herbe.png");
					
				}

				else if (codeCase == 10) {
					
					ajouterImage("roche.png");
				}
				
				else if (codeCase == 11) {
					ajouterImage("nether.png");
				}
			}

		}

	}
	
	
	
	private void ajouterImage(String URL) {
		
		tilePane.getChildren().add(new ImageView("file:src/app/ressources/"+URL));
		
	}

}
