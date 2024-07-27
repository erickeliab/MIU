package without.observer;

public class Remote {
    private GateController gateController;
    public void pressButton(){
        gateController.pressButton();
    }

    public void setGateController(GateController gateController) {
        this.gateController = gateController;
    }
}
