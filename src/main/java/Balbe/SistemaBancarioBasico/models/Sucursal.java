package Balbe.SistemaBancarioBasico.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

    private int id;
    private String nombreSucursal;
    private String direccion;
    private List<Cliente> clientes = new ArrayList<>();
    
    public Sucursal(int id, String nombreSucursal, String direccion) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    
    
    

}
