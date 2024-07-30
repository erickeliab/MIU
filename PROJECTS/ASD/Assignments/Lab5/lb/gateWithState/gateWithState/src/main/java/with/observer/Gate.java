package with.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Gate implements PropertyChangeListener {
    public void open(){
        System.out.println("The gate is opening");
    }

    public void close(){
        System.out.println("The gate is closing");
    }

    public void stop() {
        System.out.println("The gate has stopped");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("opening")){
            open();
        }
        else if (evt.getPropertyName().equals("closing")){
            close();
        }
        else if (evt.getPropertyName().equals("open") || evt.getPropertyName().equals("closed")){
            stop();
        }
    }
}
