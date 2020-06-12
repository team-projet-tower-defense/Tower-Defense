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

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

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
	private Label message;
	
	@FXML
    private TextField compteurVie;
	
    @FXML
    private ImageView defenseCatapulte;
    @FXML
    private ImageView defenseChevalier;
    @FXML
    private ImageView defenseArcher;
    @FXML
    private ImageView defenseMage;
    
	private int numVague=2;
	private boolean clicSurArcher = false;
	private boolean clicSurCatapulte = false;
	private boolean clicSurMage = false;
	private boolean clicSurChevalier = false;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		partie = new Jeu();
		partieVue = new JeuVue(partie, pane);
		
		carte = partie.getCarte();
		terrainVue= new CarteVue(carte, decor);
		
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
		defenseArcher.setOnMouseClicked(e ->{clicSurMap(e);
    		this.clicSurArcher = true;
		});
		
		defenseCatapulte.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurCatapulte = true;
		});
		
		defenseMage.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurMage = true;
		});
		
		defenseChevalier.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurChevalier = true;
		});
	}
	
	public void clicSurMap(MouseEvent ev) {		
		for (int i = 0; i < decor.getChildren().size(); i++) {
			if(decor.getChildren().get(i).getId() == "stone" /*&& testPlace*/){
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();
					
					if(clicSurArcher == true) {
						ImageView tourelle = new ImageView("file:Tower Defense/src/app/ressources/archer.png");
						partie.getDefenses().add(new Archer(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());					
			            pane.getChildren().add(tourelle);
			            clicSurArcher = false; 
					}
					
					else if(clicSurCatapulte == true) {
						ImageView tourelle = new ImageView("file:Tower Defense/src/app/ressources/catapulte.png");
						partie.getDefenses().add(new Catapulte(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());
			            pane.getChildren().add(tourelle);
			            clicSurCatapulte = false; 
					}
					
					else if(clicSurMage == true) {
						ImageView tourelle = new ImageView("file:Tower Defense/src/app/ressources/mage.png");
						partie.getDefenses().add(new Mage(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());					
			            pane.getChildren().add(tourelle);
			            clicSurMage = false; 
					}
					
					else if(clicSurChevalier == true) {
						ImageView tourelle = new ImageView("file:Tower Defense/src/app/ressources/chevalier.png");
						partie.getDefenses().add(new Chevalier(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());					
			            pane.getChildren().add(tourelle);
			            clicSurChevalier = false; 
					}
//					tourelle.setLayoutX(tuile.getLayoutX());
//					tourelle.setLayoutY(tuile.getLayoutY());					
//		            pane.getChildren().add(tourelle);
					
				});	
			}
		}
	}   	
}
