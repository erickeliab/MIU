package without.observer;


public class Application {

	public static void main(String[] args) {
	BuzzerController buzzerController= new BuzzerController();
	Gate gate = new Gate();
	Remote remote = new Remote();
	Sensor sensor = new Sensor();
	GateController gateController = new GateController();
	gateController.setGate(gate);
	gateController.setBuzzerController(buzzerController);
	remote.setGateController(gateController);
	sensor.setGateController(gateController);

	remote.pressButton();
	sensor.sensorOpenSignal();

	remote.pressButton();
	sensor.sensorCloseSignal();

	}
}
