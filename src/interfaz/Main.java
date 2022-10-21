package interfaz;

import mundo.BlackWhite;
import java.util.ArrayList;
import java.util.Iterator;

import gfutria.SearchStateSpaces;

public class Main {
	
	
	
	/*
	 * Manual test for BlackWhite Class
	 * */
	public void manualTest() {
		BlackWhite algoritmo = new BlackWhite();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2cannibals();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_cannibal();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2cannibals();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_cannibal();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2missionaries();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_oneofeach();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2missionaries();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_cannibal();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2cannibals();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_cannibal();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		algoritmo.carry_2cannibals();
		System.out.println(algoritmo.printState());
		System.out.println("Numero de personas sin trasladar:"+algoritmo.finalPeopleAmount());
		
	}
	
	public static void main(String [] args ) {
		
		
		BlackWhite test;
		ArrayList<String> lst;
		SearchStateSpaces sss;
		
		System.out.println("Test");
		test = new BlackWhite(3, 3, 1); // 3 missionaries, 3 cannibals, boat on the left side
		
		

		sss  = new SearchStateSpaces("0:0:0-3:3:1", test, 5);// 3 missionaries, 3 cannibals, Right side
		lst  = sss.solve();
		
		System.out.println("# of Steps: " + ((Integer)lst.size()+1));
		if (lst.size() > 0) {
			{
				System.out.println("      LEFT  RIGHT");
				System.out.println("XX :: M:C:B-M:C:B");
				System.out.println("Xo :: 3:3:1-0:0:0" + "\n");
				
				for (int i = 0; i < lst.size(); i++) {
					System.out.println(lst.get(i));
					
				}
			}
			
		}
		
	}

}
