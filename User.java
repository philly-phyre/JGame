public class User {
	
	static int LEVEL;
	static int HEALTH;
	static int OHEALTH;
	static int EXP;
	static int cEXP;
	
	public enum Player {		
		NAME(""), CLASS(""), TITLE("");
		
		String desc;
		
		
		Player(String desc){
			this.desc = desc;
		}
				
		static void Init() {
			String input;
			boolean a;
			sub("");
			do{
				pl(">>> What is your NAME, young traveller? \n");
				pl("> > ???");
				p("\t");
				input = TextIO.getlnWord();
				if(input.equals("")){
					pl("\t ^^^^^ Please enter a NAME. ^^^^^ \n");
					a = true;
				} else {
					NAME.desc = input;
					a= false;
				}
			} while(a);
			Class.setClass();
			sub("Your TITLE shall be 'TRAVELLER' at the beginning of your adventure...");
			TITLE.desc = "'TRAVELLER'";
			HEALTH = (int)((Math.random() * LEVEL + 15) + (Math.random() * 70 + 55));
			OHEALTH = HEALTH;
			EXP = setEXP();
			cEXP = 0;
		} // end Init() //
	} // end Player enum //
	
	public static void putStats() {
		sub("NAME:     " + Player.NAME.desc, "CLASS:    " + Player.CLASS.desc, "TITLE:    " + Player.TITLE.desc,
				" ", "LEVEL:    " + LEVEL, "HEALTH:   " + HEALTH,
				"EXP:       " + cEXP + ", " + (EXP-cEXP) + " EXP left until the next LEVEL");
	}
	
	public static int setEXP() {
		if(LEVEL <= 5){
			return (int)((Math.random() * LEVEL + 40) + 100);
		} else if(LEVEL >= 6 && LEVEL <= 10){
			return (int)((Math.random() * LEVEL + 60) + 125);
		} else {
			return (int)((Math.random() * LEVEL + 75) + 165);
		}
	}
	
	public static void checkEXP() {
		if(cEXP >= EXP){
			LEVEL++;
			OHEALTH += (int)(Math.random() * 26 + LEVEL);
			HEALTH = OHEALTH;
			cEXP = 0;
			EXP = setEXP();
			sub("CONGRATULATIONS!!! You have gained a LEVEL, " + Player.TITLE.desc + "!");
			JGame.sleep(3300);
			putStats();
		} else{
			;
		}
	}
	
	public static void pl(String x) {
		TextIO.putln("\t" + x);
	} // end pl() //
	
	public static void p(String y) {
		TextIO.put("\t" + y);
	} // end p() //
	
	public static void sub(String...str) {
		pl("\t\t**********************************\n");
		for(String x : str) {
			pl("\t" + x + "\n");
		}
	}
}
