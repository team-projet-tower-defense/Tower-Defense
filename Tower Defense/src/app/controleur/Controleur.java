package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.Carte;
import app.modele.Tour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable {

	@FXML
	private TilePane grille;

	private Carte carte;
	
	private Tour defense;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.carte = new Carte();
		afficherCarte();
		ajouterDefense();
		creerSprite(defense);
	}
	
	public void ajouterDefense() {
		defense= new Tour(10,10,10,10);
		
	}
	
	private void creerSprite(Tour a) {
		
		Circle r= new Circle(2);
		r.setFill(Color.WHITE);
		
		r.setTranslateX(a.getX());
		r.setTranslateY(a.getY());	
		grille.getChildren().add(r);
	}

	private void afficherCarte() {

		for (int x = 0; x < carte.getLargeur(); x++) {
			for (int y = 0; y < carte.getHauteur(); y++) {
				grille = new TilePane();
				Image tile;
				int codeCase = carte.getCase(x, y);

				if (codeCase == 7) {
					grille.getChildren().add(ajouterImage("sable.png"));
				}

				else if (codeCase == 9) {
					grille.getChildren().add(ajouterImage("herbe.png"));
					
				}

				else if (codeCase == 10) {
					grille.getChildren().add(ajouterImage("bois.png"));
				}
			}

		}

	}
	
	

	private ImageView ajouterImage(String URL) {
		Image tile = new Image("/"+URL);
		ImageView resu = new ImageView();
		resu.setImage(tile);
		return resu;

	}

}
