import java.util.Arrays;
import java.util.List;



public class Invo {
	
	
	String TROPHIES = null; //so eclipse won't complain.
	
	public final String[][] pockets = {{"STATUS CHANGERS", "RUNES", "KEY ITEMS", "TROPHIES"},
			{"POTION", "SUPER POTION", "FULL HEAL"},{"ARMOR+","ATTACK+","EXP+","HEALTH+", "DISPELL+"},
			{"QUEST ITEMS","STORY ITEMS","JOURNAL"},{TROPHIES}}; //about this
	
	
	public final List<String[]> Pockets = Arrays.asList(pockets); //why couldn't I define it in the method, I wonder?
	
	public static String getPockets() {
		return ""; //and this
		
		
	}
	
	
	
	
	
}
