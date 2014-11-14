package agents;

import io.SettingsHolder;

import java.util.ArrayList;
import java.util.Random;

import status.Death;
import status.LifeStage;
import model.Timer;

public class Worm implements Runnable {

	public int id;
	public double currentX, currentY, currentZ, energy_reserve, mass,
			num_progeny;
	public int time_born, time_larva, time_adult, time_wormbag, time_die;
	public LifeStage stage;
	public Death death;
	private Timer time = Timer.instance();
	private SettingsHolder settings = SettingsHolder.getInstance();
	private Random rand = new Random();
	private static Random rnd = new Random();
	private Phenotype phenotype;
	private int tick_time;

	public Worm(int id) {
		this.id = id;
		this.currentX = rand.nextInt(Integer.parseInt(settings
				.getProperty("dimension_x")));
		this.currentY = rand.nextInt(Integer.parseInt(settings
				.getProperty("dimension_y")));
		this.currentZ = rand.nextInt(Integer.parseInt(settings
				.getProperty("dimension_z")));
		this.energy_reserve = Integer.parseInt(settings
				.getProperty("initial_worm_energy_min"))
				+ rand.nextInt(Integer.parseInt(settings
						.getProperty("initial_worm_energy_max"))
						- Integer.parseInt(settings
								.getProperty("initial_worm_energy_min")));
		this.mass = Integer
				.parseInt(settings.getProperty("adult_initial_size"));
		this.num_progeny = 0;
		this.time_born = time.currentTick();
		this.time_adult = 0;
		this.time_larva = 0;
		this.time_wormbag = 0;
		this.stage = LifeStage.ADULT;
		this.death = Death.ALIVE;
		this.phenotype = new Phenotype();
		this.tick_time = Integer.parseInt(settings.getProperty("tick_time"));
	}

	public Worm(int id, int currentX, int currentY, int currentZ) {
		this.id = id;
		this.currentX = currentX;
		this.currentY = currentY;
		this.currentZ = currentZ;
		this.energy_reserve = Integer.parseInt(settings
				.getProperty("larvae_initial_energy"));
		this.mass = Integer.parseInt(settings
				.getProperty("larvae_initial_size"));
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
		if (death == Death.ALIVE) {
			if (phenotype.getTrait("ingestion") != null) {
				double newAmount = phenotype.getTrait("ingestion") * amount
						* tick_time;
				absorb(newAmount, absorbPortion);
			} else {
				absorb(amount, absorbPortion);
			}
		}
	}

	private void absorb(double amount, double portion) {
		if (phenotype.getTrait("absorption") != null) {
			this.energy_reserve += phenotype.getTrait("absorption") * portion
					* amount;
		} else {
			this.energy_reserve += portion * amount;
		}
	}

	public void grow(double rate) {
		if (death == Death.ALIVE) {
			if (phenotype.getTrait("growth") != null) {
				double amount = phenotype.getTrait("growth") * rate * tick_time;
				if (amount > energy_reserve) {
					amount = energy_reserve;
				}
				this.mass += amount;
				this.energy_reserve -= amount;
			} else {
				double amount = rate * tick_time;
				this.mass += amount;
				this.energy_reserve -= amount;
			}
			if (mass >= Integer.parseInt(settings.getProperty("larvae_adult_threshold"))){
				this.stage = LifeStage.ADULT;
				this.time_adult = Timer.currentTick();
			}
		}
	}

	public void exert(double amount) {
		if (death == Death.ALIVE) {
			if (phenotype.getTrait("exertion") != null) {
				this.energy_reserve -= phenotype.getTrait("exertion") * amount
						* tick_time;
			} else {
				this.energy_reserve -= amount * tick_time;
			}
		}
	}

	public void age(double probability) {
		if (death == Death.ALIVE) {
			double hit = Math.random();
			if (hit < probability) {
				die(Death.AGEING);
			}
		}
	}

	public void die(Death way) {
		this.death = way;
		this.stage = LifeStage.DEAD;
		this.time_die = Timer.currentTick();
	}

	public void wormbag() {
		this.death = Death.WORMBAG;
		this.stage = LifeStage.WORMBAG;
		this.time_wormbag = Timer.currentTick();
	}
	
	public void explode(int maxId, double cost, ArrayList<Worm> worms) {
		if (stage == LifeStage.WORMBAG){
			int curTick = Timer.currentTick();
			if ((curTick - this.time_wormbag) > Integer.parseInt(settings.getProperty("wormbag_dormancy"))){
				this.stage = LifeStage.DEAD;
				this.time_die = Timer.currentTick();
				int counter = maxId;
				while ((this.energy_reserve - cost)>0) {
					counter++;
					Worm larva = new Worm(counter);
					worms.add(larva);
					this.energy_reserve -= cost;
					this.num_progeny++;
				}
			}
		}	
	}

	public void reproduce(int num, int maxId, double cost, ArrayList<Worm> worms) {
		if (this.stage == LifeStage.ADULT) {
			int newnum;
			if (phenotype.getTrait("reproduction") != null) {
				newnum = (int) (phenotype.getTrait("exertion") * num * tick_time);
			} else {
				newnum = num * tick_time;
			}
			int counter = maxId;
			for (int i = 0; i < newnum; i++) {
				if ((this.energy_reserve - cost) < 0) {
					break;
				}
				counter++;
				Worm larva = new Worm(counter);
				worms.add(larva);
				this.energy_reserve -= cost;
				this.num_progeny++;
			}
		}
	}

	public void starve(double probability) {
		if (death == Death.ALIVE) {
			double hit = Math.random();
			if (hit < probability) {
				switch (stage) {
				case LARVA:
					die(Death.STARVATION);
					break;
				case ADULT:
					wormbag();
					break;
				}
			}
		}
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
	}

}