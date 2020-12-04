
package singleton;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 =  Singleton.getInstance();
        System.out.println(s1.toString());   
        System.out.println(s2.toString()); 
    }
    
}
