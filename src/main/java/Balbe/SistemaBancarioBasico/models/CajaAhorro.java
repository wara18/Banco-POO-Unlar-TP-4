package Balbe.SistemaBancarioBasico.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CajaAhorro extends Cuenta {

    public double tasaInteres;
    
    public void aplicarInteres(){
        
    }

    public CajaAhorro(String cbu, double saldo, double tasaInteres) {
        super(cbu, saldo);
        this.tasaInteres = tasaInteres;
    }


    
}
