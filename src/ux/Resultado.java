/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

/**
 *
 * @author 50369
 */
public class Resultado {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private int IDUsuario;
    private String Asunto;

    public Resultado(int idPaciente, String nombre, String apellido) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    // Define los getters y setters para los atributos

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }
    
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
