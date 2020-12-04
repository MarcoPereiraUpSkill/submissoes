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
public class RacaoCao implements IRacao{
    public void visit(Cao cão)  {
        System.out.println("Cão a comer ração de cão");
  }
  public void visit(Gato gato)  {
  }

}
