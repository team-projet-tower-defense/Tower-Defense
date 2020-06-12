package app.vue;

import java.util.ArrayList;

import app.modele.Ennemi;
import app.modele.Jeu;
import javafx.scene.layout.Pane;

public class JeuVue {
	
	private Jeu partie;

	private Pane pane;
	
	private ArrayList<EnnemiVue> spritesEnnemis;
	
	private int compteur = 0;
	
	public JeuVue(Jeu j, Pane p) {
		pane=p;
		partie=j;
	
		spritesEnnemis = new ArrayList();
	}
		
	public void setup(int choix) {
		
		if(compteur<partie.getEnnemisEnJeu().size()) {
		EnnemiVue sprite =new EnnemiVue(partie.getEnnemisEnJeu().get(partie.getEnnemisEnJeu().size()-1),pane);
		sprite.creerSpriteEnnemi();
		spritesEnnemis.add(sprite);
		compteur++;
		}
	}
	
	public ArrayList<EnnemiVue> spritesEnnemis(){
		return spritesEnnemis;
	}
	
	public EnnemiVue getEnnemiVue(Ennemi e) {
		
		for(EnnemiVue eV : spritesEnnemis) {
			if(eV.getEnnemi().equals(e)) {
				return eV;
			}
		}
		return null;
		
	}

}
