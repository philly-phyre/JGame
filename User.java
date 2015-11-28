public class User {
	
	static int LEVEL = 0;
	
	final static int ATTACK = (int)(Math.random() * LEVEL + (Math.random() * 11));
		
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
		} // end Init() //
			
	} // end Player enum //
	
	public static void putStats() {
		sub("NAME:     " + Player.NAME.desc, "CLASS:    " + Player.CLASS.desc, "TITLE:    " + Player.TITLE.desc,
				" ", "LEVEL:    " + LEVEL);
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
