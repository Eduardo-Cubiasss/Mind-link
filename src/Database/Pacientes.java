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
public class Pacientes {
    private int IDpaciente;
    private String nombre;
    private int Fnacimiento;
    private String DUI;
    private String Mensajito;
    private String Apellido;
    private boolean señal;

    public boolean isSeñal() {
        return señal;
    }

    public void setSeñal(boolean señal) {
        this.señal = señal;
    }
    
    
    
    public int getIDpaciente() {
        return IDpaciente;
    }

    public void setIDpaciente(int IDpaciente) {
        this.IDpaciente = IDpaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFnacimiento() {
        return Fnacimiento;
    }

    public void setFnacimiento(int Fnacimiento) {
        this.Fnacimiento = Fnacimiento;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getMensajito() {
        return Mensajito;
    }

    public void setMensajito(String Mensajito) {
        this.Mensajito = Mensajito;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
}
