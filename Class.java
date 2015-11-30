
public enum Class { 
	BASTION("A shadowy presence and a steady hand describe the BASTION; they are a lone traveler. "
			+ "It's said that when they are seen, it's never for long and many things turn up missing thereafter."),
	
	TITAN("A complete Powerhouse who can learn to manipulate the EARTH beneath his/her feet. "
			+ "They have good perseverance and deal heavy blows more often than others."),
	
	SCORCHER("The power of the PLANETS channels itself through the body of the SCORCHER. "
			+ "They have a vast knowledge of LIGHT magic and herbology, and make excellent BEAST hunters."),
	
	PANZER("A Fighter who specializes in hunting DRAGONS and DRAKES, and creating ARMOR from their scales. "
			+ "They are very resourceful, and know the land well."),
	
	VOIDED("A Scholar that has extensively studied the VOID and that which lies beyond it. "
			+ "They have a firm knowledge of VOID magic and potion-making, and are effective VOID hunters.");
	
	private String desc;
	
	Class(String desc) {
		this.desc = desc;
	}
	
	static void setClass() {
		for(Class c : Class.values()) {
			TextIO.putln("\t\t**********************************\n");
			TextIO.putln(" >> >> " + c + ":\n\n" + "\t >> " + c.desc.substring(0,45) +
							"\n\t >> " + c.desc.substring(45,94) + "\n" + " \t >> " + c.desc.substring(94,139) + "\n"
							+ "\t >> " + c.desc.substring(139));
			TextIO.putln("\t\t**********************************\n");
			try {
				Thread.sleep(3700);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		} // end for each //
		
		String input;
		boolean a = true;
		do {
			TextIO.putln("\t >>> Which CLASS do you embody?:    \n");
			TextIO.putln("\t > > ???");
			TextIO.put("\t \t");
			input = TextIO.getlnWord().toUpperCase();
			if(Class.contains(input)) {
				User.Player.CLASS.desc = input;
				a = false;
			} else {
				TextIO.putln(" >>> Please choose a valid option after rereading the descriptions!!\n"
						+ "\t\t**********************************\n");
				a = true;
			} // end if/else //
		} while (a); // end do/while //
	} // end setClass() //
	
	 public static String returnCls() {
		String b = User.Player.CLASS.desc;
		for(Class c : Class.values()){
			if(!b.equals(c.toString())){
				break;
			}
		}
			return b;	
	}
	
	static boolean contains(String x) {
		for(Class c : Class.values()) {
			if(x.equals(c.toString()))
				return true;
		}
		return false;
	} // end contains() //
} // end enum Class //
