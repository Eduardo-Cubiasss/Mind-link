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
public class Clinica {
     private String IDClinica;
    private String NombreClinica;
    private String Ubicacion;
    private String Dueño;
    private String Descripcion;
    private String Logo;

    public String getIDClinica() {
        return IDClinica;
    }

    public void setIDClinica(String IDClinica) {
        this.IDClinica = IDClinica;
    }

    public String getNombreClinica() {
        return NombreClinica;
    }

    public void setNombreClinica(String NombreClinica) {
        this.NombreClinica = NombreClinica;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getDueño() {
        return Dueño;
    }

    public void setDueño(String Dueño) {
        this.Dueño = Dueño;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }
    
}
