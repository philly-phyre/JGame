public class Battle {
	
	Enemy enemy;
	User.Player TITLE = User.Player.TITLE;
	String CLASS = User.Player.CLASS.desc;
	int LEVEL = User.LEVEL;
	int HEALTH = User.HEALTH;
	int attack;
	int defence;
	
	void pickEnemy() {
		int x = (int)(Math.random() * 7);
		enemy = Enemy.values()[x];
	} // end pickEnemy() //

	void battle() {
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
	
	
	public static String options[] = {"ATTACK", "DEFEND", "ITEMS", "FLEE"};
	
	public void putOptions() {
		String input;
		boolean alive = (HEALTH > 0);
		BATTLE: while(enemy.health > 0){
			if(alive){
				sub(options[0] + "\t" + options[1], options[2] + "\t" + options[3]);
				pl("");
				pl("\t What shall you do?! \n");
				input = TextIO.getlnWord();
				for(String x : options){
					while(!input.equals(x)){
						pl("\t Please choose a valid option!");
						input = TextIO.getlnWord();
					} // end while //
				} // end for:each //
				switch(input){
				case "ATTACK":
					if(CLASS.equals("SCORCHER") || CLASS.equals("VOIDED")){
						pl("\t ATTACK \n \t MAGIC");
						input = TextIO.getlnWord();
						if(input.equals("ATTACK")){
							attack();
						} else {
							// magicOptions();
						}
					} else {
						attack();
					}
					break;
				case "DEFEND":
					pl("\t You ready your guard! \n");
					defence = getDefence();
					break;
				case "ITEMS":
					
					break;
				case "FLEE":
					int x = (int)(Math.random() * 5);
					if(x < 1){
						sub("There is no escape this round...");
					} else {
						sub("You have successfully escaped from the " + enemy + ", " + TITLE);
						enemy.health = 0;
					}
				}
			} else {
				sub("You have no HEALTH left...", "The will to fight has left you...","");
				try {
					Thread.sleep(2500);
				} catch(InterruptedException e){
					Thread.currentThread().interrupt();
				}
				JGame.lost();
				break BATTLE;
			} // end if/else //
		} // end while(enemy.health > 0); enemy has been defeated at this point //
		
	} // end putOptions() //
	
	
	public void attack() {
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

	public int getDefence() {
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