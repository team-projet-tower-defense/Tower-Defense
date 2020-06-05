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
		ennemi = new Sorciere(1,1, environnement);
		ennemivue = new EnnemiVue(ennemi, pane);
		ennemivue.creerSpriteEnnemi();
		initialiserGameLoop();
		gameLoop.play();
		
		
	
	}

	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.time = 0;
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.1),
		(ev -> {
				
				//ennemi.seDeplace();
				ennemivue.deplacementSprite();
					
		}));
		gameLoop.getKeyFrames().add(frame);
	}
    	
	
}