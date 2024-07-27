package counter;

public class DoubleDigit implements CounterHandler{

    private Counter counter;

    private final int incementNumber = 2;

    DoubleDigit(Counter counter){
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + incementNumber);
        if(counter.getCount() >= 100){
            counter.setCounterState(new TrippleDigit(counter));
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - incementNumber);
        if(counter.getCount() < 10){
            counter.setCounterState(new SingleDigit(counter));
        }
    }
}
