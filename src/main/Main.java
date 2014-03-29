package main;

import java.util.ArrayList;

import agents.Worm;
import model.*;

public class Main {
	
	public static void main(String args[]) {
		InputParse parse = InputParse.instance();
		parse.initialize("settings.txt");
		Timer t = Timer.instance();
		t.initialize();
//		System.out.println(t.currentTick());
//		InputLine il = new InputLine("output_file = log.txt");
//		System.out.println(il.getVariable());
//		System.out.println(il.getValue());
//		System.out.println(parse.initial_bacteria_concentration);
//		System.out.println(parse.bacteria_replenish_interval);
		final ArrayList<Worm> worms = new ArrayList<Worm>();
		System.out.println(t.currentTick());
		for (int i = 0; i < 100000; i++) {
			worms.add(new Worm (i));
		}
//		System.out.println(t.currentTick());
		final Tick tic = Tick.instance();
		while (true) {
			tic.tick(10);
			System.out.println("current tick: " + tic.currentTick());
			for (int i = 0; i < 10; ++i) {
				final int temp = i;
				Thread v = new Thread(new Runnable() {
					public void run() {
						System.out.println("Worm #" + temp + "just performed action");
						tic.await();
					}
				});
				v.start();
				try {
					v.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}