package main;

import java.util.ArrayList;

import model.Tick;
import model.Timer;
import agents.Worm;
import status.InputType;

public class Test {

	public static void main(String[] args) {
		Input newIn = new Input("testIn.xls");
		InputMatrix testMatrix = newIn.getTable(InputType.INGESTION);
		testMatrix.print();
		System.out.println(testMatrix.computeRate(19.1, 0.1));
//		InputParse parse = InputParse.instance();
//		parse.initialize("settings.txt");
//		Timer t = Timer.instance();
//		t.initialize();
//		System.out.println(t.currentTick());
//		InputLine il = new InputLine("output_file = log.txt");
//		System.out.println(il.getVariable());
//		System.out.println(il.getValue());
//		System.out.println(parse.initial_bacteria_concentration);
//		System.out.println(parse.bacteria_replenish_interval);
//		final ArrayList<Worm> worms = new ArrayList<Worm>();
//		System.out.println(t.currentTick());
//		for (int i = 0; i < 10000; i++) {
//			worms.add(new Worm (i));
//		}
//		System.out.println(t.currentTick());
//		final Tick tic = Tick.instance();
//		while (true) {
//			tic.tick(10);
//			System.out.println("current tick: " + tic.currentTick());
//			for (int i = 0; i < 100; ++i) {
//				Thread v = new Thread(new Worm(i));
//				v.start();
//			}
//		}
	}

}
