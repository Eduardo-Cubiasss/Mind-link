/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author 50369
 */
public class Anuncios {
    private int IDAnuncio;
    private String Titulo;       
    private String Descripcion;
    private byte[] Imagen;       
    private Date Fecha;
    private int IDSecretaria;       
    private int IDAdministrador;        

    public int getIDAnuncio() {
        return IDAnuncio;
    }

    public void setIDAnuncio(int IDAnuncio) {
        this.IDAnuncio = IDAnuncio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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
