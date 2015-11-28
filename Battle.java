public class Battle {
	
	Enemy enemy;
	User.Player TITLE = User.Player.TITLE;
	
	void pickEnemy() {
		int x = (int)(Math.random() * 7);
		enemy = Enemy.values()[x];
	} // end pickEnemy() //

	void battle() {
		pickEnemy();
		sect("You are under attack, " + TITLE);
		enemy.putStats();
		
		
	} // end battle(); //
	
	
	public static String options[] = {"ATTACK", "DEFEND", "ITEMS", "FLEE"};
	
	public static Attack() {
		
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
}