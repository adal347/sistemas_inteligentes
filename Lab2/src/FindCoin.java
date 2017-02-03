package com.mydomain;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.*;

public class FindCoin extends Thread implements Behavior {
	private LightSensor lightSensor  = new LightSensor(SensorPort.S4)
	static DifferentialPilot pilot;
	private boolean suppressed = false;

	//Codition when to take control
	public boolean takeControl(){
		return lightSensor.readValue() <= 20;
	}

	public void suppress(){
		suppressed = true;
	}

	//What happens when the control is taken
	public void action(){
		//First it stops
		Motor.A.stop();
		Motor.B.stop();
		//Then it beeps
		Sound.playTone(10000,30,50);
        Sound.playTone(10000,30,50);
        Sound.playTone(10000,30,50);
        Sound.playTone(10000,30,50);
        //It moves backwards so we can take the coin
        Motor.A.backward();
        Motor.B.backward();
        Thread.sleep(1000);
        //Then is continues
        pilot.rotate(150);
	    Motor.A.forward();
	    Motor.B.forward();
	}

}
