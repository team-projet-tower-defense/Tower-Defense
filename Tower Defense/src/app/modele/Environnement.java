package app.modele;

import java.util.ArrayList;
import app.vue.EnnemiVue;
import javafx.scene.layout.Pane;

public class Environnement {
	
	private Carte carte;
	private Pane pane;
    private ArrayList<EnnemiVue> ennemiVueListe;

    public Environnement(Carte c, Pane p) {
        this.carte = c;
        this.pane = p;
        this.ennemiVueListe = new ArrayList<>();
    }

	public ArrayList<EnnemiVue> getEnnemiVueListe() {
		return ennemiVueListe;
	}

	public void setEnnemiVueListe(ArrayList<EnnemiVue> ennemiVueListe) {
		this.ennemiVueListe = ennemiVueListe;
	}       
}
