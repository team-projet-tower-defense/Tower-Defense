package app.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.modele.Carte;
import app.modele.Ennemi;
import app.modele.Tour;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable {

	@FXML
	private TilePane grille;

	private static int[][] carte = Carte.getTerrain() ;
	
	private Ennemi ennemi;
	
	private Timeline gameLoop;
	
	private int temps;
	
	private ArrayList<Group> groupes = new ArrayList() ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		afficherCarte();
		
		creerSprite(ajouterEnnemi());
		//
	}
	
	public Ennemi ajouterEnnemi() {
		Ennemi e= new Ennemi(100,5,2,10,10);
		return e;
		
	}
	
	private void creerSprite(Ennemi e) {
		
		Group g = groupes.get(e.getX());
		
		
		ImageView resu = new ImageView("file:src/app/ressources/sorciere.png");
		g.getChildren().add(resu);
		
	
		//group
		//blend mode multiply
		//grille.getChildren().add(resu);
		//(x*20+y)
		
		
		
		
		
	}

	private void afficherCarte() {

		for (int x = 0; x < carte.length; x++) {
			for (int y = 0; y < carte[x].length; y++) {
				
				Group g = new Group();
				int codeCase = carte[x][y];

				if (codeCase == 7) {
					
					
					g.getChildren().add(new ImageView("file:src/app/ressources/sable.png"));
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
