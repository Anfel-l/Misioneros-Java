package mundo;

import gfutria.Logic;

public class BlackWhite extends Logic
{
	private int missionary, cannibal;
	public int boat; // 1 left side, 0 right side
	public int boatCapacity;
	
	public static String M = "M"; // A missionary moves
	public static String MM = "MM"; // Two missionaries move
	public static String C = "C"; // A cannibal moves
	public static String CC = "CC"; // Two cannibals move
	public static String MC = "MC"; // 
	
	public String lastMove;
	
	
	/*
	 * Empty constructor
	 * 
	 * Generates a blank space in memory for
	 * a "BlackWhite" object.
	 * "
	 * */
	public BlackWhite() {
		missionary = cannibal = 3;
		boat=1;
		lastMove = "";
		boatCapacity=2;
		
	}
	
	/*
	 * Constructor with parameters*/
	public BlackWhite(int missionary, int cannibal, int boat) {
		this.missionary = missionary;
		this.cannibal = cannibal;
		this.boat = boat;
		lastMove = "";

	}
	
	/*
	 * 
	 * Third constructor*/
	
	public BlackWhite(BlackWhite state) {
		lastMove = state.lastMove;
		missionary = state.missionary;
		cannibal = state.cannibal;
		boat = state.boat;
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
	
	public int getBoatCapacity() {
		return boatCapacity;
	}
	
	
	
	/* State and ToString methods
	 * */
	
	public int[] getState() {
		int [] state = new int[3];
		state[0]= getMissionary();
		state[1]= getCannibal();
		state[2]= getBoat();
		
		return state;
	}
	
	/*
	 * Returns the final output
	 * 
	 * */
	
	public String printState() {
		int[] current_state = getState();
		return "Left side: " + 
			   " Missionaries: " + Math.abs(current_state[0])+
			   " Cannibals: " + Math.abs(current_state[1])+
			   " Boat: " + Math.abs(current_state[2]) +
			   " ______ " +
			   "Right side: " + 
			   " Missionaries: " +(3 - current_state[0])+
			   " Cannibals: " +(3 - current_state[1])+
			   " Boat: " +(1 - current_state[2]);

	}
	
	/*
	 * Action validation methods
	 * */
	
	// Main condition that determines if we can move the boat or not
	
	public boolean dangerousState(int missionary, int cannibal) {
		return (missionary < cannibal && missionary != 0)||(missionary > cannibal && missionary != 3);
	}
	
	/*
	 * This method determines if an individual can be transported or not
	 * Main rule: A movement is only allowed if there is the same amount of
	 * missionaries as cannibals, or the number of missionaries is above cannibals.
	 * 
	 * */
	
	public boolean canMove(String move) {
		if (lastMove.equals(move)) return false; 
        if (move.equals(M)){
            if (getBoat() == 1)
                return getMissionary() >= 1 && 
                       !dangerousState(missionary - 1,cannibal);
            else
                return 3-getMissionary() >= 1 && 
                       !dangerousState(missionary + 1,cannibal);
        }
        if (move.equals(MM)){
            if (getBoat() == 1)
                return getMissionary() >= 2 &&
                        !dangerousState(missionary - 2,cannibal);
            else
                return 3-getMissionary() >= 2 &&
                        !dangerousState(missionary + 2,cannibal);
        }
        if (move.equals(C)){
            if (getBoat() == 1)
                return getCannibal() >= 1 &&
                        !dangerousState(missionary,cannibal - 1);
            else
                return 3-getCannibal() >= 1 &&
                        !dangerousState(missionary,cannibal + 1);
        }
        if (move.equals(CC)){
            if (getBoat() == 1)
                return getCannibal() >= 2 &&
                        !dangerousState(missionary,cannibal - 2);
            else
                return 3-getCannibal() >= 2 &&
                        !dangerousState(missionary,cannibal + 2);
        }
        if (move.equals(MC)){
            if (getBoat() == 1)
                return getMissionary() >= 1 && getCannibal()  >= 1 &&
                        !dangerousState(missionary - 1,cannibal - 1);
            else
                return 3-getMissionary() >= 1 && 3-getCannibal() >= 1 &&
                        !dangerousState(missionary + 1,cannibal + 1);
                  
        }
        return false;
	
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
		
		lastMove = C;
		
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
		
		lastMove = M;
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
		
		lastMove = MM;
		
		
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
		
		lastMove = CC;
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
		
		lastMove = MC;
		
	}
	
	
	
	public int finalPeopleAmount() {
		int value = getMissionary() + getCannibal();
		return value;
	}
	
	
	/*
	 * Determines first if the action is allowed according to the
	 * "canMove" method which decides based on the main rule and then
	 * if true, proceeds and then does the movement.
	 * 
	 * */

	@Override
	public void action(int arg0) {
		switch(arg0) {
		case 1:
			if (canMove(C)) {
				carry_cannibal();	
			}
			
			break;
		case 2:
			if (canMove(M)) {
				carry_missionary();
			}

			break;
		case 3:
			if (canMove(CC)) {
				carry_2cannibals();
			}

			break;
		case 4:
			if (canMove(MM)) {
				carry_2missionaries();
			}
			break;
		case 5:
			if (canMove(MC)) {
				carry_oneofeach();
			}
			break;
		default: 
		    System.out.println("Invalid option");
			break;
		}
		
	}

	@Override
	public Logic cloneObject(Logic obj) {
		 BlackWhite objn = (BlackWhite) obj;
	     BlackWhite objc = new BlackWhite();

	     objc.setBoat(objn.getBoat());
	     objc.setCannibal(objn.getCannibal());
	     objc.setMissionary(objn.getMissionary());
	        
	     return objc;
		
		
	}

	@Override
	public String state() {
		int[] current_state = getState();
		
		// Returns the state of the situation represented as explained in the following text:
		// C: amount of cannibals
		// M: amount of missionaries
		// B: state of the boat
		//      LEFT RIGHT 
		//     M:C:B-M:C:B    
		String aux = Math.abs(current_state[0])+ ":" + Math.abs(current_state[1])+ ":" +Math.abs(current_state[2]) + "-" +
				   (3 - current_state[0])+ ":" +(3 - current_state[1])+ ":" +(1 - current_state[2]);
		
		return aux;
	}
	
	 

}




