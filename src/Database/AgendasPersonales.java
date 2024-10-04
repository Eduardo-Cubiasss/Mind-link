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
public class AgendasPersonales {
    private int IDAgendaPersonal;
    private String Contenido;
    private Date Fecha;
    private int IDPaciente;

    public int getIDAgendaPersonal() {
        return IDAgendaPersonal;
    }

    public void setIDAgendaPersonal(int IDAgendaPersonal) {
        this.IDAgendaPersonal = IDAgendaPersonal;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
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
