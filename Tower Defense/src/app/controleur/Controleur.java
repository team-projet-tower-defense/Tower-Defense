package app.controleur;


import app.modele.Carte;
import app.modele.Defense;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controleur {
	
	@FXML
    private Button ajtTour;
	
	private Carte carte;

    @FXML
    void ajtTour(ActionEvent event) {
    	carte.placerDefense(10,10);
    }

}
