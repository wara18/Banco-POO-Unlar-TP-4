package Balbe.SistemaBancarioBasico.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import Balbe.SistemaBancarioBasico.models.*;
import jakarta.annotation.PostConstruct;

@Service
public class SucursalService {

    private final Balbe.SistemaBancarioBasico.SistemaBancarioBasicoApplication sistemaBancarioBasicoApplication;
    private List<Sucursal> sucursales = new ArrayList<>();

    SucursalService(Balbe.SistemaBancarioBasico.SistemaBancarioBasicoApplication sistemaBancarioBasicoApplication) {
        this.sistemaBancarioBasicoApplication = sistemaBancarioBasicoApplication;
    }

    @PostConstruct
    public void cargarDatosIniciales(){

        Sucursal s1 = new Sucursal(1,"Centro", "Av. Mitre"); // Primera sucursal

        //Ahora vamos a crear unas cuentas y sus clientes
        Cuenta c1 = new CuentaCorriente("123", 30000, 2000);
        c1.agregarMov(new Movimiento(LocalDate.now(), 2000, "Deposito"));
        Cuenta c1_2 = new CajaAhorro("321", 2000, 10);
        c1_2.agregarMov(new Movimiento(LocalDate.now(), 1000, "Retiro"));
        Cuenta c1_3 = new CuentaCorriente("231", 100000, 100000);
        Cuenta c1_4 = new CajaAhorro("123123", 22000, 120);
        Cliente cl1 = new Cliente("Pacho", "58273712", "pachitoxd@gmail.com");
        Cliente cl1_2 = new Cliente("Wara", "1231414", "warita@gmail.com");
        Cliente cl1_3 = new Cliente("Nune", "531244123", "chanty@gmail.com");
        cl1.agregarCuenta(c1);
        cl1.agregarCuenta(c1_4);
        cl1_2.agregarCuenta(c1_2);
        cl1_3.agregarCuenta(c1_3);
        // Agrego clientes a la sucursal 1
        s1.agregarCliente(cl1);
        s1.agregarCliente(cl1_2);
        s1.agregarCliente(cl1_3);

        Sucursal s2 = new Sucursal(2,"Norte", "Calle S/N"); // Segunda sucursal
        Cliente cl2 = new Cliente("Sotelo", "58312712", "ekexd@gmail.com");
        Cliente cl2_2 = new Cliente("Adrian", "51123452", "kekegod@gmail.com");
        s2.agregarCliente(cl2);
        s2.agregarCliente(cl2_2);

        sucursales.add(s1);
        sucursales.add(s2);
        
    }

    public List<Cliente> clientesSucursal(int idSucursal) {
        return sucursales.get(idSucursal).getClientes();
    }

    public List<Cuenta> cuentasClientes(String dni) {
        return sucursales.stream()
                        .flatMap(s -> s.getClientes().stream())
                        .filter(s -> Objects.equals(s.getDNI(), dni))
                        .findFirst()
                        .map(Cliente::getCuentas)
                        .orElse(List.of());
    }

    public List<Movimiento> movPorCuenta(String cbu) {
        return sucursales.stream()
                        .flatMap(s -> s.getClientes().stream())
                        .flatMap(s -> s.getCuentas().stream())
                        .filter(s -> Objects.equals(cbu, s.getCbu()))
                        .findFirst()
                        .map(Cuenta::getMovimientos)
                        .orElse(List.of());
    }



}
