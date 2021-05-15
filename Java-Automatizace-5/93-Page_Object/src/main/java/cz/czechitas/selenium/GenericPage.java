package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

    private WebDriver prohlizec;

    public GenericPage(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public GenericPage(WebDriver prohlizec, String vychoziUrl) {
        this(prohlizec);
        otevriStrankuSAdresou(vychoziUrl);
    }

    public void otevriStrankuSAdresou(String url) {
        prohlizec.navigate().to(url);
    }

    public void overNadpisStranky(String text) {
        WebElement nadpisStranky = prohlizec.findElement(By.xpath("//header//h1"));
        Assertions.assertEquals(text, nadpisStranky.getText());
    }

    public LoginPage klikniNaTlacitkoPrihlasitUzivatele() {
        WebElement odkazPrihlasit = prohlizec.findElement(By.linkText("Přihlásit"));
        odkazPrihlasit.click();

        return new LoginPage(prohlizec);
    }
}
