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
	//private Tour tour;
	//private boolean running;
   
	@FXML
    private TilePane decor;
	@FXML
	private Pane pane;
	private Timeline gameLoop;
	private int time;
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//running=true;
		
		carte = new Carte();
		environnement = new Environnement(carte);
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		ennemi = new Sorciere(120,120, environnement);
		ennemivue = new EnnemiVue(ennemi, pane);
		ennemivue.creerSpriteEnnemi();
		initialiserGameLoop();
		gameLoop.play();
		
		// Mouvement ennemi
		
//		for(int i =0; i <10; i++) {
//			System.out.println("x: " + ennemi.getX() + " y: " + ennemi.getY());
//		}
		
	//tour = new Chevalier("Chevalier", 500, 60, 5, 6);
	//creerSpriteTour(tour);
	
	//sssmouvement(ennemi);
	
	}
	
	/*public Ennemi ajouterEnnemi() {
		Ennemi e= new Ennemi(100,5,2,25,10);
		return e;
	}
	*/
	
	// private void mouvement(EnnemiVue e) {
		
	//Random random = new Random(); 
		
	//int nbRandom = random.nextInt(100);
			
	//	e.setX(e.getX()+1);
	//	e.getSprite().setTranslateX(e.getX());
		//
		
		//e	
//	}
	
	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.time = 0;
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.1),
		(ev -> {
				ennemi.seDeplace();
				ennemivue.deplacementSprite();
					
		}));
		gameLoop.getKeyFrames().add(frame);
	}
    	
	private void creerSpriteTour(Tour t) {
		//pane.getChildren().add(t.getSprite());
	}
}
