package app.modele;

import java.util.ArrayList;

public class Jeu {
	
	private Carte carte; 
	private int pvButin = 8000;
	private double nbDiamants = 0;
	private ArrayList<Tour> defenses = new ArrayList() ;
	private ArrayList<Ennemi> aSupprimer = new ArrayList();
	private ArrayList<Ennemi> ennemisEnJeu = new ArrayList();
	private ArrayList<Ennemi> vague0,vague1,vague2,vague3,vague4 = new ArrayList();
	private ArrayList<ArrayList<Ennemi>> vagues = new ArrayList<ArrayList<Ennemi>>();

	public Jeu() {	
		carte= new Carte();		
		ennemisEnJeu = new ArrayList();
	}
	
	public void initialiserVagues(int choix) {
		vagues.add(vague0);
		vagues.add(vague1);
		vagues.add(vague2);
		vagues.add(vague3);
		vagues.add(vague4);
		
		switch(choix) {
		
		 case 0:
			 for(int i = 0; i<3 ;i++) {
				 vague0.add(new Zombie());
			 }
			 
		 case 1:
			 for(int i = 0; i<5; i++) {
				 vague1.add(new Zombie());
				 vague1.add(new Squelette());
				 vagues.add(vague0);
			 }
		 case 2:
			 for(int i = 0; i<8; i++){
				 vague2.add(new Zombie());
				 vague2.add(new Squelette());
				 if(i<3) 
					 vague2.add(new Pigman());
			 }
			 
		 case 3:
			 for(int i = 0; i<12; i++) {
				vague3.add(new Zombie());
				 vague3.add(new Squelette());
				 if(i<5) {
					vague3.add(new Pigman());
				 }
			  }
			 
		 case 4:
			 for(int i = 0; i<15; i++) {
				 vague4.add(new Zombie(/*env*/));
				 vague4.add(new Squelette(/*env*/));
				 if(i<8) {
					 vague4.add(new Pigman(/*env*/));
				 }
				 if(i<3) 
					 vague4.add(new Sorciere(/*env*/));
			 }
			 vague4.add(new Wither(/*env*/));
			
		}		
	}
	
	public void vague(int choix) {
		if(vagues.get(choix).size() !=0) {
			ennemisEnJeu.add(vagues.get(choix).get(0));
			vagues.get(choix).remove(vagues.get(choix).get(0));
		}
	}
	
	public ArrayList<Ennemi> getEnnemisEnJeu(){
		return ennemisEnJeu;
	}
	
	public ArrayList<Ennemi> getASupprimer(){
		return aSupprimer;
	}
	
	public ArrayList<Ennemi> getVague(int choix) {
		return vagues.get(choix);
	}
	
	public int getPvButin() {
		return pvButin;
	}
	
	public void decrementerPvButin(int d) {
		if(pvButin - d >0) {
			pvButin-=d;
		}
		
		else {
			pvButin=0;
		}	
	}

	public Carte getCarte() {
		return carte;
	}
	
	public ArrayList<Tour> getDefenses(){
		return defenses;
	}

	public double getNbDiamant() {
		return nbDiamants;
	}

	public void incrementerDiamant(double d) {
		if(nbDiamants<30)
		nbDiamants +=d;
		
	}

	public void decrementerDiamant(int v) {
		if(nbDiamants>=v) {
			nbDiamants-=v;
		}	
	}
}

