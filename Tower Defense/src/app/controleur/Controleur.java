package app.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import app.modele.Carte;
import app.modele.Ennemi;
import app.modele.Tour;
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

	
	
	private Carte terrain;
	
	private Ennemi ennemi;
	
	private ArrayList<Group> groupes = new ArrayList() ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		terrain= new Carte();
		//terrainVue = new CarteVue(Carte, TilePane)
		//terrainVue.afficherCarte()
		
		afficherCarte();
		ennemi = new Ennemi(100,5,2,25,10);
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

		for (int x = 0; x < terrain.getLargeur(); x++) {
			for (int y = 0; y < terrain.getHauteur(); y++) {
				
				Group g = new Group();
				int codeCase = terrain.getCase(x, y);

				if (codeCase == 7) {
					
					
					g.getChildren().add(new ImageView("file:src/app/ressources/sable.png"));// à mettre dans vue
					grille.getChildren().add(g);
					groupes.add(g);
				
				}

				else if (codeCase == 9) {
					
					g.getChildren().add(new ImageView("file:src/app/ressources/herbe.png"));
					grille.getChildren().add(g);
					groupes.add(g);
					
				}

				else if (codeCase == 10) {
					
					g.getChildren().add(new ImageView("file:src/app/ressources/roche.png"));
					grille.getChildren().add(g);
					groupes.add(g);
				}
				
				else if (codeCase == 11) {
					g.getChildren().add(new ImageView("file:src/app/ressources/nether.png"));
					grille.getChildren().add(g);
					groupes.add(g);
				}
			}

		}

	}
	
	private ImageView ajouterImage(String URL) {
		Image tile = new Image("app/ressources/"+URL);
		ImageView resu = new ImageView();
		resu.setImage(tile);
		return resu;

	}
	
	
	
	
	

}
