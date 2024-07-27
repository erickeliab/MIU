package counter;

public class SingleDigit implements CounterHandler{

    private Counter counter;

    private final int incementNumber = 1;

    SingleDigit(Counter counter){
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + incementNumber);
        if(counter.getCount() >= 10){
            counter.setCounterState(new DoubleDigit(counter));
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - incementNumber);
//        if(counter.getCount() >= 10){
//            counter.setCounterState(new DoubleDigit(counter));
//        }
    }
}
