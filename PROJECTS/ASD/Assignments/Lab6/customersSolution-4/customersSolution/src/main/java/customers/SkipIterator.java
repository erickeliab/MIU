package customers;

import java.util.Iterator;
import java.util.List;

public class SkipIterator implements Iterator<Customer> {
	private final List<Customer> list;
    private int position;

    public SkipIterator(List<Customer> list) {
        this.list = list;
        this.position = 0;
    }

    public Iterator<Customer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return position <= list.size();
    }

    @Override
    public Customer next() {
    	Customer cust = list.get(position);
    	position = position+2;
        return cust;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
