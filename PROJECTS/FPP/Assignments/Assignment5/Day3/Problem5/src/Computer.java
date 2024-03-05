public class Computer {

    String manufacturer;
    String processor;
    int ramSize;
    double processorSpeed;

    Computer(String manufacturer, String processor, int ramSize, double processorSpeed){
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.processorSpeed = processorSpeed;
    }

    public int getRamSize() {
        return ramSize;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public double computePower(){
        return ramSize * processorSpeed;
    }

    public String toString(){

        return "[Manufacturer : "+ manufacturer + ", Processor : "+ processor + ", Ram Size : " + ramSize + ", Processor Speed" + processorSpeed + "]";
    }
}
