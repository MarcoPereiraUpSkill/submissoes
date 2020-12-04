
package strategy;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MetodoCalculo mc = new Premio();
        Atleta a = new Profissional(mc);
        System.out.println(a.calcularSalario());
    }
    
}
