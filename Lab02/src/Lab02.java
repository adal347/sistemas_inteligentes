import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Lab02 {
	
	public static void main(String[] args) {
		DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
		Behavior b1 = new Move();
		Behavior b2 = new FindCoin(SensorPort.S4, pilot);
		Behavior b3 = new Survive(SensorPort.S4, pilot);
		Behavior[] bArray = {b1, b2, b3};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}

}
