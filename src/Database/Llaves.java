/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Date;

/**
 *
 * @author 50369
 */
public class Llaves {
    private int IDLlave;
    private String Llave;
    private Date Fecha;
    private int IDPrueba;

    public int getIDLlave() {
        return IDLlave;
    }

    public void setIDLlave(int IDLlave) {
        this.IDLlave = IDLlave;
    }

    public String getLlave() {
        return Llave;
    }

    public void setLlave(String Llave) {
        this.Llave = Llave;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getIDPrueba() {
        return IDPrueba;
    }

    public void setIDPrueba(int IDPrueba) {
        this.IDPrueba = IDPrueba;
    }
    
    
}
