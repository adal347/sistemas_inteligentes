import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.*;

public class FindCoin extends Thread implements Behavior {
	private LightSensor lightSensor;
	private DifferentialPilot pilot;
	private boolean suppressed = false;

	public FindCoin(SensorPort port, DifferentialPilot pilot) {
		super();
		lightSensor = new LightSensor( port );
		this.pilot = pilot;
	}

	//Codition when to take control
	public boolean takeControl(){
		if (lightSensor.readValue() <= 35) {
			return true;
		} else {

			return false;
		}
	}

	public void suppress(){
		suppressed = true;
	}

	//What happens when the control is taken
	public void action(){
		//First it stops
		System.out.println("B2");

		System.out.println(lightSensor.getLightValue() + "\n");
		Motor.A.stop();
		Motor.B.stop();
		//Then it beeps
		Sound.playTone(10000,30);
        Sound.playTone(10000,30);
        Sound.playTone(10000,30);
        Sound.playTone(10000,30);
        //It moves backwards so we can take the coin
        Motor.A.backward();
        Motor.B.backward();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Then is continues
        pilot.rotate(150);
        while( !suppressed )
            Thread.yield();

          Motor.A.stop();
          Motor.B.stop();
	}

}
