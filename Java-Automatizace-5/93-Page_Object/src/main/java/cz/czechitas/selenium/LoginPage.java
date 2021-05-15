package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GenericPage {

    WebDriver prohlizec;

    public LoginPage(WebDriver prohlizec) {
        super(prohlizec);
        this.prohlizec = prohlizec;
    }

    public void prihlasUzivatele() {
        overNadpisStranky("Přihlášení");

        vyplnUzivatelskeJmeno("petr.otec@seznam.cz");
        vyplnHeslo("Czechitas123");
        potvrdPrihlaseni();
    }

    public void vyplnUzivatelskeJmeno(String uzivJmeno) {
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys(uzivJmeno);
    }

    public void vyplnHeslo(String heslo) {
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys(heslo);
    }

    public void potvrdPrihlaseni() {
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//form//button[contains(text(), 'Přihlásit')]"));
        tlacitkoPrihlasit.click();
    }
}
