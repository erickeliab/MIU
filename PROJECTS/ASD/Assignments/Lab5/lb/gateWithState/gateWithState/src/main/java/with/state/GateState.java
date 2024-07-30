package with.state;

public abstract class GateState {
    protected GateController gateController;
    protected BuzzerController buzzerController;

    public GateState(GateController gateController) {
        this.gateController = gateController;
    }

    public abstract void pressButton();
    public abstract void sensorOpenSignal();
    public abstract void sensorCloseSignal();
    public abstract String getState();
}
