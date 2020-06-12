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

	private CarteVue terrainVue;
	
	private Carte carte;
	
	private boolean clicSurArcher, clicSurCatapulte, clicSurMage, clicSurChevalier = false;
	
	private Jeu partie;
	
	private JeuVue partieVue;
   
	@FXML
    private TilePane decor;
	
	@FXML
    private ImageView quitterJeu;
	
    @FXML
    private Label pvButin;
	
    @FXML
    private ProgressBar compteDiamant;
	
	@FXML
	private Pane pane;
	
	private Timeline gameLoop;
	
	@FXML
    private Button bouton;
	
    @FXML
    private TextField round;
    
    @FXML
    private ImageView jouerSon;
	
	@FXML
    private ImageView defenseCatapulte;
    @FXML
    private ImageView defenseChevalier;
    @FXML
    private ImageView defenseArcher;
    @FXML
    private ImageView defenseMage;
    
	@FXML
	private Label message;
	
	@FXML
    private TextField compteurVie;
	
	private int numVague=4;

	private int idTour;

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		partie = new Jeu();
		partieVue = new JeuVue(partie, pane);
		
		carte = partie.getCarte();
		terrainVue= new CarteVue(carte, decor);		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		partie.initialiserVagues(numVague);
		compteDiamant=new ProgressBar(30);
		clicTourelle();
		initialiserGameLoop();
		gameLoop.play();
		
	}
	
	private void initialiserGameLoop() {
		this.gameLoop = new Timeline();
		this.gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(0.016),
		(ev -> {
			if(partie.getPvButin()>0) {
				System.out.println(partie.getPvButin());
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
				partie.incrementerDiamant(1);
				pvButin.setText("" +partie.getPvButin());
			}
			else {
				round.setText("Game Over");
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
		
		//jouerSon.setOnMouseClicked(e ->{ 
			//AudioClip note = new AudioClip(this.getClass().getResource("file:/Tower Defense/Tower-Defense/src/app/ressources/sonAmbiance.mp3").toString());
		//note.play();
		//});	
	}
	
	public void clicSurMap(MouseEvent ev) {		
		for (int i = 0; i < decor.getChildren().size(); i++) {
			
			if(decor.getChildren().get(i).getId() == "stone"  && partie.getNbDiamant()>=5  )/*&& verifiePlaceLibre(decor.getChildren().get(i).getLayoutX(), decor.getChildren().get(i).getLayoutY())*/{
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();
					if(clicSurArcher == true) {
						Archer archer = new Archer(tuile.getLayoutX(),tuile.getLayoutY());
						partie.getDefenses().add(archer);
						TourVue tourelle=new TourVue(archer, pane);
						partie.decrementerDiamant(5);
						//tourelle.creerSpriteTour();
						clicSurArcher = false;
					}
					
					else if(clicSurCatapulte == true) {
						Catapulte catapulte = new Catapulte(tuile.getLayoutX(),tuile.getLayoutY());
						partie.getDefenses().add(catapulte);
						TourVue tourelle=new TourVue(catapulte, pane);
						partie.decrementerDiamant(5);
						clicSurCatapulte= false;
					}
					
					else if(clicSurMage == true) {
						Mage mage = new Mage(tuile.getLayoutX(),tuile.getLayoutY());
						partie.getDefenses().add(mage);
						TourVue tourelle=new TourVue(mage, pane);
						partie.decrementerDiamant(5);
						clicSurMage= false;
					}
					else if(clicSurChevalier == true) {
						Chevalier chevalier = new Chevalier(tuile.getLayoutX(),tuile.getLayoutY());
						partie.getDefenses().add(chevalier);
						TourVue tourelle=new TourVue(chevalier, pane);
						partie.decrementerDiamant(5);
						clicSurChevalier= false;
					}
				});	
			}
		}
	}

    	
}
