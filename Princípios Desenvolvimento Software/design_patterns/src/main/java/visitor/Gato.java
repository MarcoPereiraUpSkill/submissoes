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
public class Gato implements IAnimal {

    public void accept(IRacao visitor) {
        visitor.visit(this);

    }
}
