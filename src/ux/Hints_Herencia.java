package ux;

import Ui.JP001_S1_AFP;
import Ui.JP002_S1_RHP;
import Ui.JP003_S1_RH;
import Ui.JP0048_S3_RH;
import Ui.JP009_S2_RH;
import Ui.JP031_S3_RH;
import Ui.JP024_S3_AF;

public class Hints_Herencia {

    private JP001_S1_AFP vista1;
    private JP002_S1_RHP vista2;
    private JP003_S1_RH vista3;
    private JP0048_S3_RH vista4;
    private JP009_S2_RH vista5;
    private JP031_S3_RH vista6;
    private JP024_S3_AF vista7;

    public Hints_Herencia(JP001_S1_AFP vista1) {
        this.vista1 = vista1;
        

        Hints.addHint(vista1.TxtUsuario_JF001_S1_AF, "Ingrese su usuario");
        
        

    }
}
