package StepDefinition;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;
import steps.LoginSteps;

public class StepsDefinition {

    @Steps(shared = true)
    LoginSteps login;

    /***************************************Flujo normal iniciar sesión***************************************************/
    @Dado("^que el usuario ingresa  a la página de femfuturo$")
    public void ingresar_interfaz() {
        login.ingresarInterfaz();
    }

    @Cuando("^el usuario ingrese el (.*) y (.*)$")
    public void diligenciar_datos(String usuario, String clave) {
        login.diligenciarDatos(usuario, clave);
    }

    @Y("^presiona el botón ingresar$")
    public void presionar_boton() {
        login.presionarBoton();

    }

    @Entonces("^el sistema debería cargar la página$")
    public void validar_ingreso() {
        login.validarIngreso();
    }

    @Entonces("^el sistema debería no deberia permitir ingresar a la página$")
    public void login_erroneo() {
        login.loginErroneo();
    }



    /**********************************Simular Crédito*******************************************************/

    @Cuando("^El usuario Seleccione la opción Simulador$")
    public void seleccioneSimulador() {
        login.simulador();

    }

    @Y("^El usuario seleccione el tipo de crédito (.*), Valor del crédito (.*), Número de cuotas (.*) y presiona el botón Simular$")
    public void ingresarDatosSimular(String tipoCredito, String vlrCredito, String numCuota) {
        login.ingresarDatos(tipoCredito, vlrCredito, numCuota );

    }

    @Entonces("^El sistema debería simular el crédito$")
    public void simularCredito() {

    }
}
