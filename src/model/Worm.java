package model;

public class Worm {
	
	private int id;
	private int energy_reserve, size, num_progeny;
	private long time_born, time_larva, time_adult, time_wormbag;
	private Death death;
	
	
	public Worm (int id) {
		this.id = id;
	}
	
}