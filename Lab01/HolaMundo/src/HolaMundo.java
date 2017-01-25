import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class HolaMundo {
	
	public static void avanza(int ms) throws InterruptedException {
		int i = 0;
		UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
		ultrasonicSensor.continuous();
		
		while(i < ms){
			float d=ultrasonicSensor.getDistance();
			if(d <= 23){
				alto();
				retrocede(1500);
				izquierda(2000);
				movimiento();
				break;
			} else {
				Motor.A.forward();
				Motor.B.forward();
				Thread.sleep(1);
			}
			i++;
			
		}
	}
	
	public static void retrocede(int ms) throws InterruptedException {
		Motor.A.backward();
		Motor.B.backward();
		Thread.sleep(ms);
	}
	
	public static void alto() {
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public static void izquierda(int ms) throws InterruptedException {
		//Motor.B.forward();
		Motor.A.stop();
		Thread.sleep(ms);
	}
	

	
	public static void derecha(int ms) throws InterruptedException {
		Motor.B.stop();
		Thread.sleep(ms);
	}
	
	public static void movimiento() throws InterruptedException{
		avanza(100);
		izquierda(2000);
		avanza(150);
		derecha(2000);
		avanza(150);
		derecha(2000);
		avanza(100);
		
	}
	
	public static void main(String args[]) throws InterruptedException{
		
		UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
		
		
		ultrasonicSensor.continuous();
		movimiento();
		alto();
		
	}
}