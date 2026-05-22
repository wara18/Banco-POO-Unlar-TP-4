package Balbe.SistemaBancarioBasico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import Balbe.SistemaBancarioBasico.models.*;
import Balbe.SistemaBancarioBasico.service.SucursalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SucursalControllers {

    @Autowired
    private SucursalService service; // Spring conecta automáticamente el Service aki

    @GetMapping("/sucursales/{id}/clientes")
    public List<Cliente> verClientesPorSucursal(@PathVariable int id){
        return service.clientesSucursal(id);
    }

    @GetMapping("/clientes/{dni}/cuentas")
    public List<Cuenta> verCuentasPorCliente(@PathVariable String dni){
        return service.cuentasClientes(dni);
    }

    @GetMapping("/cuentas/{cbu}/movimientos")
    public List<Movimiento> verMovPorCuenta(@PathVariable String cbu){
        return service.movPorCuenta(cbu);
    }

}
