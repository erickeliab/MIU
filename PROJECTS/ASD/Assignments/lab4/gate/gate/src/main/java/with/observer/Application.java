package with.observer;


public class Application {

	public static void main(String[] args) {
	Remote remote = new Remote();
	Sensor sensor = new Sensor();
	GateController gateController = new GateController();
	remote.setGateController(gateController);
	sensor.setGateController(gateController);
		BuzzerController buzzerController= new BuzzerController();
		Gate gate = new Gate();

		gateController.addPropertyChangeListener(buzzerController);
		gateController.addPropertyChangeListener(gate);

		remote.pressButton();
	sensor.sensorOpenSignal();

	remote.pressButton();
	sensor.sensorCloseSignal();

	}
}
