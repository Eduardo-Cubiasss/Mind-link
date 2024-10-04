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
public class Comentarios {
    private int IDComentario;
    private String Mensaje;
    private Date Fecha;
    private int IDPaciente;

    public int getIDComentario() {
        return IDComentario;
    }

    public void setIDComentario(int IDComentario) {
        this.IDComentario = IDComentario;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int IDPaciente) {
        this.IDPaciente = IDPaciente;
    }
            
            
            
}
