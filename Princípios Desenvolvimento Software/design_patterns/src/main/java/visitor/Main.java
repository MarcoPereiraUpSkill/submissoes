/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

/**
 *
 * @author nunocastro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Cao cao = new Cao();
        cao.accept(new RacaoCao());

        Gato gato = new Gato();
        gato.accept(new RacaoGato());

        Agua visitor = new Agua();
        cao.accept(visitor);
        gato.accept(visitor);

    }

}
