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
public class Usuarios {
    private int IDUsuario;
    private String UserName;
    private String Contraseña;
    private byte[] FPerfil;
    private int PrimerUso;
    private int IDContacto;
    private int acceso;
    private String contrafake;
    private int resultado;
    private String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    

    public String getContrafake() {
        return contrafake;
    }

    public void setContrafake(String contrafake) {
        this.contrafake = contrafake;
    }

    
    public int getPrimerUso() {
        return PrimerUso;
    }

    public void setPrimerUso(int PrimerUso) {
        this.PrimerUso = PrimerUso;
    }

    
    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
     
    
    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }


    public int getIDContacto() {
        return IDContacto;
    }

    public void setIDContacto(int IDContacto) {
        this.IDContacto = IDContacto;
    }

    public byte[] getFPerfil() {
        return FPerfil;
    }

    public void setFPerfil(byte[] FPerfil) {
        this.FPerfil = FPerfil;
    }
    
    
}
