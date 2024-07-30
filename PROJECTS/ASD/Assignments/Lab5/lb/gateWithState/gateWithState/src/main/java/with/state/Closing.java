package with.state;

public class Closing extends GateState{
    public Closing(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateState newState = new Idle(gateController, "closing");
        gateController.setGateState(newState);
    }

    @Override
    public void sensorOpenSignal() {

    }

    @Override
    public void sensorCloseSignal() {
        GateState newState = new Closed(gateController);
        gateController.setGateState(newState);
    }

    @Override
    public String getState() {
        return "closing";
    }
}

