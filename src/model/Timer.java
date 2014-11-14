package model;

import io.SettingsHolder;

/*Obsolete class
 * */
public class Timer {
	
	private long initialTime;
	private SettingsHolder settings = SettingsHolder.getInstance();
	private int msTick = 100;//Integer.parseInt(settings.getProperty("millisecond_to_tick_ratio"));

	private Timer(){}
	
	private static Timer staticDefaultTimer = new Timer();
	
	public static Timer instance() {
		return staticDefaultTimer;
	}
	
	public void initialize() {
		initialTime = System.currentTimeMillis();
	}
	
	public long currentTick() {
		return (System.currentTimeMillis() - initialTime) / msTick;
	}

}