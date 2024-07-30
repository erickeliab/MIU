package without.observer;

public class GateController {
    private enum GateState {
        OPEN,
        CLOSED,
        OPENING,
        CLOSING;
    }
    private GateState status = GateState.CLOSED;
    private Gate gate;
    private BuzzerController buzzerController;
    public void pressButton(){
        switch (status) {
            case OPEN: {
                gate.close();
                buzzerController.start();
                status = GateState.CLOSING;
                break;
            }
            case CLOSED: {
                gate.open();
                buzzerController.start();
                status = GateState.OPENING;
                break;
            }
            case OPENING: {
                gate.close();
                buzzerController.start();
                status = GateState.CLOSING;
                break;
            }
            case CLOSING: {
                gate.open();
                buzzerController.start();
                status = GateState.OPENING;
                break;
            }
        }
    }

    public void sensorOpenSignal(){
        switch (status) {
            case OPEN: {
                System.out.println("This is not possible");
                break;
            }
            case CLOSED: {
                System.out.println("This is not possible");
                break;
            }
            case OPENING: {
                gate.stop();
                buzzerController.stop();
                status = GateState.OPEN;
                break;
            }
            case CLOSING: {
                System.out.println("This is not possible");
                break;
            }
        }

    }

    public void sensorCloseSignal(){
        switch (status) {
            case OPEN: {
                System.out.println("This is not possible");
            }
            case CLOSED: {
                System.out.println("This is not possible");
            }
            case OPENING: {
                System.out.println("This is not possible");
            }
            case CLOSING: {
                gate.stop();
                buzzerController.stop();
                status = GateState.CLOSED;
            }
        }
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public void setBuzzerController(BuzzerController buzzerController) {
        this.buzzerController = buzzerController;
    }
}
