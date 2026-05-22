package Balbe.SistemaBancarioBasico.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CajeroAutomatico {

    public String ubicacion;

    public double consultarSaldo(Cuenta cuenta){
        return cuenta.getSaldo();
    }

}
