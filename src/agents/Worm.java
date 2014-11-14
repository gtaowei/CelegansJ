package agents;

import io.SettingsHolder;

import java.util.ArrayList;
import java.util.Random;

import status.Death;
import status.LifeStage;
import model.Timer;

public class Worm implements Runnable{
	
	public int id;
	public double currentX, currentY, currentZ, energy_reserve, mass, num_progeny;
	public long time_born, time_larva, time_adult, time_wormbag;
	public LifeStage stage;
	public Death death;
	private Timer time = Timer.instance();
	private SettingsHolder settings = SettingsHolder.getInstance();
	private Random rand = new Random();
	private static Random rnd = new Random();
	private Phenotype phenotype;
	
	public Worm (int id) {
		this.id = id;
		System.out.println(settings.getProperty("dimension_x"));
		this.currentX = rand.nextInt(Integer.parseInt(settings.getProperty("dimension_x")));
		this.currentY = rand.nextInt(Integer.parseInt(settings.getProperty("dimension_y")));
		this.currentZ = rand.nextInt(Integer.parseInt(settings.getProperty("dimension_z")));
		this.energy_reserve = Integer.parseInt(settings.getProperty("initial_worm_energy_min")) 
				+ rand.nextInt(Integer.parseInt(settings.getProperty("initial_worm_energy_max")) 
						- Integer.parseInt(settings.getProperty("initial_worm_energy_min")));
		this.mass = Integer.parseInt(settings.getProperty("adult_initial_size"));
		this.num_progeny = 0;
		this.time_born = time.currentTick();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.ADULT;
		this.death = Death.ALIVE;
		this.phenotype = new Phenotype();
	}
	
	public Worm (int id, int currentX, int currentY, int currentZ) {
		this.id = id;
		this.currentX = currentX;
		this.currentY = currentY;
		this.currentZ = currentZ;
		this.energy_reserve = Integer.parseInt(settings.getProperty("larvae_initial_energy"));
		this.mass = Integer.parseInt(settings.getProperty("larvae_initial_size"));
		this.num_progeny = 0;
		this.time_born = time.currentTick();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.LARVA;
		this.death = Death.ALIVE;
		this.phenotype = new Phenotype();
	}
	
	public void ingest(double amount, double absorbPortion) {
		if (phenotype.getTrait("ingestion") != null) {
			double newAmount = phenotype.getTrait("ingestion") * amount;
			absorb(newAmount, absorbPortion);
		} else {
			absorb(amount, absorbPortion);
		}
	}
	
	private void absorb(double amount, double portion) {
		if (phenotype.getTrait("absorption") != null) {
			this.energy_reserve += phenotype.getTrait("absorption") * portion * amount;
		} else {
			this.energy_reserve += portion * amount;
		}
	}
	
	public void grow(double portion) {
		if (phenotype.getTrait("growth") != null) {
			double amount = this.energy_reserve * phenotype.getTrait("growth") * portion;
			this.mass += amount;
			this.energy_reserve -= amount;
		} else {
			double amount = this.energy_reserve * portion;
			this.mass += amount;
			this.energy_reserve -= amount;
		}
	}
	
	public void exert(double amount) {
		if (phenotype.getTrait("exertion") != null) {
			this.energy_reserve -= phenotype.getTrait("exertion") * amount;
		} else {
			this.energy_reserve -= amount;
		}
	}
	
	public void age() {
		
	}
	
	public void reproduce(int num, int maxId, double cost, ArrayList<Worm> worms) {
		int newnum;
		if (phenotype.getTrait("reproduction") != null) {
			newnum = (int) (phenotype.getTrait("exertion") * num);
		} else {
			newnum = num;
		}
		int counter = maxId;
		for (int i = 0; i<newnum; i++) {
			counter++;
			Worm larva = new Worm(counter);
			worms.add(larva);
		}
		this.num_progeny += newnum;
		this.energy_reserve -= newnum * cost;
	}
	
	public void starve() {
		
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

	@Override
	public void run() {
		try {
			Thread.sleep(rnd.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Worm #" + id + "just performed action");
	}
	
}