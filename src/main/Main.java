package main;

import model.*;

public class Main {
	
	public static void main(String args[]) {
		Timer t = Timer.instance();
		t.initialize();
		System.out.println(t.currentTime());
		Settings ss = new Settings("settings.txt");
		InputLine new = new InputLine("dimension_y = 100");
		
	}
	
}