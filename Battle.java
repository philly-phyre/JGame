import java.util.Arrays;
import java.util.List;

public class Battle {
	
	static Enemy enemy;
	static String TITLE = User.Player.TITLE.desc;
	static String CLASS = User.Player.CLASS.desc;
	static int LEVEL = User.LEVEL;
	static int HEALTH = User.HEALTH;
	static int attack;
	static int defence;
	static int dmg;
	
	static void pickEnemy() {
		int x = (int)(Math.random() * 7);
		enemy = Enemy.values()[x];
	} // end pickEnemy() //

	static void battle() {
		pickEnemy();
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
		boolean won = false;
		BATTLE:	do {
			sub(">ATTACK \t >DEFEND", ">ITEMS \t >FLEE"); 
			pl("\t What shall you do?! \n");
			input = TextIO.getlnWord().toUpperCase();
			if(options.contains((input))){
				switch(input){
				case "ATTACK":
					if(CLASS.equals("SCORCHER") || CLASS.equals("VOIDED")){
						pl("\t >ATTACK \t >\t MAGIC");
						input = TextIO.getlnWord().toUpperCase();
						if(input.equals("ATTACK")){
							attack();
							dmg = fightBack();
							HEALTH -= dmg;
							pl("\t The " + enemy + " fights back and ATTACKS you for " + dmg + " HEALTH this round.");
						} else {
							// magicOptions();
						}
					} else {
						attack();
						dmg = fightBack();
						HEALTH -= dmg;
						pl("\t The " + enemy + " fights back and ATTACKS you for " + dmg + " HEALTH this round.");
					}
					if(enemy.health <= 0){
						pl("\t You have defeated the " + enemy + ", " + TITLE + "!");
						won = true;
						break BATTLE;
					}
					break;
				case "DEFEND":
					pl("\t You ready your guard! \n");
					defence = getDefence();
					dmg = fightBack();
					defence -= dmg;
					pl("\t The " + enemy + " fights back and ATTACKS you for " + dmg + " HEALTH this round.");
					if(defence < 0){
						HEALTH += defence;
						pl("\t You've lost " + Math.abs(defence) + " HEALTH!!");
					} else {
						pl("\t You've successfully DEFENDED against the ATTACK of foe " + enemy + "!");
					}
					break;
				case "ITEMS":
					
					break;
				case "FLEE":
					int esc = (int)(Math.random() * 5);
					if(esc < 1){
						dmg = fightBack();
						HEALTH -= dmg;
						sub("There is no escape this round...", "The " + enemy + " has ATTACKED you for " + dmg + "HEALTH!");
						sleep(2900);
					} else {
						sub("You have successfully escaped from the " + enemy + ", " + TITLE);
						sleep(2900);
						won = false;
						break BATTLE;
					}
				} // end switch(input) //
				pl("\t You've " + HEALTH + " left.");
				sleep(2000);
				} else if(!(options.contains(input))) {
					pl("\t Please choose a valid option!");
					input = TextIO.getlnWord().toUpperCase();
				}
			} while(alive); // end do/while(alive) //
			sub("You have no HEALTH left...", "The will to fight has left you...","");
			sleep(2900);
			JGame.lost();
		if(won){
			User.cEXP += enemy.exp;
			User.checkEXP();
		} else {
			;
		}
		
	} // end putOptions() //
	
	
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
		if(enemy.health > 0){
		sub("You attacked the " + enemy + " for " + ATTACK + " damage!",
				"The " + enemy + " has " + enemy.health + " health left.");
		} else if(enemy.health <= 0) {
			sub("You attacked the " + enemy + " for " + ATTACK + " damage!",
					"The " + enemy + " has no health left!");
		}
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
	
	public static int fightBack() {
		return (int)((Math.random() * enemy.level) + (Math.random() * enemy.level + 1));
	}
		
	
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
	
	static boolean contains(String x) {
		for(Class c : Class.values()) {
			if(x.equals(c.toString()))
				return true;
		}
		return false;
	} // end contains() //
	
}