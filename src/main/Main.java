package main;

import io.Input;
import io.InputMatrix;
import io.InputParse;
import io.OutCSV;
import io.Output;
import io.SettingsHolder;

import java.util.ArrayList;

import status.Death;
import status.InputType;
import status.OutputType;
import agents.Worm;
import model.*;

public class Main {
	
	public static void main(String args[]) {
		SettingsHolder settings = SettingsHolder.getInstance();
		settings.load("settings.txt");
		Timer t = Timer.instance();
		t.init();
		final ArrayList<Worm> worms = new ArrayList<Worm>();
		int initial_num = Integer.parseInt(settings.getProperty("initial_number_worms"));
		Input newIn = new Input("testIn.xls");
		Output out = new Output("testOut.xls");
		OutCSV outcsv = new OutCSV("outCSV.csv");
		ArrayList<String> headers = new ArrayList<String>();
		headers.add("Tick #");
		headers.add("Worms");
		outcsv.writeHeader(headers);
		for (int i =0; i<initial_num; i++) {
			worms.add(new Worm(i));
		}
		Double bacteria = (double) 100;
		int counter = 0;
		while (counter < 10) {
			counter++;
			System.out.println("Tick #" + t.currentTick());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//out.log(t.currentTick(), worms);
			outcsv.writeLine(t.currentTick(), worms, OutputType.PROGENY);
			ArrayList<Worm> newWorms = new ArrayList<Worm>();
			for (int i=0; i<worms.size(); i++) {
				System.out.println("worm#" + i);
				Worm worm = worms.get(i);
				worm.ingest(3, 2);
				worm.exert(1);
				worm.age(0.1);
				worm.grow(1);
				worm.reproduce(1, worms.size()-1, 0.1, newWorms);
				worm.starve(0.01);
				worm.explode(worms.size()-1, 0.01, newWorms);
				if (t.currentTick() % Integer.parseInt(settings.getProperty("predation_interval")) == 0) {
					double hit = Math.random() * 100;
					if (hit < Double.parseDouble(settings.getProperty("predation_percentage"))) {
						worm.die(Death.PREDATION);
					}
				}
			}
			worms.addAll(newWorms);
			if (t.currentTick() % Integer.parseInt(settings.getProperty("bacteria_replenish_interval")) == 0) {
				bacteria += Double.parseDouble(settings.getProperty("bacteria_replenish_concentration"));
			}
			t.incr();
		}
		outcsv.close();
	}
	
}