import java.util.Objects;

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

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return ramSize == computer.ramSize && processorSpeed == computer.processorSpeed &&
                Objects.equals(processor , computer.processor) && Objects.equals(manufacturer , computer.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, processor, getRamSize(), getProcessorSpeed());
    }
}
