
package com.mycompany.lista_telefonica;

import java.util.ArrayList;
import java.util.Objects;

public class ListaTelefonica {
    private ArrayList<Contacto> contactos;
    
    private static final ArrayList<Contacto> CONTACTOS_POR_OMISSAO = new ArrayList<>();
    
    public ListaTelefonica(){
        contactos = CONTACTOS_POR_OMISSAO;
    }

    public ListaTelefonica(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "ListaTelefonica{" + "contactos=" + contactos + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaTelefonica other = (ListaTelefonica) obj;
        return Objects.equals(this.contactos, other.contactos);
    }
    
    public void novoContacto(Contacto novoContacto){
        contactos.add(novoContacto);
    }
}
