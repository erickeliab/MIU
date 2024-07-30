package with.state;

public class Open extends GateState{
    public Open(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateState newState = new Closing(gateController);
        gateController.setGateState(newState);
    }

    @Override
    public void sensorOpenSignal() {

    }

    @Override
    public void sensorCloseSignal() {

    }

    @Override
    public String getState() {
        return "open";
    }
}
