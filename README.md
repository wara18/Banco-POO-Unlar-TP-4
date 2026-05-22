# 🏦 Sistema Bancario Básico - Banco UNLaR

API REST desarrollada con Spring Boot que simula un sistema bancario básico con persistencia en memoria.

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3.5
- Maven
- Lombok

---

## 📦 Estructura del Proyecto

```
com.banco.unlar
├── models
│   ├── Cuenta.java           (abstracta)
│   ├── CajaAhorro.java
│   ├── CuentaCorriente.java
│   ├── Cliente.java
│   ├── Sucursal.java
│   ├── Movimiento.java
│   └── CajeroAutomatico.java
├── service
│   └── SucursalService.java
└── controllers
    └── SucursalControllers.java
```

---

## 🔗 Relaciones POO

| Relación | Entre |
|---|---|
| Herencia | `CajaAhorro` y `CuentaCorriente` extienden `Cuenta` |
| Asociación | `Cliente` tiene una lista de `Cuenta` |
| Composición | `Cuenta` crea y destruye sus `Movimiento` |
| Agregación | `Sucursal` agrupa `Cliente` (si se elimina la sucursal, el cliente sigue existiendo) |
| Dependencia | `CajeroAutomatico` usa `Cuenta` solo como parámetro en un método |

---

## 🚀 Cómo ejecutar

1. Clonar el repositorio
2. Abrir con IntelliJ IDEA o VS Code
3. Ejecutar `SistemaBancarioBasicoApplication.java`
4. La API queda disponible en `http://localhost:8080`

---

## 📡 Endpoints

### GET `/sucursales/{id}/clientes`
Devuelve todos los clientes de una sucursal.

**Ejemplo:**
```
GET http://localhost:8080/sucursales/1/clientes
```

**Respuesta:**
```json
[
  {
    "nombre": "Pacho",
    "dni": "58273712",
    "email": "pachitoxd@gmail.com"
  }
]
```

---

### GET `/clientes/{dni}/cuentas`
Devuelve todas las cuentas de un cliente.

**Ejemplo:**
```
GET http://localhost:8080/clientes/58273712/cuentas
```

**Respuesta:**
```json
[
  {
    "cbu": "123",
    "saldo": 30000,
    "tipo": "Cuenta Corriente"
  }
]
```

---

### GET `/cuentas/{cbu}/movimientos`
Devuelve el historial de movimientos de una cuenta.

**Ejemplo:**
```
GET http://localhost:8080/cuentas/123/movimientos
```

**Respuesta:**
```json
[
  {
    "fecha": "2026-05-22",
    "monto": 2000,
    "detalle": "Deposito"
  }
]
```

---

## 📋 Datos Pre-cargados

### Sucursal 1 - Centro (Av. Mitre)
| Cliente | DNI | Email |
|---|---|---|
| Pacho | 58273712 | pachitoxd@gmail.com |
| Wara | 1231414 | warita@gmail.com |
| Nune | 531244123 | chanty@gmail.com |

### Sucursal 2 - Norte (Calle S/N)
| Cliente | DNI | Email |
|---|---|---|
| Sotelo | 58312712 | ekexd@gmail.com |
| Adrian | 51123452 | kekegod@gmail.com |

---

## 👨‍💻 Autor

Trabajo Práctico - Programación Orientada a Objetos  
Universidad Nacional de La Rioja (UNLaR)