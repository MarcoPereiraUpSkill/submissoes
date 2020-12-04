
package observer;

import java.util.ArrayList;
import java.util.List;

class Subject implements ISubject {

    private List<Object> observers = new ArrayList();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Object o : this.observers) {
            ((Observer) o).updateSubject(this);
        }
    }
    	public String getState() {
		return "Estou vivo";
	}
}
