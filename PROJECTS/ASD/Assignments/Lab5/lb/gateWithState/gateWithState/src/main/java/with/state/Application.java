package with.state;


public class Application {

    public static void main(String[] args) {
        Remote remote = new Remote();
        Sensor sensor = new Sensor();
        GateController gateController = new GateController();

        remote.setGateController(gateController);
        sensor.setGateController(gateController);

        BuzzerController buzzerController = new BuzzerController();
        Gate gate = new Gate();

        gateController.addPropertyChangeListener(buzzerController);
        gateController.addPropertyChangeListener(gate);

        GateState newState = new Closed(gateController);
        gateController.setGateState(newState);

        remote.pressButton();
        remote.pressButton();
        remote.pressButton();
        sensor.sensorCloseSignal();

        remote.pressButton();
        sensor.sensorOpenSignal();

    }
}
