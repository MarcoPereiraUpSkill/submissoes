
package builder;

public class Main {

    private static String NVL(Object o, String s) {
        if (o == null) {
            return s;
        }
        return o.toString();
    }

    //Utilizando o padrão.
    public static void main(String[] args) {
        // TODO code application logic here
        Bicicleta b = new Bicicleta.Builder().modelo("abc").build();
        b.setSelim(new Selim());
        System.out.println(b.toString());
        System.out.println("Modelo: " + NVL(b.getModelo(), ""));
        System.out.println("Quadro: " + NVL(b.getQuadro(), ""));
        System.out.println("Selim: " + NVL(b.getSelim(), ""));
        System.out.println("Roda Frontal: " + NVL(b.getRodaFrontal(), ""));
        System.out.println("Roda Traseira: " + NVL(b.getRodaTraseira(), ""));
    }
}
