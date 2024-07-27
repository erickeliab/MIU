package counter;

public class TrippleDigit implements CounterHandler{

    private Counter counter;

    private final int incementNumber = 3;

    TrippleDigit(Counter counter){
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + incementNumber);

    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - incementNumber);
        if(counter.getCount() < 100){
            counter.setCounterState(new DoubleDigit(counter));
        }
    }
}
