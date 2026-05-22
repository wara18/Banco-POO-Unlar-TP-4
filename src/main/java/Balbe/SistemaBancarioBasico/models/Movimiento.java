package Balbe.SistemaBancarioBasico.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movimiento {

    LocalDate fecha;
    double monto;
    String detalle;

}
