package main;

import java.util.ArrayList;

import agents.Worm;
import model.*;

public class Main {
	
	public static void main(String args[]) {
		Timer t = Timer.instance();
		t.initialize();
//		System.out.println(t.currentTick());
//		InputLine il = new InputLine("output_file = log.txt");
//		System.out.println(il.getVariable());
//		System.out.println(il.getValue());
		InputParse parse = InputParse.instance();
		parse.initialize("settings.txt");
//		System.out.println(parse.initial_bacteria_concentration);
//		System.out.println(parse.bacteria_replenish_interval);
		ArrayList<Worm> worms = new ArrayList<Worm>();
		System.out.println(t.currentTick());
		for (int i = 0; i < 100000; i++) {
			worms.add(new Worm (i));
		}
		System.out.println(t.currentTick());
	}
	
}