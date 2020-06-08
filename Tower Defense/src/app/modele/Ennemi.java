package app.modele;

import java.util.Random;

import app.vue.CarteVue;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Ennemi {
	
	private int x,y;
	private int dx,dy ;
	private int pv;
	private int attaque;
	private int vitesse;
	private ImageView sprite;
	
	protected Environnement environnement;
	
	public Ennemi(int p, int a, int v, int x, int y, Environnement env) {
		this.pv = p;
		this.attaque = a;
		this.vitesse = v;
		this.x = x;
		this.y = y;
		this.environnement = env;
	}
	
	@Override
	public String toString() {
		return "Ennemi [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy
				+ ", pv=" + pv + ", attaque=" + attaque + ", vitesse=" + vitesse + "]";
	}

	public void butin() {
		//faire tomber butin 
	}
	
	public abstract void agit();
	
	public int getX() {
		return x;
	}

	public  void setX(int n){
		x = n;
	}

	public  int getY() {
		return y;
	}
	
	public  void setY(int n){
		y = n;
	}
	
	public void decrementerPv(int n) {
		this.pv -= n;	
	}

	public void incrementerPv(int n) {
		this.pv += n;	
	}

	public boolean estVivant() {
		return this.pv > 0;
	}

	public void meurt(){
		this.pv = 0;
	}
	
	public void attaqueTour(Tour d) {
		d.recevoirDegats(attaque);
	}
	
	public boolean estEnVie() {
		if(pv != 0) {
			return true;
		}
		return false;
	}

	// 
	public void seDeplace(int choixChemin) {

        if(choixChemin == 1) {
        	
            if(this.x<224 && this.y==448) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==225 && this.y > 160) {
                this.setY(y - this.vitesse);
            }
            else if(this.x < 480 && this.y==160) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==481 && this.y < 448) {
                this.setY(y + this.vitesse);
            }
            else if(this.x<736 && this.y==448) {
                this.setX(x + this.vitesse);
            }
            else if(this.x==737 && this.y > 160) {
                this.setY(y - this.vitesse);
            }
            else if(this.x<928 && this.y==160) {
                this.setX(x + this.vitesse);
            }
        }
        
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
        }
	}
}
