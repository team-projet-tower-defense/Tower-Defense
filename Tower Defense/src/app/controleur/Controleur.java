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
	
	private static final int Environnement = 0;
	private Jeu jeu;
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
	
	public TourVue tourvue;
	private TourVue tourvue1;
	private TourVue tourvue2;
	private TourVue tourvue3;
	private TourVue tourvue4;
	
	private Environnement environnement;
	
    @FXML
    private Button testClick;
	@FXML
	private Label message;
	@FXML
   private TextField compteurVie;
	@FXML
    private TilePane decor;
	@FXML
	private Pane pane;
	private Timeline gameLoop;
	private int time;
	private Tour tour;
	private CarteVue carte2;
	//private int codeCase;
	
	public String nompor = "non";
	
    @FXML
    public ImageView defenseArcher;
//    @FXML
//    public ImageView Catapulte;
//    @FXML
//    public ImageView Chevalier;
//    @FXML
//    public ImageView Mage;
  
//    @FXML
//    public ImageView nomTour = Archer;
   // public int idTour = 0;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		carte = new Carte();
		environnement = new Environnement(carte);
		
		terrainVue = new CarteVue(carte, decor);
		terrainVue.afficherCarte();
		
		ennemi = new Sorciere(environnement);	
		ennemivue = new EnnemiVue(ennemi, pane);
		ennemivue.creerSpriteEnnemi();
		
		zombie = new Zombie(environnement);	
		zombievue = new EnnemiVue(zombie, pane);
		zombievue.creerSpriteEnnemi();

		clicTourelle();
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
	
	public void clicTourelle() {
		defenseArcher.setOnMouseClicked(e ->{clicSurMap(e);});		
	}
	
	public void clicSurMap(MouseEvent ev) {		
		for (int i = 0; i < decor.getChildren().size(); i++) {
			if(decor.getChildren().get(i).getId() == "stone" /*&& verifiePlaceLibre(decor.getChildren().get(i).getLayoutX(), decor.getChildren().get(i).getLayoutY())*/){
				decor.getChildren().get(i).setOnMouseClicked(e ->{
					Node tuile = (Node) e.getSource();
					//System.out.println(jeu.getDefense());
					ImageView tourelle = new ImageView("file:Tower Defense/src/app/ressources/archer.png");
			//		jeu.getDefense().add(new Archer(environnement));
					tourelle.setLayoutX(tuile.getLayoutX());
					tourelle.setLayoutY(tuile.getLayoutY());					
		            pane.getChildren().add(tourelle);
				});	
			}
		}
	}


	
/*	public boolean verifiePlaceLibre(double x, double y) {
        for (int i = 0; i < decor.getChildren().size(); i++) {
            if (this.e1.getTourelles().get(i).getX() == x && this.e1.getTourelles().get(i).getY() == y) {
                return false;
            }
        }
        return true;
    }*/

}
