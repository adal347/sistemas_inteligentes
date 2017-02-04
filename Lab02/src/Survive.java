import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.*;

public class Survive extends Thread implements Behavior {
	
	private DifferentialPilot pilot;
	private boolean suppressed = false;
	private LightSensor light;
	
	public Survive(SensorPort port, DifferentialPilot pilot) {
		super();
		light = new LightSensor( port );
		this.pilot = pilot;
	}


	@Override
	public boolean takeControl() {
		if (light.readValue() > 40){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void action() {
		System.out.println("B3");

		System.out.println(light.getLightValue() + "\n");
		Motor.A.backward();
	    Motor.B.backward();
	    try {
	    	Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    pilot.rotate(180);
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}
}