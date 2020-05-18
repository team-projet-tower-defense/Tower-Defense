package app.vue;

import java.util.ArrayList;
import app.modele.Carte;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class CarteVue {
	
	private Carte carte;
	
	private TilePane grille;
	
	private ArrayList<Group> groupes;
	
	public CarteVue(Carte t, TilePane g) {
		
		groupes = new ArrayList();
		carte=new Carte();
		grille=g;
		
	}
	
	public void afficherCarte() {

		for (int x = 0; x < carte.getHauteur(); x++) {
			for (int y = 0; y < carte.getLargeur(); y++) {
				
				
				int codeCase = carte.getCase(x, y);

				if (codeCase == 7) {
					
					
					ajouterImage("sable.png");// à mettre dans vue
					
				
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
	
	public ArrayList<Group> getGroupes(){
		return groupes;
	}
	
	private void ajouterImage(String URL) {
		Group g = new Group();
		g.getChildren().add(new ImageView("file:src/app/ressources/"+URL));
		grille.getChildren().add(g);
		groupes.add(g);

	}

}
