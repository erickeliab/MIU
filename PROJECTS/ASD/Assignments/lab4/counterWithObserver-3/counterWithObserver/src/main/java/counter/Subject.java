package counter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Subject {
  private Collection<Observer> observerlist = new ArrayList<Observer>();
  
  public void addObserver(Observer observer){
	  observerlist.add(observer);
  }
  
  public void donotify(int countervalue){
	  Iterator<Observer> iterator = observerlist.iterator();
	  while(iterator.hasNext()){
		  Observer observer = iterator.next();
		  observer.update(countervalue);
	  }
  }
  
}
