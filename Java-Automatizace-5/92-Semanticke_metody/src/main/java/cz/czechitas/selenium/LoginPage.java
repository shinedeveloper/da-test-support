package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver prohlizec;

    public LoginPage(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void klikniNaTlacitkoPrihlasitUzivatele() {
        WebElement odkazPrihlasit = prohlizec.findElement(By.linkText("Přihlásit"));
        odkazPrihlasit.click();
    }

    public void prihlasUzivatele() {
        WebElement nadpisStranky = najdiNadpisStranky();
        Assertions.assertEquals("Přihlášení", nadpisStranky.getText(),
                "Aktualne neni zobrazena prihlasovaci stranka");

        vyplnUzivatelskeJmeno("petr.otec@seznam.cz");
        vyplnHeslo("Czechitas123");
        potvrdPrihlaseni();
    }

    public WebElement najdiNadpisStranky() {
        return prohlizec.findElement(By.xpath("//header//h1"));
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
