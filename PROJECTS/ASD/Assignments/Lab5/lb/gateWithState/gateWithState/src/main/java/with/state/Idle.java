package with.state;

public class Idle extends GateState{
    private String oldState;
    public Idle(GateController gateController, String oldState) {
        super(gateController);
        this.oldState=oldState;
    }

    @Override
    public void pressButton() {
        if(oldState.equals("opening")){
            GateState newState = new Closing(gateController);
            gateController.setGateState(newState);
        }
        else if(oldState.equals("closing")){
            GateState newState = new Opening(gateController);
            gateController.setGateState(newState);
        }
    }

    @Override
    public void sensorOpenSignal() {

    }

    @Override
    public void sensorCloseSignal() {

    }

    @Override
    public String getState() {
        return "idle";
    }
}
