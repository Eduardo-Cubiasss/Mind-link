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
public class Secretarias {
    private int IDSecretaria;
    private String Nombre;
    private String Apellido;
    private double Salario;
    private Date FNacimiento;
    private String DUI;
    private int IDTipoUsuario;
    private int IDActividadLaboral;
    private int IDGenero;
    private int IDClinica;
    private int IDUsuario;

    public int getIDSecretaria() {
        return IDSecretaria;
    }

    public void setIDSecretaria(int IDSecretaria) {
        this.IDSecretaria = IDSecretaria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public Date getFNacimiento() {
        return FNacimiento;
    }

    public void setFNacimiento(Date FNacimiento) {
        this.FNacimiento = FNacimiento;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public int getIDTipoUsuario() {
        return IDTipoUsuario;
    }

    public void setIDTipoUsuario(int IDTipoUsuario) {
        this.IDTipoUsuario = IDTipoUsuario;
    }

    public int getIDActividadLaboral() {
        return IDActividadLaboral;
    }

    public void setIDActividadLaboral(int IDActividadLaboral) {
        this.IDActividadLaboral = IDActividadLaboral;
    }

    public int getIDGenero() {
        return IDGenero;
    }

    public void setIDGenero(int IDGenero) {
        this.IDGenero = IDGenero;
    }

    public int getIDClinica() {
        return IDClinica;
    }

    public void setIDClinica(int IDClinica) {
        this.IDClinica = IDClinica;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
  
    
}
