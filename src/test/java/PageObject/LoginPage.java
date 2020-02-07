package PageObject;

import common.PageScroll;
import common.TiemposPruebas;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginPage extends PageObject {

    @Steps(shared = true)
    PageScroll scroll;

    @Steps(shared = true)
    TiemposPruebas time;

    @FindBy(how = How.ID, using = "usuario")
    WebElementFacade txtUsuario;

    @FindBy(how = How.ID, using = "contrasena")
    WebElementFacade txtContrasena;
    /********************************INPUTS*************************************/
    @FindBy(how = How.ID, using = "boton-entrar")
    WebElementFacade btnAceptar;

    @FindBy(how = How.ID, using = "encabezado")
    WebElementFacade lblCuenta;

    @FindBy(how = How.ID, using = "usuario")
    WebElementFacade rdbEstados;

    @FindBy(how = How.ID, using = "login-error")
    WebElementFacade lblError;

    @FindBy(how = How.XPATH, using = "//a[@title='Simulador']")
    WebElementFacade lnkSimulador;

    @FindBy(how = How.ID, using = "destino__codDestino")
    WebElementFacade sloTipocredito;

    @FindBy(how = How.ID, using = "valorCredito")
    WebElementFacade txtValor;

    @FindBy(how = How.ID, using = "cuotas")
    WebElementFacade txtCuotas;

    @FindBy(how = How.ID, using = "submitbutton")
    WebElementFacade btnSimular;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Cerrar')]")
    WebElementFacade btnCerrar;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Proyección del Crédito')]")
    WebElementFacade lblProyeccion;


    public void seleccionarOpciones() {

        scroll.scrollingToBottomOfPaga();
        List<WebElement> listOpcionesYears = getDriver().findElements(By.xpath("//h2[@class='grupoNoticias-tituloNoticia']"));

        String texto = listOpcionesYears.get(6).getText();
        listOpcionesYears.get(6).click();
        System.out.println(texto);
    }

    /**
     * Método que ingresa las credenciales del login
     *
     * @param usuario
     * @param contrasena
     */
    public void ingresarCredenciales(String usuario, String contrasena) {
        time.tiempoElemento(txtUsuario);
        txtUsuario.sendKeys(usuario);
        txtContrasena.sendKeys(contrasena);
    }

    /**
     * Método que presiona el botón para iniciar sesión
     */
    public void presionarBoton() {
        time.tiempoSegundos(1);
        btnAceptar.click();
    }

    /**
     * Método que valida que el usuario haya iniciado sesión
     */
    public void validarUsuarioLogin() {
        time.tiempoElemento(lblCuenta);
        String lblHome = lblCuenta.getText();
        Assert.assertEquals("ESTADO DE CUENTA", lblHome);
        time.tiempoSegundos(5);
    }

    public void validarLoginErroneo() {
        time.tiempoElemento(lblError);
        String lblErrorMsg = lblError.getText();
        Assert.assertEquals("Error: Usuario o clave inválida", lblErrorMsg);
    }

    /**
     * método que permite ingresar al simulador
     */
    public void simulador() {
        time.tiempoElemento(lnkSimulador);
        lnkSimulador.click();



    }


    public void ingresarDatos(String tipoCredito, String vlrCredito, String numCuota) {
        time.tiempoElemento(sloTipocredito);
        btnCerrar.click();
        Select listCreditos = new Select(sloTipocredito);
        listCreditos.selectByValue(tipoCredito);
        txtValor.sendKeys(vlrCredito);
        txtCuotas.sendKeys(numCuota);
        time.tiempoSegundos(5);
        btnSimular.click();
        Assert.assertEquals("Proyección del Crédito", lblProyeccion.getText());
        time.tiempoSegundos(10);

    }

}
