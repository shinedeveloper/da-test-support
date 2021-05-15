package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnrolmentConfirmationPage extends GenericPage {

    WebDriver prohlizec;

    public EnrolmentConfirmationPage(WebDriver prohlizec) {
        super(prohlizec);
        this.prohlizec = prohlizec;
    }

    public void overPotvrzeniPrihlasky() {
        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }
}
