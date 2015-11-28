public class User {
	
	static int LEVEL;
	static int HEALTH;
	static int OHEALTH;
	
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
			HEALTH = (int)((Math.random() * LEVEL + 15) + ((Math.random() * 80) - (Math.random() * 25)));
			OHEALTH = HEALTH;
		} // end Init() //
	} // end Player enum //
	
	public static void putStats() {
		sub("NAME:     " + Player.NAME.desc, "CLASS:    " + Player.CLASS.desc, "TITLE:    " + Player.TITLE.desc,
				" ", "LEVEL:    " + LEVEL, "HEALTH:   " + HEALTH);
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
