
package adapter;

public class Adapter implements IAdapter{
    private IAdaptee a;
    
    public Adapter(IAdaptee a) {
        this.a = a;
    }
    
    public String getNewPassword(){
      return a.generatePassword();
}
}
