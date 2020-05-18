package app.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import app.modele.Carte;
import app.modele.Ennemi;
import app.modele.Tour;
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

	
	
	private Carte carte;
	
	private Ennemi ennemi;
	
	private ArrayList<Group> groupes = new ArrayList() ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		carte= new Carte();
		CarteVue terrainVue = new CarteVue(carte, grille);
		ArrayList<Group> groupes = terrainVue.getGroupes();
		//terrainVue.afficherCarte();
		
		afficherCarte();
		ennemi = new Ennemi(100,5,2,1,10);
		creerSprite(ennemi);
		mouvement(ennemi);

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
		
		
		
		groupes.get(e.getX()).getChildren().add(e.getSprite());
				
	}

	private void creerSprite(Ennemi e) {
		
		Group g = groupes.get(e.getX());
		
		
		e.setSprite(new ImageView("file:src/app/ressources/sorciere.png"));
		g.getChildren().add(e.getSprite());
		e.setGroup(g);
		
		//(x*20+y)	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	