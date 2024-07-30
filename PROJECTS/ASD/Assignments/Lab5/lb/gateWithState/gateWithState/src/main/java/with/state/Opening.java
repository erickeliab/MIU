package with.state;

public class Opening extends GateState{
    public Opening(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateState newState = new Idle(gateController, "opening");
        gateController.setGateState(newState);
    }

    @Override
    public void sensorOpenSignal() {
        GateState newState = new Open(gateController);
        gateController.setGateState(newState);
    }

    @Override
    public void sensorCloseSignal() {

    }

    @Override
    public String getState() {
        return "opening";
    }
}

