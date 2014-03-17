package model;

public class Timer {
	
	private long initialTime;

	private Timer(){}
	
	private static Timer staticDefaultTimer = new Timer();
	
	public static Timer instance() {
		return staticDefaultTimer;
	}
	
	public void initialize() {
		initialTime = System.nanoTime();
	}
	
	public long currentTime() {
		return (System.nanoTime() - initialTime);
	}

}