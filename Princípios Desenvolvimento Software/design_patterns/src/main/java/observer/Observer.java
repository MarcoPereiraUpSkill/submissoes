
package observer;

public class Observer implements IObserver {

    public Observer() {
    }
  
    public void updateSubject(Subject s) {
        System.out.println(s.getState());
}
}
