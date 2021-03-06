import java.util.Arrays;
import java.util.List;

public class JGame {
	
	public static List<String> options = Arrays.asList("FIGHT","TRAVEL","ITEMS","STATS","SAVE","QUIT");
	
	public static void main(String[] args) {
		
		sect("Welcome to KUSHTOPIA, where danger and adventure lurk around every threshold.",
				"Let's start by getting to know you a little better.");
		User.Player.Init(); // All user info is now initialized and stored in enums/classes //
		sleep(3000);
		sect("AMAZING! We're done getting to know each other.",
				"Now here are your general stats before we start telling your story.");
		pl("\t\t**********************************\n");
		User.putStats();
		pl("\t\t**********************************\n\n");
		sleep(4000);
		sub("Now let's jump into the STORY, then. ");
		boolean ready = false;
		boolean running = true;
		while(!ready){
			pl("\t Are you ready? >>> \t ? ");
			ready = TextIO.getlnBoolean();
			while(!ready){
				pl("Okie dokie; take your time, 'TRAVELLER'... \n");
				sleep(3500);
				p("Ready yet? >>> \t ?");
				ready = TextIO.getlnBoolean();
			}
		}
		
		pl("\t . . . . .");
		sleep(1100);
		pl("\t . . . .");
		sleep(1100);
		pl("\t . . .");
		sleep(1100);
		pl("\t . .");
		sleep(1100);
		pl("\t !");
		sleep(1700);
		sect("Many eons ago, the land that we know as KUSHTOPIA was as lush as could be.",
				"From the multitude of plant and animal species to the crops and citizens, no other \n"
				+ "\t\t > region could come close to providing the same quality of life...");
		sleep(5700);
		sub("When the KING was in good favors, all of his loyal constituents were blessed with his kindness.",
				"The KING was generally a giving man, but he would be known to be selfish from time to time.",
				"Of course, being the KING, his business was publicized far past the extent that he could comprehend.");
		sleep(5700);
		sect("One swarthy day, when the sky looked as though she were ready to release darkness itself, \n"
				 + "\t\t > a band of guileful BASTION - one of the only known groups to date - razed the village \n"
				 + "\t\t > in the dead of night.");
		sleep(5700);
		sub("...", "The group pillaged every house and store in the village surrounding the castle.",
				"They made a quick pull through the village and a B-line toward the castle; where the king slept, \n"
				+ " \t\t > unaware of the terror that had befell his beloved KINGDOM.");
		sleep(5700); // I REALLY don't want to write more story lol
		
		
		/* GAME LOOP */
		
		GAME: while(running){
			sub("What would you do, " + User.Player.TITLE.desc + "?", "FIGHT \t TRAVEL", "ITEMS \t STATS",
					"SAVE \t QUIT");
			String input = TextIO.getlnWord().toUpperCase();
			if(options.contains(input)){
				switch(input){
				case "FIGHT":
					Battle.battle();
					break;
				case "STATS":
					User.putStats();
					break;
				case "QUIT":
					sect("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
						"############################################",
						"THANK YOU FOR CHOOSING KUSHTOPIA BY TEMPEST DESIGN STUDIOS 2015",
						"############################################",
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					sleep(3000);
						sub("Please play this game as often as you would like!!",
						"The source code can be found online at 'https://github.com/philly-phyre/KUSHTOPIA.git' .",
						"Also feel free to take a look at it whenever and contact me about changes/commits or ideas!!",
						"");
					Quit();
					break;
				default:
					sub("Oops; try again, " + User.Player.TITLE.desc);
				}
			} else if(!(options.contains(input))) {
				pl("Please enter a valid option!");
				sleep(2500);
			} // end if/else //
			continue GAME;
		} // end GAME loop //
		Quit();
	}// end main() //
	
	public static void lost(){
		sect("It appears that you have lost your life in battle...",
				"Your GUARDIAN takes your vulnerable body from the scene and partially revives you.",
				"HEALTH:    " + (int)(User.OHEALTH/3));
		User.HEALTH = (int)(User.OHEALTH/3);
			sleep(3200);
		sub("Continue on your journey, but be wary of the dangers native to this land...");
	} // end lost() //
	
	public static void Quit(){
		System.exit(0);
	} // end Quit() //
	
	public static void sleep(int x){
		try{
			Thread.sleep(x);
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
	} // end sleep() //
	
	
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
	
	

}
