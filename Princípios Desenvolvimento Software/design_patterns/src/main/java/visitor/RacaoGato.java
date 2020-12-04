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
public class RacaoGato implements IRacao {

    public void visit(Cao cão) {
    }

    public void visit(Gato gato) {
        System.out.println("Gato a comer ração de gato");
    }

}
