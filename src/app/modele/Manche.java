package app.modele;

import java.util.ArrayList;

public class Manche {
	
	private Environnement env;
	
	private Ennemi[] vague;
	
	private Ennemi[] vague1 = {new Squelette(env),new Squelette(env),new Squelette(env),new Zombie(env),new Zombie(env),new Zombie(env)};
	
	private Ennemi[] vague2 = {new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env)};
	
	private Ennemi[] vague3 = {new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Pigman(env), new Pigman(env), new Pigman(env)} ;
	
	private Ennemi[] vague4 = {new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env)};

	private Ennemi[] vague5 = {new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Squelette(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env),new Zombie(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Pigman(env), new Sorciere(env), new Sorciere(env), new Sorciere(env), new Wither(env)};
	
	public Manche(Ennemi[] v) {	
		
		vague=v;
		
	}

	public Ennemi[] getVague1() {
		return vague1;
	}

	public Ennemi[] getVague2() {
		return vague2;
	}

	public Ennemi[] getVague3() {
		return vague3;
	}

	public Ennemi[] getVague4() {
		return vague4;
	}

	public Ennemi[] getVague5() {
		return vague5;
	}
	
	

}
