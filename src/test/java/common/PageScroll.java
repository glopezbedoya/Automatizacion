package common;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageScroll extends PageObject {

    public void scrollingToElemento(WebElement elemento) {
        try {

            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView();", elemento);

        } catch (Exception e) {
            System.err.println("Error en la clase " + PageScroll.class + " " + e);
        }
    }


    public void scrollingToBottomOfPaga(){

        try {
            ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
            System.err.println("Error en la clase " + PageScroll.class + " " + e);
        }
    }

    public void scrollingToUp() {
        try {
            ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0,0);");
        } catch (Exception e) {
            System.err.println("Error en la clase"+PageScroll.class+" " +e);
        }
    }

}
