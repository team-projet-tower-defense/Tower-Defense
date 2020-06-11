package app.modele;

import java.util.ArrayList;

public class Jeu {

	private Manche[] manches= {};
	
	private ArrayList<Tour> defenses;
	
	private Carte carte; 
	
	private Environnement env;
	
	private ArrayList<Ennemi> vague1 ;
	
	private ArrayList<Ennemi>  vague2;
	
	private ArrayList<Ennemi> vague3;
	
	private ArrayList<Ennemi> vague4 ;
	
	private ArrayList<Ennemi> vague5;
	
	private ArrayList<ArrayList<Ennemi>> vagues = new ArrayList<ArrayList<Ennemi>>(); //{/*vague1,vague2,vague3,vague4,vague5*/} */ 
	
	private ArrayList<Ennemi> ennemisEnJeu;
	
	public Jeu(Environnement e) {
		
		carte= new Carte();
		
		env=new Environnement(carte);
		
		ennemisEnJeu=new ArrayList();
		
		
		

	}
	
	public void initialiserVagues(int choix) {
		
		switch(choix) {
		
		 case 0:
			 for(int i = 0; i<3 ;i++) 
				 vague1.add(new Zombie(env));
			 vagues.add(vague1);
		 case 1:
			 for(int i = 0; i<5; i++)
				 vague2.add(new Zombie(env));
				 vague2.add(new Squelette(env));
			vagues.add(vague2);
		 case 2:
			 for(int i = 0; i<8; i++){
				 vague3.add(new Zombie(env));
				 vague3.add(new Squelette(env));
				 if(i<3) 
					 vague3.add(new Pigman(env));
			 }
			 vagues.add(vague3);
		 case 3:
			 for(int i = 0; i<12; i++) {
				 vague4.add(new Zombie(env));
				 vague4.add(new Squelette(env));
				 if(i<5)
					 vague4.add(new Pigman(env));
			  }
			 vagues.add(vague4);
		 case 4:
			 for(int i = 0; i<15; i++) {
				 vague5.add(new Zombie(env));
				 vague5.add(new Squelette(env));
				 if(i<8) {
					 vague5.add(new Pigman(env));
				 }
				 if(i<3) 
					 vague5.add(new Sorciere(env));
			 }
			 vague5.add(new Wither(env));
			 vagues.add(vague5);
		}	
		
		
	}
	
	public void vague(int choix) {
		ennemisEnJeu.add(vagues.get(choix).get(0));
		vagues.get(choix).remove(vagues.get(choix).get(0));
		
		
	}
	
	public ArrayList<Ennemi> getEnnemisEnJeu(){
		return ennemisEnJeu;
	}
	
	public Carte getCarte() {
		return carte;
	}
	
	public Environnement getEnvironnement() {
		return env;
	}
	
	public ArrayList<Ennemi> getVague(int choix) {
		
		return vagues.get(choix);
		
	}
	
	

}
