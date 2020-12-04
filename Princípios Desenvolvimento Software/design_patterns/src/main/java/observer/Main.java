
package observer;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Subject s = new Subject();
        Observer o1 = new Observer();
        Observer o2 = new Observer();
        s.add(o1);
        s.add(o2);
        s.notifyObservers();
    }
    
}
