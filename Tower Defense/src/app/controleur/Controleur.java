package app.controleur;

import java.net.URL;
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
	
	//private Tour tour;
	
	//private boolean running;
	   
	@FXML
    private TilePane decor;

	@FXML
	private Pane pane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//running=true;
		carte= new Carte();
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		ennemi = new Sorciere(5,5);
		creerSpriteEnnemi(ennemi);
		for(int i =0; i <10; i++) {
			
			mouvement(ennemi);
			System.out.println("x: " + ennemi.getX() + " y: " + ennemi.getY());
		}
		
	//tour = new Chevalier("Chevalier", 500, 60, 5, 6);
	//creerSpriteTour(tour);
	
	//sssmouvement(ennemi);
	
	}
	
	
	/*public Ennemi ajouterEnnemi() {
		Ennemi e= new Ennemi(100,5,2,25,10);
		return e;
		
	}
	*/
	
	private void mouvement(Ennemi e) {
		
		Random random = new Random(); 
		
		int nbRandom = random.nextInt(100);
			
		e.setX(e.getX()+1);
		e.getSprite().setTranslateX(e.getX());
		//
		
		//e
		
		
	}
	
	/*private void gameLoop() {
		
		while(running) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			mouvement(ennemi);
			
			
		}
	}*/

	private void creerSpriteEnnemi(Ennemi e) {
		e.getSprite().setTranslateX(e.getX());
		e.getSprite().setTranslateY(e.getY());
		pane.getChildren().add(e.getSprite());
	}
	
	private void creerSpriteTour(Tour t) {
		//pane.getChildren().add(t.getSprite());
	}
	
}
