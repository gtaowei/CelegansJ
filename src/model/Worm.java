package model;

import main.InputParse;

public class Worm {
	
	private int id;
	private int currentX, currentY, currentZ, energy_reserve, size, num_progeny;
	private long time_born, time_larva, time_adult, time_wormbag;
	private LifeStage stage;
	private Death death;
	private Timer time = Timer.instance();
	
	public Worm (int id) {
		this.id = id;
	}
	
	public Worm (int id, int currentX, int currentY, int currentZ) {
		this.id = id;
		this.currentX = currentX;
		this.currentY = currentY;
		this.currentZ = currentZ;
		this.energy_reserve = 
		this.size = 
		this.num_progeny = 0;
		this.time_born = time.currentTime();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.LARVA;
		this.death = Death.ALIVE;
	}
	
}