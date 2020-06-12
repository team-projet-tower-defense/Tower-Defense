package app.controleur;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import app.modele.*;
import app.vue.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {

	private CarteVue terrainVue;
	
	private Carte carte;
	
	private Jeu partie;
	
	private JeuVue partieVue;
	
	//private Environnement environnement;
   
	@FXML
    private TilePane decor;
	
	@FXML
	private Pane pane;
	
	private Timeline gameLoop;
	
	@FXML
    private Button bouton;
	
	@FXML
    public ImageView defenseArcher;
	
	@FXML
	private Label message;
	
	@FXML
    private TextField compteurVie;
	
	private int numVague=2;

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		partie = new Jeu(/*environnement*/);
		partieVue = new JeuVue(partie, pane);
		
		carte = partie.getCarte();
		terrainVue= new CarteVue(carte, decor);
		//environnement = partie.getEnvironnement();
		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		partie.initialiserVagues(numVague);
		clicTourelle();
		initialiserGameLoop();
		gameLoop.play();
		
	}
	
	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.016),
		(ev -> {

				partie.vague(numVague);
				partieVue.setup(numVague);
				//System.out.println(partie.getEnnemisEnJeu());
				//System.out.println(partieVue.sprites());	
				//System.out.println(partie.getPvButin());
				for(Ennemi e: partie.getEnnemisEnJeu()) {
					e.seDeplace();
					partieVue.getEnnemiVue(e).deplacementSprite();
					if(e.butAtteint()) {
						e.meurt();
						//System.out.println(e +" dead");
						
						partie.getASupprimer().add(e);	
						partie.decrementerPvButin(e.getAttaqueSurButin());
						
					}
				}
				
				for(Ennemi e : partie.getASupprimer()) {
					partieVue.sprites().remove(partieVue.getEnnemiVue(e));
					partie.getEnnemisEnJeu().remove(e);
					//System.out.println(e +"dead");
				}
		}));
		gameLoop.getKeyFrames().add(frame);
	}
	
	public void clicTourelle() {
		defenseArcher.setOnMouseClicked(e ->{clicSurMap(e);});		
	}
	
	public void clicSurMap(MouseEvent ev) {		
		System.out.println("hahah");
		for (int i = 0; i < decor.getChildren().size(); i++) {
			
			if(decor.getChildren().get(i).getId() == "stone" /*&& verifiePlaceLibre(decor.getChildren().get(i).getLayoutX(), decor.getChildren().get(i).getLayoutY())*/){
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();
					//System.out.println(jeu.getDefense());
					ImageView tourelle = new ImageView("file:src/app/ressources/archer.png");
					partie.getDefenses().add(new Archer(ev.getX(),ev.getY()));
					System.out.println(partie.getDefenses());
					tourelle.setLayoutX(tuile.getLayoutX());
					tourelle.setLayoutY(tuile.getLayoutY());					
		            pane.getChildren().add(tourelle);
				});	
			}
		}
	}

    	
}
