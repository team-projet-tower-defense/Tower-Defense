package app.controleur;


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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Controleur implements Initializable {
	
	private boolean clicSurArcher, clicSurCatapulte, clicSurMage, clicSurChevalier = false;
	private CarteVue terrainVue;
	private Timeline gameLoop;
	private JeuVue partieVue;
	private int numVague=4;
	private Carte carte;
	private Jeu partie;

    @FXML
    private ProgressBar barreDeDiamants;
    @FXML
    private ProgressBar compteDiamant;
	@FXML
    private TextField compteurVie;
	@FXML
    private ImageView quitterJeu;
    @FXML
    private TextField round;
	@FXML
    private TilePane decor;
	@FXML
    private Button bouton;
	@FXML
	private Label message;
    @FXML
    private Label pvButin;
	@FXML
	private Pane pane;
	
	@FXML
    private ImageView defenseCatapulte;
    @FXML
    private ImageView defenseChevalier;
    @FXML
    private ImageView defenseArcher;
    @FXML
    private ImageView defenseMage;
    @FXML
    private ImageView jouerSon;

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		partie = new Jeu();
		partieVue = new JeuVue(partie, pane);
		carte = partie.getCarte();
		terrainVue = new CarteVue(carte, decor);		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		partie.initialiserVagues(numVague);
		compteDiamant = new ProgressBar(30);
		
		clicTourelle();
		initialiserGameLoop();
		gameLoop.play();
	}
	
	private void initialiserGameLoop() {
		
		this.gameLoop = new Timeline();
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		KeyFrame frame = new KeyFrame(Duration.seconds(0.016),
		(ev -> {
			if(partie.getPvButin() > 0) {
				compteDiamant.setProgress(partie.getNbDiamant());
				partie.vague(numVague);
				partieVue.setup(numVague);
				for(Ennemi e: partie.getEnnemisEnJeu()) {
					
					e.seDeplace();
					partieVue.getEnnemiVue(e).deplacementSprite();
					
					for(Tour t : partie.getDefenses()) {
						t.attaque(e);
					}
					
					if(!e.estVivant()) {
						partie.getASupprimer().add(e);	
					}
					
					if(e.butAtteint()) {
						e.meurt();
						partie.decrementerPvButin(e.getAttaqueSurButin());
					}
				}
				
				for(Ennemi e : partie.getASupprimer()) {
					pane.getChildren().remove(partieVue.getEnnemiVue(e).getSprite());
					partieVue.spritesEnnemis().remove(partieVue.getEnnemiVue(e));
					partie.getEnnemisEnJeu().remove(e);
					partie.incrementerDiamant(e.butin());
				}
				
				partie.getASupprimer().clear();
				partie.incrementerDiamant(0.1);
				pvButin.setText("" +partie.getPvButin());
			}
			
			else {
				round.setText("Game Over");
			}
			barreDeDiamants.setProgress(partie.getNbDiamant() / 30);
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
		
		quitterJeu.setOnMouseClicked( e -> System.exit(0));
		
//		jouerSon.setOnMouseClicked(e ->{ 
//			AudioClip note = new AudioClip(this.getClass().getResource("file:/Tower Defense/Tower-Defense/src/app/ressources/sonAmbiance.mp3").toString());
//			note.play();
//		});
	}
	
	public void clicSurMap(MouseEvent ev) {		
		for (int i = 0; i < decor.getChildren().size(); i++) {
			
			if(decor.getChildren().get(i).getId() == "stone"  && partie.getNbDiamant()>=5  ){
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();
					if(clicSurArcher == true) {
                        Archer archer = new Archer(tuile.getLayoutX(),tuile.getLayoutY());
                        if( partie.getNbDiamant()>=archer.ressourcesDiamant()) {
                        	partie.getDefenses().add(archer);
                        	TourVue tourelle = new TourVue(archer, pane);
                        	partie.decrementerDiamant(archer.ressourcesDiamant());
                        	clicSurArcher = false;
                        }
                    }

                    else if(clicSurCatapulte == true) {
                        Catapulte catapulte = new Catapulte(tuile.getLayoutX(),tuile.getLayoutY());
                        if( partie.getNbDiamant()>=catapulte.ressourcesDiamant()) {
                        	partie.getDefenses().add(catapulte);
                        	TourVue tourelle = new TourVue(catapulte, pane);
                        	partie.decrementerDiamant(catapulte.ressourcesDiamant());
                        	clicSurCatapulte= false;
                        }
                    }

                    else if(clicSurMage == true) {
                        Mage mage = new Mage(tuile.getLayoutX(),tuile.getLayoutY());
                        if( partie.getNbDiamant()>=mage.ressourcesDiamant()) {
                        	partie.getDefenses().add(mage);
                        	TourVue tourelle=new TourVue(mage, pane);
                        	partie.decrementerDiamant(mage.ressourcesDiamant());
                        	clicSurMage= false;
                        }
                    }
					
                    else if(clicSurChevalier == true) {
                        Chevalier chevalier = new Chevalier(tuile.getLayoutX(),tuile.getLayoutY());
                        if( partie.getNbDiamant()>=chevalier.ressourcesDiamant()) {
                        	partie.getDefenses().add(chevalier);
                        	TourVue tourelle=new TourVue(chevalier, pane);
                        	partie.decrementerDiamant(chevalier.ressourcesDiamant());
                        	clicSurChevalier= false;
                        }
                    }
				});	
			}
		}
	}  	
}
