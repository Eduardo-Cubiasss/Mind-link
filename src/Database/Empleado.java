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
public class Empleado {
    private int IdEmpleado;
    private String Username;
    private String Contraseña;
    private String Correo;
    private int nivel;
    private String nombre;
    private String ActividadLab;
    private int Edad;
    private String DUI;
    private byte[] FotoPerfil;
    private int IDUsuario;
    private boolean señal;

    public boolean isSeñal() {
        return señal;
    }

    public void setSeñal(boolean señal) {
        this.señal = señal;
    }
    
    
    public byte[] getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(byte[] FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividadLab() {
        return ActividadLab;
    }

    public void setActividadLab(String ActividadLab) {
        this.ActividadLab = ActividadLab;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
