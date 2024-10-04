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
public class Articulos {
    private int IDArticulo;
    private String Titulo;
    private String Descripcion;
    private byte[] Imagen;
    private Date Fecha;
    private int IDTerapeuta;
    private String NRandom;

    public String getNRandom() {
        return NRandom;
    }

    public void setNRandom(String NRandom) {
        this.NRandom = NRandom;
    }
    
    
    public int getIDArticulo() {
        return IDArticulo;
    }

    public Articulos(int IDArticulo) {
        this.IDArticulo = IDArticulo;
    }
    

    public void setIDArticulo(int IDArticulo) {
        this.IDArticulo = IDArticulo;
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

    public int getIDTerapeuta() {
        return IDTerapeuta;
    }

    public void setIDTerapeuta(int IDTerapeuta) {
        this.IDTerapeuta = IDTerapeuta;
    }
     public Articulos() {
        // Puedes inicializar valores predeterminados si es necesario
    }
  
    
}
