
public class JGame {
	
	public static void main(String[] args) {
		
		sect("Welcome to KUSHTOPIA, where danger and adventure lurk around every threshold.",
				"Let's start by getting to know you a little better.");
		User.Player.Init(); // All user info is now initialized and stored in enums/classes //
		sleep(2500);
		sect("AMAZING! We're done getting to know each other.",
				"Now here are your general stats before we start telling your story.");
		pl("\t\t**********************************\n");
		User.putStats();
		pl("\t\t**********************************\n\n");
		sleep(3000);
		sub("Now let's jump into the STORY, then. ");
		boolean ready = false;
		boolean running = true;
		while(!ready){
			p("\t Are you ready? >>> \t ? ");
			ready = TextIO.getlnBoolean();
			if(!ready){
				pl("Okie dokie; take your time, TRAVELLER...");
				sleep(2500);
			}
		}
		
		sect("Many eons ago, the land that we know as KUSHTOPIA was as lush as could be.",
				"From the multitude of plant and life species to the crops and citizens, no other \n"
				+ "\t\t > region could come close to providing the same quality of life...");
		sub("When the KING was in good favors, all of his loyal (subjects)" /*change */ + " were blessed with his kindness.",
				"The KING was generally a giving man, but he would be known to be selfish from time to time.",
				"Of course, being the KING, his business was publicized far past the extent that he could comprehend.");
		sect("One swarthy day, when the sky looked as though she were ready to release darkness itself, \n"
				 + "\t\t > a band of guileful BASTION - one of the only known groups to date - razed the village \n"
				 + "\t\t > in the dead of night.");
		sub("...", "The group pillaged every house and store in the village surrounding the castle.",
				"They made a quick pull through the village and a B-line toward the castle; where the king slept, \n"
				+ " \t\t > unaware of the terror that had befell his beloved KINGDOM.");
		
		
		Class.getCls();
		
		
		/* GAME LOOP */
		
		while(running){
			
			
		}
		
	}
	
	// TextIO shortened routines //
	
	public static void pl(String x) {
		TextIO.putln(x);
	} // end pl() //
	
	public static void p(String y) {
		TextIO.put(y);
	} // end p() //
	
	public static void pf(String z) {
		TextIO.putf(z);
	} // end pf() //
	
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

}
