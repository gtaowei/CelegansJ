package model;

import io.SettingsHolder;

public class Timer {
	
	private SettingsHolder settings = SettingsHolder.getInstance();
	private static int currentTick;
	
	private Timer(){}
	
	private static Timer staticDefaultTimer = new Timer();
	
	public static Timer instance() {
		return staticDefaultTimer;
	}
	
	public void init() {
		currentTick = 0;
	}
	
	public void incr() {
		currentTick++;
	}
	
	public static int currentTick() {
		return currentTick;
	}

}