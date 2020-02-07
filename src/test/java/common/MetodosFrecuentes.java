package common;

import net.serenitybdd.core.pages.PageObject;

public class MetodosFrecuentes extends PageObject {

    /**
     * Método que abre la página Femfuturo
     */
    public void abrirPagina(){
        setDefaultBaseUrl("http://www.femfuturo-gana.com.co/");
        open();
    }
}
