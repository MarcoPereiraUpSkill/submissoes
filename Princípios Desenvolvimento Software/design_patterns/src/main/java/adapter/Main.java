
package adapter;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IAdaptee adaptee = new Adaptee();
        IAdapter adapter = new Adapter(adaptee);
        System.out.println(adapter.getNewPassword());
    }
    
}
