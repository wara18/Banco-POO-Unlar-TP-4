package Balbe.SistemaBancarioBasico.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Cuenta {

    public String cbu;
    public double saldo;
    public List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta(String cbu, double saldo) {
        this.cbu = cbu;
        this.saldo = saldo;
    }
    public void extraer(int monto){
        saldo-=monto;
    }
    public void depositar(int monto){
        saldo+=monto;
    }
    public double consultarSaldo(){
        return saldo;
    }

    public void agregarMov(Movimiento movimiento){
        movimientos.add(movimiento);
    }

}
