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
public class Citas {
    private int IDCitas;
    private Date Fecha;
    private int IDTerapeuta;     
    private int IDSecretaria;
    private int IDPaciente;      
    private String Hora;

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    
    public int getIDCitas() {
        return IDCitas;
    }

    public void setIDCitas(int IDCitas) {
        this.IDCitas = IDCitas;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int IDPaciente) {
        this.IDPaciente = IDPaciente;
    }
            
            
}
