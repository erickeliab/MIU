package with.observer;

public class Sensor {
    private GateController gateController;
    public void sensorOpenSignal(){
        gateController.sensorOpenSignal();
    }

    public void sensorCloseSignal(){
        gateController.sensorCloseSignal();
    }

    public void setGateController(GateController gateController) {
        this.gateController = gateController;
    }
}
