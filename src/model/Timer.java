package model;

import main.InputParse;

public class Timer {
	
	private long initialTime;
	private InputParse settings = InputParse.instance();

	private Timer(){}
	
	private static Timer staticDefaultTimer = new Timer();
	
	public static Timer instance() {
		return staticDefaultTimer;
	}
	
	public void initialize() {
		initialTime = System.currentTimeMillis();
	}
	
	public long currentTick() {
		return (System.currentTimeMillis() - initialTime) / settings.millisecond_to_tick_ratio;
	}

}