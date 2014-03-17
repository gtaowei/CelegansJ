package agents;

import java.util.Random;

import status.Death;
import status.LifeStage;
import main.InputParse;
import model.Timer;

public class Worm {
	
	private int id;
	private int currentX, currentY, currentZ, energy_reserve, size, num_progeny;
	private long time_born, time_larva, time_adult, time_wormbag;
	private LifeStage stage;
	private Death death;
	private Timer time = Timer.instance();
	private InputParse settings = InputParse.instance();
	private Random rand = new Random();
	
	public Worm (int id) {
		this.id = id;
		this.currentX = rand.nextInt(settings.dimension_x);
		this.currentY = rand.nextInt(settings.dimension_y);
		this.currentZ = rand.nextInt(settings.dimension_z);
		this.energy_reserve = settings.initial_worm_energy_min 
				+ rand.nextInt(settings.initial_worm_energy_max 
						- settings.initial_worm_energy_min);
		this.size = settings.adult_initial_size;
		this.num_progeny = 0;
		this.time_born = time.currentTick();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.ADULT;
		this.death = Death.ALIVE;
	}
	
	public Worm (int id, int currentX, int currentY, int currentZ) {
		this.id = id;
		this.currentX = currentX;
		this.currentY = currentY;
		this.currentZ = currentZ;
		this.energy_reserve = settings.larvae_initial_energy;
		this.size = settings.larvae_initial_size;
		this.num_progeny = 0;
		this.time_born = time.currentTick();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.LARVA;
		this.death = Death.ALIVE;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worm other = (Worm) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}