
package observer;

interface ISubject {
	public void add(Observer observer);
	public void remove(Observer observer);
	public void notifyObservers();
}
