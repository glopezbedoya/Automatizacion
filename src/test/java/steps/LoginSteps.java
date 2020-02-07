package steps;

import PageObject.LoginPage;
import common.MetodosFrecuentes;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

    @Steps(shared = true)
    LoginPage login;

    @Steps(shared = true)
    MetodosFrecuentes metodos;

    @Step("el usuario ingresa a la aplicación")
    public void ingresarInterfaz() {
        metodos.abrirPagina();
    }

    @Step("el usuario ingresa las credenciales {0}, {1}")
    public void diligenciarDatos(String usuario, String clave) {
        login.ingresarCredenciales(usuario, clave);
    }

    @Step("se presiona el botón ingresar")
    public void presionarBoton() {
        login.presionarBoton();
    }

    @Step("el sistema redirecciona el usuario al home")
    public void validarIngreso() {
        login.validarUsuarioLogin();
    }

    @Step("El usuario ingrese credenciales erronea y no debe permitir el ingreso")
    public void loginErroneo() {
        login.validarLoginErroneo();
    }

    @Step("Ingresar al simulador y simular un crédito")
    public void simulador() {
        login.simulador();

    }

    public void ingresarDatos(String tipoCredito, String vlrCredito, String numCuota) {
        login.ingresarDatos(tipoCredito,vlrCredito,numCuota) ;
    }
}
