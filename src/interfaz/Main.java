package interfaz;

import mundo.BlackWhite;

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
		
		Main main = new Main();
		
		main.manualTest();
		
	}

}
