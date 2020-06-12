package app.modele;

import java.util.Random;

import app.vue.CarteVue;
import app.vue.EnnemiVue;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Ennemi {
	
	private double x;
	private double y;
	private int pv;
	private int attaque;
	private double vitesse;
	protected Environnement environnement;
	private int attaqueSurButin;
	
	public Ennemi(int p, int a, int aB ,double v,Environnement env) {
		this.pv = p;
		this.attaque = a;
		this.vitesse = v;
		this.x = 0;
		int hautOuBas = (int)(Math.random()*3);
		if(hautOuBas ==0) {
			y=416;
		}
		
		else if(hautOuBas==1) {
			y=448;
		}
		
		else {
			y=480;
		}
		
		this.environnement = env;
	}

	public int butin() {
		
		if (this instanceof Zombie) { 
			return 1;
		}
		
		else if (this instanceof Sorciere) { 
			return 4;
		}
		
		else if (this instanceof Wither) { 
			return 10;
		}
		
		else if (this instanceof Pigman) { 
			return 3;
		}
		
		else/* if (this instanceof Squelette)*/ { 
			return 2;
		}
		
	}
	
	public int getAttaqueSurButin() {
		return attaqueSurButin;
	}
	
	public abstract void agit();
	
	public double getX() {
		return x;
	}

	public  void setX(double d){
		x = d;
	}

	public  double getY() {
		return y;
	}
	
	public  void setY(double d){
		y = d;
	}
	
	public void decrementerPv(int n) {
		this.pv -= n;	
	}

	public void incrementerPv(int n) {
		this.pv += n;	
	}
	
	public boolean butAtteint() {
		return this.x == 928 ;
	}

	public boolean estVivant() {
		return this.x < 928 ;
	}

	public void meurt(){
		this.pv = 0;
	}
	
	public void attaqueTour(Tour d) {
		d.recevoirDegats(attaque);
	}
	
	
	public void seDeplace(/*int choixChemin*/) {
		

        //if(choixChemin == 1) {

            if((x<=224) && (y>=416 &&y<=512)) {
                this.setX(x + vitesse);
            }
            else if((x>=225&&x<=320) && y > 160) {
                this.setY(y - vitesse);
            }
            else if(x < 480 && y==160) {
                this.setX(x + vitesse);
            }
            else if((x>=480 && x<=576) && y < 448) {
                this.setY(y + vitesse);
            }
            else if(x<736 && y==448) {
                this.setX(x + vitesse);
            }
            else if(x<=737 && y > 160) {
                this.setY(y - vitesse);
            }
            else if(x<928 && y==160) {
                this.setX(x + vitesse);
            }
       /* }
        else if(choixChemin == 2) {

            if(this.x<256 && this.y==416) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==257 && this.y > 128) {
                this.setY(y - this.vitesse);
            }
            else if(this.x < 512 && this.y==128) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==513 && this.y < 416) {
                this.setY(y + this.vitesse);
            }
            else if(this.x<768 && this.y==416) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==769 && this.y > 128) {
                this.setY(y - this.vitesse);
            }
            else if(this.x<928 && this.y==128) {
                this.setX(x + this.vitesse);
            }
        }
        else if(choixChemin == 3) {

            if(this.x<192 && this.y==480) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==193 && this.y > 192) {
                this.setY(y - this.vitesse);
            }
            else if(this.x < 448 && this.y==192) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==449 && this.y < 480) {
                this.setY(y + this.vitesse);
            }
            else if(this.x<704 && this.y==480) {
                this.setX(x + this.vitesse);
            } 
            else if(this.x==705 && this.y > 192) {
                this.setY(y - this.vitesse);
            }
            else if(this.x<928 && this.y==192) {
                this.setX(x + this.vitesse);
            }
        }*/
    }

	
	public String toString() {
		return  "  x=" + x + " pv: " + pv;
	}
}
