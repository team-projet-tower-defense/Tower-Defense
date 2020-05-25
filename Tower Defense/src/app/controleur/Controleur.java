package app.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import app.modele.*;
import app.vue.CarteVue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.TilePane;


public class Controleur implements Initializable {

	@FXML
	private TilePane grille;

	private CarteVue terrainVue;
	
	private Carte carte;
	
	private Ennemi ennemi;
	
	private Tour tour;
	
	private ArrayList<Group> groupes = new ArrayList() ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		carte= new Carte();
		terrainVue = new CarteVue(carte, grille, groupes);
		terrainVue.afficherCarte();
		
		//afficherCarte();
	ennemi = new Pigman("Pigman",300,40,0,0,0);
	creerSpriteEnnemie(ennemi);
	
	tour = new Archer("Archer",400,40,0,0);
	creerSpriteTour(tour);
	
	//sssmouvement(ennemi);
	
	}
	
	
	/*public Ennemi ajouterEnnemi() {
		Ennemi e= new Ennemi(100,5,2,25,10);
		return e;
		
	}
	*/
	
	public void mouvement(Ennemi e) {
		
		Random random = new Random(); 
		
		int nbRandom = random.nextInt(10);
		
		e.getGroup().getChildren().remove(e.getSprite());
		
		e.setX(e.getX()+nbRandom);
		e.setY(e.getY()+nbRandom);
		
		
		
		groupes.get(e.getX()).getChildren().add(e.getSprite());
				
	}

	private void creerSpriteEnnemie(Ennemi e) {
		
		Group g = groupes.get(e.getX());
		
		ImageView imageE;
		
		
		imageE = attribuerImageEnnemi(e);
		
		
		e.setSprite(imageE);
		g.getChildren().add(imageE);
		e.setGroup(g);
		
	
	}
	
	private void creerSpriteTour(Tour t) {
		
		Group g = groupes.get(t.getX());
		
		
		ImageView imageD;
		
		imageD = attribuerImageTour(t);
		
		
		t.setSprite(imageD);
		g.getChildren().add(imageD);
		t.setGroup(g);
		
	
	}
	
	public ImageView attribuerImageEnnemi(Ennemi e) {
		
	ImageView imageEnnemi = null ; 
	
	if	(e instanceof Sorciere) {
		imageEnnemi = new ImageView("file:src/app/ressources/sorciere.png");
	}
	
	else if	(e instanceof Zombie) {
		imageEnnemi = new ImageView("file:src/app/ressources/zombie.png");
	}
	
	else if	(e instanceof Pigman) {
		imageEnnemi = new ImageView("file:src/app/ressources/pigman.png");
	}
	
	/*else if	(e instanceof Squelette) {
		imageEnnemi = new ImageView("file:src/app/ressources/squelette.png");
	}*/
	
	else if	(e instanceof Wither) {
		imageEnnemi = new ImageView("file:src/app/ressources/wither.png");
	}
	
	
	
	return imageEnnemi;
		
	}
	
	public ImageView attribuerImageTour(Tour t) {
		
		ImageView imageDefense = null ; 
		
		if	(t instanceof Archer) {
			imageDefense = new ImageView("file:src/app/ressources/archer.png");
		}
		
		else if	(t instanceof Catapulte) {
			imageDefense = new ImageView("file:src/app/ressources/catapulte.png");
		}
		
		else if	(t instanceof Mage) {
			imageDefense = new ImageView("file:src/app/ressources/mage.png");
		}
		
		else if	(t instanceof Chevalier) {
			imageDefense = new ImageView("file:src/app/ressources/chevalier.png");
		}
		
		return imageDefense;
			
		}
	
	/*
	 * Créer dans le package vue, une Classe CarteVue qui affiche la carte, priavate Carte, TilePane initialisés dans le 
	 */
	private void afficherCarte() {

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
	
	private void ajouterImage(String URL) {
		Group g = new Group();
		g.getChildren().add(new ImageView("file:src/app/ressources/"+URL));
		grille.getChildren().add(g);
		groupes.add(g);

	}
	

	
	
	
	
	

}
