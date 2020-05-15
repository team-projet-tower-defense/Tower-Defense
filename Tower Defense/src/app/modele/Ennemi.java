package app.modele;

import java.util.Random;

public class Ennemi {
	
	private int x,y;
	
	private int dx,dy ;// direction 
	
	private int pv;
	
	private int attaque;
	
	private int vitesse;
	
	public Ennemi(int p, int a, int v, int x, int y) {
		pv=p;
		attaque=a;
		vitesse=v;
		this.x=x;
		this.y=y;
		
	}
	
	public  int getX() {
		return x;
	}

	public  void setX(int n){
		x=n;
	}

	public  int getY() {
		return y;
	}
	public  void setY(int n){
		y=n;
	}
	
	public void seDeplace(){
		// 20% de chance de changer de direction
		// if(Math.random()*100< pourentageRepro )
		//if(reussitProba(20)) {
			//tirerDirection();
		//}
		int nposX=this.getX()+(this.vitesse*dx);
		int nposY=this.getY()+(this.vitesse*dy);
		//while(!env.dansTerrain(nposX, nposY)){
			tirerDirection();
			nposX=this.getX()+(this.vitesse*dx);
			nposY=this.getY()+(this.vitesse*dy);
		//}
		this.x=nposX;
		this.y=nposY;		
	}
	
	private void tirerDirection(){
		Random random=new Random();
		int randomInt = random.nextInt(3);
		dx=randomInt-1;
		if(dx==0){
			randomInt=random.nextInt(2)-1;
			if(randomInt==0){
				dy=-1;
			}
			else{
				dy=1;
			}
		}
		else{
			dy=random.nextInt(3)-1;
		}
	}
	
	public void decrementerPv(int n) {
		this.pv-=n;	
	}

	public void incrementerPv(int n) {
		this.pv+=n;	
	}

	public boolean estVivant() {
		return this.pv>0;
	}

	public void meurt(){
		this.pv=0;
	}
	
	public void attaqueTour(Tour d) {
		d.recevoirDegats(attaque);
	}
	
	public boolean estEnVie() {
		if(pv!=0) {
			return true;
		}
		return false;
	}

}
