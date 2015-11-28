public class Battle {
	
	Enemy enemy;
	User.Player TITLE = User.Player.TITLE;
	String CLASS = User.Player.CLASS.desc;
	
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
		sub();
		
	} // end battle(); //
	
	
	public static String options[] = {"ATTACK", "DEFEND", "ITEMS", "FLEE"};
	public void putOptions() {
		String input;
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
					enemy.health -= attack();
				} else {
					// magicOptions();
				}
			} else {
				enemy.health -= attack();
			}
			break;
		case "DEFEND":
			
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
	} // end putOptions() //
	
	
	public int attack() {
		int LEVEL = User.LEVEL;
		int ATTACK = 0;		
		switch(CLASS){
		case "BASTION":
			ATTACK = (int)((Math.random() * LEVEL + 1) + (Math.random() * LEVEL +8));
		case "TITAN":
			ATTACK = (int)((Math.random() * LEVEL + 2) + (Math.random() * LEVEL + 15));
		case "SCORCHER":
			ATTACK = (int)((Math.random() * LEVEL) +  (Math.random() * LEVEL + 3));
		case "PANZER":
			ATTACK = (int)((Math.random() * LEVEL + 1) + (Math.random() * LEVEL + 10));
		case "VOIDED":
			ATTACK = (int)((Math.random() * LEVEL) + (Math.random() * LEVEL + 3));
			}
		return ATTACK;
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