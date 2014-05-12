package model;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tick {
	
	private static int currentTick;
	private static CyclicBarrier barrier;
	private static Tick staticDefaultBarrier = new Tick();

	private Tick() {}
	
	public static Tick instance() {
		return staticDefaultBarrier;
	}
	
	public void initialize() {
		currentTick = 0;
		barrier.reset();
	}
	
	
	/**
	 * this moves the current tick to the next one
	 * @param parties: the number of worms the tick is waiting on
	 * @author Wei Tao
	 */
	public void tick(int parties) {
		++currentTick;
		barrier = new CyclicBarrier(parties);
	}
	
	public void await() {
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int currentTick() {
		return currentTick;
	}
}
