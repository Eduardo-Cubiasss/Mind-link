/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author 50369
 */
public class Contactos {

    private int IDContacto;
    private String Correo;
    private String CorreoVal;
    private String NumTelefonico;
    private String NumTelefonicoVal;
    private String NumeroRandom;

    public String getNumeroRandom() {
        return NumeroRandom;
    }

    public void setNumeroRandom(String NumeroRandom) {
        this.NumeroRandom = NumeroRandom;
    }

    public String getCorreoVal() {
        return CorreoVal;
    }

    public void setCorreoVal(String CorreoVal) {
        this.CorreoVal = CorreoVal;
    }

    public String getNumTelefonicoVal() {
        return NumTelefonicoVal;
    }

    public void setNumTelefonicoVal(String NumTelefonicoVal) {
        this.NumTelefonicoVal = NumTelefonicoVal;
    }

    public int getIDContacto() {
        return IDContacto;
    }

    public void setIDContacto(int IDContacto) {
        this.IDContacto = IDContacto;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNumTelefonico() {
        return NumTelefonico;
    }

    public void setNumTelefonico(String NumTelefonico) {
        this.NumTelefonico = NumTelefonico;
    }

}
