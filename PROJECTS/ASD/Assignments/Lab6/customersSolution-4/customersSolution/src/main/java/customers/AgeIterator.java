package customers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator implements Iterator<Customer> {
	private List<Customer> list;
	private Iterator<Customer> internalIterator;

	public AgeIterator(List<Customer> list) {
		this.list = new ArrayList<>(list);    
	    Collections.sort(this.list, Comparator.comparingInt(Customer::getAge));//sort the internal list
	    internalIterator = this.list.iterator();
	}

	public Iterator<Customer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return internalIterator.hasNext();
	}

	@Override
	public Customer next() {
		return internalIterator.next();
	}

	@Override
	public void remove() {
		internalIterator.remove();
	}

}
