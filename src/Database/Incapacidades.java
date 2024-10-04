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
public class Incapacidades {
    private int IDIncapacidad;
    private Date Fecha;
    private String Mensaje;
    private String Asunto;
    private int IDTerapeuta;
    private int IDSecretaria;
    private int IDAdministrador;

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    
    public int getIDIncapacidad() {
        return IDIncapacidad;
    }

    public void setIDIncapacidad(int IDIncapacidad) {
        this.IDIncapacidad = IDIncapacidad;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public int getIDTerapeuta() {
        return IDTerapeuta;
    }

    public void setIDTerapeuta(int IDTerapeuta) {
        this.IDTerapeuta = IDTerapeuta;
    }

    public int getIDSecretaria() {
        return IDSecretaria;
    }

    public void setIDSecretaria(int IDSecretaria) {
        this.IDSecretaria = IDSecretaria;
    }

    public int getIDAdministrador() {
        return IDAdministrador;
    }

    public void setIDAdministrador(int IDAdministrador) {
        this.IDAdministrador = IDAdministrador;
    }
    
    
    
}
