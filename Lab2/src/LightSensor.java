package com.mydomain;

import lejos.nxt.*;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.*;
public class HelloWorld extends Thread{
	
	static DifferentialPilot pilot;
	
	public static void main(String[] args) throws InterruptedException {
		HelloWorld hola = new HelloWorld();
		hola.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
		
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
	    		Thread.sleep(1000);
	    		pilot.rotate(180);
	    		Motor.A.forward();
	    		Motor.B.forward();
	    	}
	    }
	}
	
}