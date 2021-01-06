
package com.mycompany.lista_telefonica;

public class MainListaTelefonica {

    public static void main(String[] args) {
        ListaTelefonica lista = new ListaTelefonica();
        
        Contacto contacto1 = new Contacto("Manuel", 933333333, "manuel@exemplo.pt");
        Contacto contacto2 = new Contacto("António", 966666666, "antonio@exemplo.pt");
        Contacto contacto3 = new Contacto("Joaquim", 911111111, "joaquim@exemplo.pt");
        
        lista.novoContacto(contacto1);
        lista.novoContacto(contacto2);
        lista.novoContacto(contacto3);
        
        for(Contacto contacto : lista.getContactos()){
            System.out.println(contacto);
        }
    }
    
}
