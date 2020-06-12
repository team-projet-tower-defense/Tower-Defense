package app.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EnnemiTest {	
	private double x;
	private double y;
	private int pv;
	private int attaque;
	private double vitesse;
	private int attaqueSurButin;


	@Test
	public void butinTest() {
		Ennemi e = new Ennemi(0, 0, 0, 0);
		if (e instanceof Zombie) { 
			assertEquals(1,e.butin());
		}
		
		else if (e instanceof Sorciere) { 
			assertEquals(4,e.butin());
		}
		
		else if (e instanceof Wither) { 	
			assertEquals(10,e.butin());
		}
		
		else if (e instanceof Pigman) { 	
			assertEquals(3,e.butin());
		}
		
		else/* if (this instanceof Squelette)*/ { 
			assertEquals(2,e.butin());
		}
	}

}
