import java.util.Arrays;
import java.util.List;

public class Battle {
	
<<<<<<< HEAD
	Enemy enemy;
<<<<<<< HEAD
	User.Player TITLE = User.Player.TITLE;
=======
	User.Player title = User.Player.TITLE;
>>>>>>> 67f13360f90d24566fd12bcf70580d1c6a24175a
=======
	static Enemy enemy;
	static String TITLE = User.Player.TITLE.desc;
	static String CLASS = User.Player.CLASS.desc;
	static int LEVEL = User.LEVEL;
	static int HEALTH = User.HEALTH;
	static int attack;
	static int defence;
>>>>>>> fc451edfaaf0ace92c229745343a9cc62173f599
	
	static void pickEnemy() {
		int x = (int)(Math.random() * 7);
		enemy = Enemy.values()[x];
	} // end pickEnemy() //

	static void battle() {
		pickEnemy();
<<<<<<< HEAD
		sect("You are under attack, " + TITLE);
		enemy.putStats();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		putOptions();
		
	} // end battle(); //
	
	public static List<String> options = Arrays.asList("ATTACK", "DEFEND", "ITEMS", "FLEE");
	
	public static void putOptions() {
		String input;
		boolean alive = (HEALTH > 0);
		BATTLE: while(enemy.health >= 1){
			do {
				sub("ATTACK \t DEFEND", "ITEMS \t FLEE"); 
				pl("\t What shall you do?! \n");
				input = TextIO.getlnWord().toUpperCase();
				if(options.contains((input))){
					switch(input){
					case "ATTACK":
						if(CLASS.equals("SCORCHER") || CLASS.equals("VOIDED")){
							pl("\t ATTACK \n \t MAGIC");
							input = TextIO.getlnWord().toUpperCase();
							if(input.equals("ATTACK")){
								attack();
							} else {
								// magicOptions();
							}
						} else {
							attack();
						}
						if(enemy.health <= 0){
							pl("\t You have defeated the " + enemy + ", " + TITLE + "!");
							break BATTLE;
						}
						break;
					case "DEFEND":
						pl("\t You ready your guard! \n");
						defence = getDefence();
						break;
					case "ITEMS":
						
						break;
					case "FLEE":
						int esc = (int)(Math.random() * 5);
						if(esc < 1){
							sub("There is no escape this round...");
						} else {
							sub("You have successfully escaped from the " + enemy + ", " + TITLE);
							break BATTLE;
						}
					} // end switch(input) //	
					} else if(!(options.contains(input))) {
						pl("\t Please choose a valid option!");
						input = TextIO.getlnWord().toUpperCase();
					}
				} while(alive); // !alive //
				sub("You have no HEALTH left...", "The will to fight has left you...","");
				try {
					Thread.sleep(2500);
				} catch(InterruptedException e){
					Thread.currentThread().interrupt();
				JGame.lost();
				break BATTLE;
			} // do while(alive) //
		} // end while(enemy.health > 0); enemy has been defeated at this point //
	} // end putOptions() //
	
	
<<<<<<< HEAD
=======
		sect("You are under attack, " + title);
		enemy.putStats();
	} // end battle(); //
	
>>>>>>> 67f13360f90d24566fd12bcf70580d1c6a24175a
=======
	public static void attack() {
		int ATTACK = 0;		
		switch(CLASS){
		case "BASTION":
			ATTACK = (int)((Math.random() * LEVEL + 1) + (Math.random() * enemy.level +8));
		case "TITAN":
			ATTACK = (int)((Math.random() * LEVEL + 2) + (Math.random() * enemy.level + 14));
		case "SCORCHER":
			ATTACK = (int)((Math.random() * LEVEL + 1) +  (Math.random() * enemy.level + 5));
		case "PANZER":
			ATTACK = (int)((Math.random() * LEVEL + 2) + (Math.random() * enemy.level + 10));
		case "VOIDED":
			ATTACK = (int)((Math.random() * LEVEL + 1) + (Math.random() * enemy.level + 5));
			}
		ATTACK -= ((enemy.level * Math.random()) + (Math.random() * 4));
		enemy.health -= ATTACK;
		sub("You attacked the " + enemy + " for " + ATTACK + " damage!",
				"The" + enemy + " has " + enemy.health + " left.");
		// enemyAttack();
		}	

	public static int getDefence() {
		int DEFENCE = 0;
		switch(CLASS){
		case "BASTION":
			DEFENCE = (int)((Math.random() * LEVEL + 3) + (Math.random() * enemy.level +11));
		case "TITAN":
			DEFENCE = (int)((Math.random() * LEVEL + 2) + (Math.random() * enemy.level + 8));
		case "SCORCHER":
			DEFENCE = (int)((Math.random() * LEVEL + 1) +  (Math.random() * enemy.level + 4));
		case "PANZER":
			DEFENCE = (int)((Math.random() * LEVEL + 3) + (Math.random() * enemy.level + 13));
		case "VOIDED":
			DEFENCE = (int)((Math.random() * LEVEL + 1) + (Math.random() * enemy.level + 4));
			}
		return DEFENCE;
	}
>>>>>>> fc451edfaaf0ace92c229745343a9cc62173f599
		
	
	public static void pl(String x) {
		TextIO.putln(x);
	} // end pl() //
	
	public static void p(String y) {
		TextIO.put(y);
	} // end p() //
	
	public static void sect(String...str) {
		pl(" > > ********************************************************************** < < \n");
		for(String x : str) {
			pl("\t" + x + "\n");
		}
	}
	
	public static void sub(String...str) {
		pl("\t\t**********************************\n");
		for(String x : str) {
			pl("\t" + x + "\n");
		}
	}
	
	// thread sleep //
	
	public static void sleep(int x){
		try{
			Thread.sleep(x);
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
	} // end sleep() //
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> 67f13360f90d24566fd12bcf70580d1c6a24175a
=======
	
	static boolean contains(String x) {
		for(Class c : Class.values()) {
			if(x.equals(c.toString()))
				return true;
		}
		return false;
	} // end contains() //
	
}
>>>>>>> fc451edfaaf0ace92c229745343a9cc62173f599
