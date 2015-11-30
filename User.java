public class User {
	
<<<<<<< HEAD
<<<<<<< HEAD
	static int LEVEL = 0;
	
	final static int ATTACK = (int)(Math.random() * LEVEL + (Math.random() * 11));
		
=======
>>>>>>> 67f13360f90d24566fd12bcf70580d1c6a24175a
	public enum Player {
=======
	static int LEVEL;
	static int HEALTH;
	static int OHEALTH;
	
	public enum Player {		
>>>>>>> fc451edfaaf0ace92c229745343a9cc62173f599
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
		} // end Init() //
	} // end Player enum //
	
	public static void putStats() {
<<<<<<< HEAD
		sub("NAME:     " + Player.NAME.desc, "CLASS:    " + Player.CLASS.desc, "TITLE:    " + Player.TITLE.desc,
<<<<<<< HEAD
				" ", "LEVEL:    " + LEVEL);
=======
		sub("NAME:     " + Player.NAME.desc, "CLASS:    " + Player.CLASS.desc, "TITLE:    " + Player.TITLE.desc);
>>>>>>> 67f13360f90d24566fd12bcf70580d1c6a24175a
=======
				" ", "LEVEL:    " + LEVEL, "HEALTH:   " + HEALTH);
>>>>>>> fc451edfaaf0ace92c229745343a9cc62173f599
	}
	
	
	public static void pl(String x) {
		TextIO.putln("\t" + x);
	} // end pl() //
	
	public static void p(String y) {
		TextIO.put("\t" + y);
	} // end p() //
	
	public static void sub(String...str) {
		pl("\t**********************************\n");
		for(String x : str) {
			pl("\t" + x + "\n");
		}
	}
}
