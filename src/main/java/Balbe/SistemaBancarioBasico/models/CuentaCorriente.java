package Balbe.SistemaBancarioBasico.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CuentaCorriente extends Cuenta{

    public double limiteDescubierto;

    public double getLimiteDescubierto(){
        return limiteDescubierto;
    }

    public CuentaCorriente(String cbu, double saldo, double limiteDescubierto) {
        super(cbu, saldo);
        this.limiteDescubierto = limiteDescubierto;
    }

    
}
