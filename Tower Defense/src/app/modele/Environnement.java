package app.modele;

import java.util.ArrayList;
import app.vue.EnnemiVue;
import javafx.scene.layout.Pane;

public class Environnement {
	
    private ArrayList<EnnemiVue> ennemiVueListe;
	private Carte carte;
//	private Pane pane;

    public Environnement(Carte c) {
        this.carte = c;
 //       this.pane = p;
        this.ennemiVueListe = new ArrayList<>();
    }

	public ArrayList<EnnemiVue> getEnnemiVueListe() {
		return ennemiVueListe;
	}
	
	// Attribuer une liste à un ennemi
	public void setEnnemiVueListe(ArrayList<EnnemiVue> ennemiVueListe) {
		this.ennemiVueListe = ennemiVueListe;
	}
	
	// Vérifie si le personnage est dans le terrain ou non
	public boolean dansTerrain(int x, int y){
        return (0 <= x && x < this.carte.getLargeurEnPixels() - 64 && 0 <= y && y < this.carte.getHauteurEnPixels() - 64);
    }
}

