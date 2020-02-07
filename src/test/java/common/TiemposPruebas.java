package common;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TiemposPruebas extends PageObject {


    /**
     * Método que espera que el elemento sea visible
     *
     * @param elemento
     */
    public void tiempoElemento(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    /**
     * Mtodo que espera que el webelement
     * sea visible y cliqueable
     */
    public void tiempoPresencia(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    /**
     * Creado en Octubre 17, 2017
     * <p>
     * <p>
     * Mtodo que espera que se
     * presente una alerta
     */
    public void tiempoAlerta() {
        WebDriverWait wait = new WebDriverWait(null, 5);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Metodo que espera la cantidad de segundos enviados en el metodo
     */
    public void tiempoSegundos(long segundos) {

        try {
            Thread.sleep(TimeUnit.MILLISECONDS.convert(segundos, TimeUnit.SECONDS));
        } catch (Exception e) {
            System.err.println("Error en la espera " + e);
        }
    }


    /**
     * Método que retorna valor true en caso de existir alertas cuando este es invocado
     */


    public boolean validarPresentaAlerta() {
        boolean alertaPresent;

        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
            Alert alerta = wait.until(ExpectedConditions.alertIsPresent());

            if (alerta != null) {
                System.out.println("Si hay alerta");
                alertaPresent = true;
            } else {
                System.out.println("No Hay alerta");
                alertaPresent = false;
            }
            return alertaPresent;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }


    public void SetClickAlerta() {

        boolean alerta = validarPresentaAlerta();
        while (alerta) {
            getDriver().switchTo().alert().accept();
            alerta = validarPresentaAlerta();

        }
    }
}
