package mundo;

public class BlackWhite {
	private int missionary, cannibal;
	public int boat; // 1 left side, 0 right side
	
	private int esquinaizq[];
	private int esquinader[];
	
	
	/*
	 * Empty constructor
	 * 
	 * Generates a blank space in memory for
	 * a "BlackWhite" object.
	 * "
	 * */
	public BlackWhite() {
		missionary = cannibal = 3;
	}

	
	/*
	 * Setter and getters for both Cannibal
	 * and Missionary values on 
	 * 
	 * */
	
	

    public void setBoat(int boat) {
		this.boat = boat;
	}
    public int getBoat() {
		return boat;
	}
	
	public int getCannibal() {
		return cannibal;
	}
	public int getMissionary() {
		return missionary;
	}
	public void setCannibal(int cannibal) {
		this.cannibal = cannibal;
	}
	public void setMissionary(int missionary) {
		this.missionary = missionary;
	}
	
	/*
	 * Action Methods
	 * 
	 * No missionaries, carry a cannibal
	 * No cannibals, carry a missionary
	 * No cannibal, carry 2 missionaries
	 * No missionaries, carry 2 cannibals
	 * Carry 1 cannibal and 1 missionary 
	 * 
	 * 
	 * */
	
	
	// Carry a cannibal
	public void carry_cannibal() {
		if(getBoat() == 1) {
			boat=0;
			cannibal--;	
		} else {
			boat = 1;
			cannibal++;
		}
		
	}
	
	// Carry a missionary
	public void carry_missionary() {
		if(getBoat() == 1) {
			boat=0;
			missionary--;	
		} else {
			boat = 1;
			missionary++;
		}
	}
	
	// No cannibal, 2 missionaries
	public void carry_2missionaries() {
		if(getBoat() == 1) {
			boat = 0;
			missionary = getMissionary() - 2; 
		} else {
			boat = 1;
			missionary = getMissionary() + 2;
		}
		
		
	}
	
	// No missionaries, 2 cannibals
	public void carry_2cannibals() {
		if(getBoat() == 1) {
			boat = 0;
			cannibal =  getCannibal() - 2; 
		} else {
			boat = 1;
			cannibal = getCannibal() + 2;
		
		}
	}
	
	// Carry one of each one
	public void carry_oneofeach() {
		if (getBoat() == 1) {
			boat = 0;
			missionary--;
			cannibal--;
		} else {
			boat = 1;
			missionary++;
			cannibal++;
		}
		
	}
	 

}




