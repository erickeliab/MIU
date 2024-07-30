package with.state;

public class Closed extends GateState{
    public Closed(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateState newState = new Opening(gateController);
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
        return "closed";
    }
}
