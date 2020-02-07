#language: es


Característica: Login en Femfuturo

  Este caso de prueba valida que el login funcione correctamente

  @LoginExitoso
  Esquema del escenario: login en femfuturo
    Dado que el usuario ingresa  a la página de femfuturo
    Cuando el usuario ingrese el <usuario> y <clave>
    Y presiona el botón ingresar
    Entonces el sistema debería cargar la página

    Ejemplos:
      | Descripción | usuario    | clave      |
      | Usuario 1   | 1053783250 | 1053783250 |

  @LoginErroneo
  Esquema del escenario: login erroneo en femfuturo
    Dado que el usuario ingresa  a la página de femfuturo
    Cuando el usuario ingrese el <usuario> y <clave>
    Y presiona el botón ingresar
    Entonces el sistema debería no deberia permitir ingresar a la página

    Ejemplos:
      | Descripción | usuario    | clave  |
      | Usuario 1   | 1053783250 | 123456 |


  @SimuladorCredito
  Esquema del escenario: Ingresar al Simulador de crédito e ingresar los datos requeridos

    Dado que el usuario ingresa  a la página de femfuturo
    Cuando El usuario Seleccione la opción Simulador
    Y El usuario seleccione el tipo de crédito <tipoCredito>, Valor del crédito <vlrCredito>, Número de cuotas <numCuotas> y presiona el botón Simular
    Entonces El sistema debería simular el crédito

    Ejemplos:
      | descripcion | tipoCredito | vlrCredito | numCuotas |
      | valores     | CFAC        | 2000000    | 10        |




