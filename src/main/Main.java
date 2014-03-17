package main;

import model.*;

public class Main {
	
	public static void main(String args[]) {
//		Timer t = Timer.instance();
//		t.initialize();
//		System.out.println(t.currentTime());
//		InputLine il = new InputLine("output_file = log.txt");
//		System.out.println(il.getVariable());
//		System.out.println(il.getValue());
		InputParse parse = InputParse.instance();
		parse.initialize("settings.txt");
		System.out.println(parse.initial_bacteria_concentration);
		System.out.println(parse.bacteria_replenish_interval);
	}
	
}