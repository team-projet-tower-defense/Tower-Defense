package app.vue;

import java.util.ArrayList;

import app.modele.Ennemi;
import app.modele.Jeu;
import javafx.scene.layout.Pane;

public class JeuVue {
	
	private Jeu partie;

	private Pane pane;
	
	private ArrayList<EnnemiVue> sprites;
	
	public JeuVue(Jeu j, Pane p) {
		pane=p;
		partie=j;
	
		sprites = new ArrayList();
	}
	
	public void setup(int choix){
		
			for(Ennemi e : partie.getEnnemisEnJeu()) {
				EnnemiVue sprite = new EnnemiVue(e,pane);
				sprite.creerSpriteEnnemi();
				sprites.add(sprite);
			}
	}
	
	public EnnemiVue getEnnemiVue(Ennemi e) {
		
		for(EnnemiVue eV : sprites) {
			if(eV.getEnnemi().equals(e)) {
				return eV;
			}
		}
		return null;
		
	}

}
