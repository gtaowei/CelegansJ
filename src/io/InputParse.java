package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/*Deprecated
 * */
public class InputParse {
	
	public String output_file;
	public int dimension_x;
	public int dimension_y;
	public int dimension_z;
	public int initial_number_worms;
	public int worms_gain_from_food;
	public int reproduce_energy_cost;
	public int worms_max_progeny;
	public int initial_worm_energy_min;
	public int initial_worm_energy_max;
	public int initial_bacteria_concentration;
	public int bacteria_replenish_interval;
	public int bacteria_replenish_concentration;
	public int predation_interval;
	public int predation_percentage;
	public int adult_movement_energy_cost;
	public int larvae_movement_energy_cost;
	public int larvae_initial_energy;
	public int wormbag_dormancy;
	public int wormbag_energy_threshold;
	public int wormbag_max_progeny;
	public int larvae_max_size;
	public int adult_max_size;
	public int size_energy_multiplier;
	public int larvae_initial_size;
	public int adult_initial_size;
	public int millisecond_to_tick_ratio;
	
	private InputParse() {}
	
	private static InputParse Settings = new InputParse();
	
	public static InputParse instance() {
		return Settings;
	}
	
	public void initialize (String input_file) {
		try {
			FileInputStream fStream = new FileInputStream(new File(input_file));
			BufferedReader rd = new BufferedReader(new InputStreamReader(fStream));
			String nextLine;
				try {
					while ((nextLine = rd.readLine()) != null) {
						InputLine inLine = new InputLine (nextLine);
						switch (inLine.getVariable()) {
						case "output_file":
							this.output_file = inLine.getValue();
							break;
						case "dimension_x":
							this.dimension_x = Integer.parseInt(inLine.getValue());
							break;
						case "dimension_y":
							this.dimension_y = Integer.parseInt(inLine.getValue());
							break;
						case "dimension_z":
							this.dimension_z = Integer.parseInt(inLine.getValue());
							break;
						case "initial_number_worms":
							this.initial_number_worms = Integer.parseInt(inLine.getValue());
							break;
						case "worms_gain_from_food":
							this.worms_gain_from_food = Integer.parseInt(inLine.getValue());
							break;
						case "reproduce_energy_cost":
							this.reproduce_energy_cost = Integer.parseInt(inLine.getValue());
							break;
						case "worms_max_progeny":
							this.worms_max_progeny = Integer.parseInt(inLine.getValue());
							break;
						case "initial_worm_energy_min":
							this.initial_worm_energy_min = Integer.parseInt(inLine.getValue());
							break;
						case "initial_worm_energy_max":
							this.initial_worm_energy_max = Integer.parseInt(inLine.getValue());
							break;
						case "initial_bacteria_concentration":
							this.initial_bacteria_concentration = Integer.parseInt(inLine.getValue());
							break;
						case "bacteria_replenish_interval":
							this.bacteria_replenish_interval = Integer.parseInt(inLine.getValue());
							break;
						case "bacteria_replenish_concentration":
							this.bacteria_replenish_concentration = Integer.parseInt(inLine.getValue());
							break;
						case "predation_interval":
							this.predation_interval = Integer.parseInt(inLine.getValue());
							break;
						case "predation_percentage":
							this.predation_percentage = Integer.parseInt(inLine.getValue());
							break;
						case "adult_movement_energy_cost":
							this.adult_movement_energy_cost = Integer.parseInt(inLine.getValue());
							break;
						case "larvae_movement_energy_cost":
							this.larvae_movement_energy_cost = Integer.parseInt(inLine.getValue());
							break;
						case "larvae_initial_energy":
							this.larvae_initial_energy = Integer.parseInt(inLine.getValue());
							break;
						case "wormbag_dormancy":
							this.wormbag_dormancy = Integer.parseInt(inLine.getValue());
							break;
						case "wormbag_energy_threshold":
							this.wormbag_energy_threshold = Integer.parseInt(inLine.getValue());
							break;
						case "wormbag_max_progeny":
							this.wormbag_max_progeny = Integer.parseInt(inLine.getValue());
							break;
						case "larvae_max_size":
							this.larvae_max_size = Integer.parseInt(inLine.getValue());
							break;
						case "adult_max_size":
							this.adult_max_size = Integer.parseInt(inLine.getValue());
							break;
						case "size_energy_multiplier":
							this.size_energy_multiplier = Integer.parseInt(inLine.getValue());
							break;
						case "larvae_initial_size":
							this.larvae_initial_size = Integer.parseInt(inLine.getValue());
							break;
						case "adult_initial_size":
							this.adult_initial_size = Integer.parseInt(inLine.getValue());
							break;
						case "millisecond_to_tick_ratio":
							this.millisecond_to_tick_ratio = Integer.parseInt(inLine.getValue());
							break;
						}
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Input file error!");
				}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		}
	}
	
}