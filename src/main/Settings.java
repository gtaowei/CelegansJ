package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Settings {
	
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
	
	private String cleanup(String s) {
		String lowString = s;
		lowString = lowString.trim().toLowerCase();
		String temp = "";
		int i = 0;
		while (i < lowString.length()) {
			int curAsc = lowString.charAt(i);
			if (((curAsc > 96) && (curAsc < 123)) || (curAsc == 32) || (curAsc == 45))  {
				if (curAsc == 45) {temp = temp + (char) 32;}
				else {temp = temp + (char) curAsc;}
			}
			i++;
		}
		return temp;
	}
	
	public Settings (String input_file) {
		try {
			FileInputStream fStream = new FileInputStream(new File(input_file));
			BufferedReader rd = new BufferedReader(new InputStreamReader(fStream));
			String nextLine;
				try {
					while ((nextLine = rd.readLine()) != null) {
						
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Input file error!");
				}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		}
	}
	
}