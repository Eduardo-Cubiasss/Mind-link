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
public class Resultados {
    private int IDResultados;
    private String Resultados;
    private int IDPrueba;
    private int IDUsuario;
    private String Asunto;

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
    
    

    public int getIDResultados() {
        return IDResultados;
    }

    public void setIDResultados(int IDResultados) {
        this.IDResultados = IDResultados;
    }

    public String getResultados() {
        return Resultados;
    }

    public void setResultados(String Resultados) {
        this.Resultados = Resultados;
    }

    public int getIDPrueba() {
        return IDPrueba;
    }

    public void setIDPrueba(int IDPrueba) {
        this.IDPrueba = IDPrueba;
    }
    
    
}
