package with.state;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GateController {

    private PropertyChangeSupport support;

    private GateState gateState;

    public GateController() {
        support = new PropertyChangeSupport(this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void pressButton(){
        String oldState = gateState.getState();
        gateState.pressButton();
        String newState = gateState.getState();
        System.out.println("pressbutton - old: "+oldState+" , new: "+newState);
        if (!oldState.equals(newState)) {
            support.firePropertyChange(newState, oldState, newState);
        }
    }

    public void sensorOpenSignal(){
        String oldState = gateState.getState();
        gateState.sensorOpenSignal();
        String newState = gateState.getState();
        System.out.println("sensor open signal- old: "+oldState+" , new: "+newState);
        if (!oldState.equals(newState))
            support.firePropertyChange(newState, oldState, newState);
    }

    public void sensorCloseSignal(){
        String oldState = gateState.getState();
        gateState.sensorCloseSignal();
        String newState = gateState.getState();
        System.out.println("sensor close signal- old: "+oldState+" , new: "+newState);
        if (!oldState.equals(newState))
            support.firePropertyChange(newState, oldState, newState);
    }

    public GateState getGateState() {
        return gateState;
    }

    public void setGateState(GateState gateState) {
        this.gateState = gateState;
    }
}
