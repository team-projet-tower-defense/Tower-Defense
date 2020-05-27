package app.controleur;

import java.net.URL;
import javafx.scene.layout.StackPane;
import java.util.Random;
import java.util.ResourceBundle;
import app.modele.*;
import app.vue.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable {

	private CarteVue terrainVue;
	
	private Carte carte;
	
	private Ennemi ennemi;
	
	private Tour tour;
	   
	@FXML
    private TilePane tilePane;

	@FXML
	private Pane pane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
				
		carte= new Carte();
		//stackPane.getChildren().addAll(pane);
		//stackPane.getChildren().add(tilePane);
		terrainVue = new CarteVue(carte, tilePane, pane);
		terrainVue.afficherCarte();
		ennemi = new Pigman(300,40,0,5,5);
		creerSpriteEnnemi(ennemi);
	
	//tour = new Chevalier("Chevalier", 500, 60, 5, 6);
	//creerSpriteTour(tour);
	
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
		
	//	groupes.get(e.getX()).getChildren().add(e.getSprite());
				
	}

	private void creerSpriteEnnemi(Ennemi e) {
		pane.getChildren().add(e.getSprite());
	}
	
	private void creerSpriteTour(Tour t) {
		//pane.getChildren().add(t.getSprite());
	}
	
}
