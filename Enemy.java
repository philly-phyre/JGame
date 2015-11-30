
public enum Enemy {
		
	SKELETON("A skeletal WARRIOR from the VOID.", 1), BANSHEE("A rampant, howling presence from the VOID.", 1), 
	DRAKE("A small DRAGON, yet still bigger than you.", 2), SPECTRE("An ectoplasmic vision from the VOID.", 2),
	GHOUL("A freakish beast, hungry for destruction.", 2), GREMLIN("A small IMP who enjoys making big trouble.", 0),
	SLIME("A gelationus being thought of as \"pawns\".", 1), KINGSLIME("A noble SLIME who controls smaller SLIME.", 3); 
	
	private String desc;
	private int expType;
	public int level;
	public int exp;
	public int health;
	public String name;
	
	Enemy(String desc, int expType) {
		this.desc = desc;
		this.expType = expType;
		this.level = (int)(User.LEVEL * Math.random()) + (int)(Math.random() * 4);
		this.exp = this.setExp();
		this.health = (int)(level * (Math.random() * 15) + 7);
		this.name = this.toString();
	}
	
	void describe(){
		TextIO.putln(" > > ************************************************** < < \n");
		TextIO.putln("\t\t\t-" + this.toString() + "-");
		TextIO.putln("\t " + this.desc + "\n");
		TextIO.putln(" > > ************************************************** < < \n");
	}
	
	
	
	int setExp(){
		int x = this.expType;
		int y = 0;
		switch(x){
		case 0:
			y = (int) (this.level * Math.random() + 2);
		case 1:
			y = (int) (this.level * Math.random() + 5);
		case 2:
			y = (int) (this.level * Math.random() + 11);
		case 3:
			y = (int) (this.level * Math.random() + 18);
		}
		return y;
	}
	
	int getExp() {
		return this.exp;
	}
	
	
	
	void sub(String...str) {
		TextIO.putln("\t\t**********************************\n");
		for(String x : str) {
			TextIO.putln("\t" + x + "\n");
		}
	
	}
	
	void putStats() {
		sub("ENEMY: " + this.name + ", " + this.desc,
			"LEVEL: " + this.level,
			"HEALTH: " + this.health);	
	}

}
