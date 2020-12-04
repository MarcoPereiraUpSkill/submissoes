
package strategy;

public abstract class Atleta {

    public int calcularSalario() {
        return this.mc.calcularSalario();
    };

    private final MetodoCalculo mc;

    public Atleta(MetodoCalculo mc) {
        this.mc = mc;
    }
    
    
}
