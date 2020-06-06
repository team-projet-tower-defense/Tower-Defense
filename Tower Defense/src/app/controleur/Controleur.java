package app.controleur;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import app.modele.*;
import app.vue.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {

	private CarteVue terrainVue;
	private Carte carte;
	private Sorciere ennemi;
	private EnnemiVue ennemivue;
	private Zombie zombie;
	private EnnemiVue zombievue;
	
	private Chevalier tour1;
	private Archer tour2;
	private Catapulte tour3;
	private Mage tour4;
	
	private TourVue tourvue1;
	private TourVue tourvue2;
	private TourVue tourvue3;
	private TourVue tourvue4;
	
	private Environnement environnement;
   
	@FXML
    private TilePane decor;
	@FXML
	private Pane pane;
	private Timeline gameLoop;
	private int time;
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		carte = new Carte();
		environnement = new Environnement(carte);
		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		
		ennemi = new Sorciere(5, 448, environnement);	
		ennemivue = new EnnemiVue(ennemi, pane);
		ennemivue.creerSpriteEnnemi();
		
		zombie = new Zombie(5, 416, environnement);	
		zombievue = new EnnemiVue(zombie, pane);
		zombievue.creerSpriteEnnemi();
		
		tour1 = new Chevalier(50, 380, environnement);
		tour2 = new Archer(18, 380, environnement);
		tour3 = new Catapulte(89, 380, environnement);
		tour4 = new Mage(150, 380, environnement);
		
		tourvue1 = new TourVue(tour1, pane);
		tourvue2 = new TourVue(tour2, pane);
		tourvue3 = new TourVue(tour3, pane);
		tourvue4 = new TourVue(tour4, pane);
		
		tourvue1.creerSpriteTour();
		tourvue2.creerSpriteTour();
		tourvue3.creerSpriteTour();
		tourvue4.creerSpriteTour();
		
		initialiserGameLoop();
		gameLoop.play();
	}
	
	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.016),
		(ev -> {
				ennemi.seDeplace(1);
				zombie.seDeplace(2);
				ennemivue.deplacementSprite();	
				
				zombievue.deplacementSprite();
		}));
		gameLoop.getKeyFrames().add(frame);
	}
    	
	private void creerSpriteTour(Tour t) {
		//pane.getChildren().add(t.getSprite());
	}
}
