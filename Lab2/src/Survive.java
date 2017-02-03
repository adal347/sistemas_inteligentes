package com.mydomain;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.*;

public class Survive extends Thread implements Behavior {
	
	static DifferentialPilot pilot;
	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		
		LightSensor light = new LightSensor(SensorPort.S4);
		Motor.A.forward();
		Motor.B.forward();
	    while (true) {
	    	if (light.readValue() < 40){
	    		Motor.A.forward();
	    		Motor.B.forward();
	    	}else{
	    		Motor.A.backward();
	    		Motor.B.backward();
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		pilot.rotate(180);
	    		Motor.A.forward();
	    		Motor.B.forward();
	    	}
	    }
		
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Survive survivor = new Survive();
		survivor.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	
	}

}