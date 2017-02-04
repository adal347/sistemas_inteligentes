import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Move implements Behavior {
	
	private boolean suppressed = false;

	private LightSensor light;
	
	public Move() {
		super();

		light = new LightSensor( SensorPort.S4 );
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("B1");

		System.out.println(light.getLightValue() + "\n");
		suppressed = false;
	    Motor.A.forward();
	    Motor.B.forward();
	    while( !suppressed )
	    	Thread.yield();
	    Motor.A.stop(); // clean up
	    Motor.B.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
