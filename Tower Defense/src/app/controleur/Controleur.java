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
import javafx.scene.media.AudioClip;
import javafx.util.Duration;


public class Controleur implements Initializable {

	public TourVue tourvue;
	public int idTour;
	
	private boolean clicSurArcher, clicSurCatapulte, clicSurMage, clicSurChevalier = false;
	private CarteVue terrainVue;
	private ImageView tourelle;
	private Timeline gameLoop;
	private JeuVue partieVue;
	private int numVague = 2;
	private Carte carte;
	private Jeu partie;

    @FXML
    private ImageView defenseArcher, defenseCatapulte, defenseMage, defenseChevalier;
    @FXML
    private TextField compteurVie;
    @FXML
    private ImageView quitterJeu;
	@FXML
    private TilePane decor;
	@FXML
	private Label message;
	@FXML
    private Button bouton;
    @FXML
    private ImageView jouerSon;
	@FXML
	private Pane pane;
    @FXML
    private Label pvButin;
    
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
			for(Ennemi e: partie.getEnnemisEnJeu()) {
				e.seDeplace();
				partieVue.getEnnemiVue(e).deplacementSprite();
				
				if(e.butAtteint()) {
					e.meurt();
					partie.getASupprimer().add(e);	
					partie.decrementerPvButin(e.getAttaqueSurButin());
				}
				
				if(!e.estVivant()) {
                    partie.getASupprimer().add(e);
                }
				
                if(e.butAtteint()) {
                    e.meurt();
                    partie.decrementerPvButin(e.getAttaqueSurButin());
                    pvButin.setText(""+partie.getPvButin());
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
    		this.idTour = 1;
		});
		
		defenseCatapulte.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurCatapulte = true;
			this.idTour = 2;
		});
		
		defenseMage.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurMage = true;
			this.idTour = 3;
		});
		
		defenseChevalier.setOnMouseClicked(e ->{clicSurMap(e);
			this.clicSurChevalier = true;
			this.idTour = 4;
		});
		
		quitterJeu.setOnMouseClicked( e -> System.exit(0));
		
		jouerSon.setOnMouseClicked(e ->{ 
			AudioClip note = new AudioClip(this.getClass().getResource("file:/Tower Defense/Tower-Defense/src/app/ressources/sonAmbiance.mp3").toString());
		note.play();
		});	
	}
	
	
	public void clicSurMap(MouseEvent ev) {		
		for (int i = 0; i < decor.getChildren().size(); i++) {
			if(decor.getChildren().get(i).getId() == "stone" /*&& testPlace*/){
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();

					if(clicSurArcher == true) {
						tourelle = new ImageView("file:Tower Defense/src/app/ressources/archer.png");
						partie.getDefenses().add(new Archer(ev.getX(),ev.getY()));
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());
			            pane.getChildren().add(tourelle);
			            clicSurArcher = false; 
					}
					
					else if(clicSurCatapulte == true) {
						
						tourelle = new ImageView("file:Tower Defense/src/app/ressources/catapulte.png");
						partie.getDefenses().add(new Catapulte(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());
			            pane.getChildren().add(tourelle);
			            clicSurCatapulte = false; 
					}
					
					else if(clicSurMage == true) {
						tourelle = new ImageView("file:Tower Defense/src/app/ressources/mage.png");
						partie.getDefenses().add(new Mage(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());					
			            pane.getChildren().add(tourelle);
			            clicSurMage = false; 
					}
					
					else if(clicSurChevalier == true) {
						tourelle = new ImageView("file:Tower Defense/src/app/ressources/chevalier.png");
						partie.getDefenses().add(new Chevalier(ev.getX(),ev.getY()));
						System.out.println(partie.getDefenses());
						tourelle.setLayoutX(tuile.getLayoutX());
						tourelle.setLayoutY(tuile.getLayoutY());					
			            pane.getChildren().add(tourelle);
			            clicSurChevalier = false; 
					}
				});
			}
		}
	}
}
