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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {

	private CarteVue terrainVue;
	
	private Carte carte;
	
	private Jeu partie;
	
	private JeuVue partieVue;
	
	private Environnement environnement;
   
	@FXML
    private TilePane decor;
	
	@FXML
	private Pane pane;
	
	private Timeline gameLoop;
	
	@FXML
    private Button bouton;
	
	@FXML
    private TextField message;
	
	private int numVague=2;

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		partie = new Jeu(environnement);
		partieVue = new JeuVue(partie, pane);
		
		carte = partie.getCarte();
		terrainVue= new CarteVue(carte, decor);
		environnement = partie.getEnvironnement();
		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		partie.initialiserVagues(numVague);	
		initialiserGameLoop();
		gameLoop.play();
		
	}
	
	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.5),
		(ev -> {

				partie.vague(numVague);
				partieVue.setup(numVague);
				//System.out.println(partie.getEnnemisEnJeu());
				//System.out.println(partieVue.sprites());	
				System.out.println(partie.getPvButin());
				for(Ennemi e: partie.getEnnemisEnJeu()) {
					e.seDeplace();
					partieVue.getEnnemiVue(e).deplacementSprite();
					if(e.butAtteint()) {
						e.meurt();
						System.out.println(e +" dead");
						
						partie.getASupprimer().add(e);	
						partie.decrementerPvButin(e.getAttaqueSurButin());
						
					}
				}
				
				for(Ennemi e : partie.getASupprimer()) {
					partieVue.sprites().remove(partieVue.getEnnemiVue(e));
					partie.getEnnemisEnJeu().remove(e);
					System.out.println(e +"dead");
				}
		}));
		gameLoop.getKeyFrames().add(frame);
	}
    	
}
