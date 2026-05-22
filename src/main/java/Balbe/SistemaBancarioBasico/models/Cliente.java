package Balbe.SistemaBancarioBasico.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    public String nombre;
    public String DNI;
    public String email;
    public List<Cuenta> cuentas = new ArrayList<>();
    

    public Cliente(String nombre, String dNI, String email) {
        this.nombre = nombre;
        DNI = dNI;
        this.email = email;
    }


    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

}
