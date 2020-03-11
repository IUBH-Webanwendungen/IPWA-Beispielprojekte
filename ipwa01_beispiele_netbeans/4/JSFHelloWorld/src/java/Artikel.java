/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author marian.benner
 */
@ManagedBean
@RequestScoped
public class Artikel {

    private String name ="Filzpantoffeln 'Rudolph'";
    
    public Artikel() {
    }

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
