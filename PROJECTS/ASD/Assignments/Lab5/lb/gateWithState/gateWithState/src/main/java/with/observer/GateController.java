package with.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GateController {
    private enum GateState {
        OPEN,
        CLOSED,
        OPENING,
        CLOSING;
    }
    private GateState status = GateState.CLOSED;

    private PropertyChangeSupport support;

    public GateController() {
        support = new PropertyChangeSupport(this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void pressButton(){
        switch (status) {
            case OPEN: {
                status = GateState.CLOSING;
                support.firePropertyChange("closing", GateState.OPEN, status);
                break;
            }
            case CLOSED: {
                status = GateState.OPENING;
                support.firePropertyChange("opening", GateState.CLOSED, status);
                break;
            }
            case OPENING: {
                status = GateState.CLOSING;
                support.firePropertyChange("closing", GateState.OPENING, status);
                break;
            }
            case CLOSING: {
                status = GateState.OPENING;
                support.firePropertyChange("opening", GateState.CLOSING, status);
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
                status = GateState.OPEN;
                support.firePropertyChange("open", GateState.OPENING, status);

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
                status = GateState.CLOSED;
                support.firePropertyChange("closed", GateState.CLOSING, status);
            }
        }
    }
}
