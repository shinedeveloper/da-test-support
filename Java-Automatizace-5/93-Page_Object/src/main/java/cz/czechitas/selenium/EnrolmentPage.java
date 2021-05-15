package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnrolmentPage extends GenericPage {
    WebDriver prohlizec;

    public EnrolmentPage(WebDriver prohlizec) {
        super(prohlizec);
        this.prohlizec = prohlizec;
    }

    public void vyplnPrihlaskuNaKurz() {
        WebElement menuVyberteTermin = prohlizec.findElement(By.xpath("//div[text()='Vyberte termín...']"));
        menuVyberteTermin.click();

        WebElement polickoTerminu = prohlizec.findElement(By.xpath("//div[@class='bs-searchbox']//input"));
        polickoTerminu.sendKeys("28\n");

        WebElement krestniJmenoZaka = prohlizec.findElement(By.id("forename"));
        krestniJmenoZaka.sendKeys("Karel");

        WebElement prijmeniZaka = prohlizec.findElement(By.id("surname"));
        prijmeniZaka.sendKeys("Synek");

        WebElement datumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        datumNarozeniZaka.sendKeys("24.12.2000");

        WebElement zaplatitHotove = prohlizec.findElement(By.xpath("//label[@for='payment_cash']"));
        zaplatitHotove.click();

        WebElement zaskrtavatkoSouhlas = prohlizec.findElement(By.xpath("//label[@for='terms_conditions']"));
        zaskrtavatkoSouhlas.click();
    }

    public EnrolmentConfirmationPage odesliPrihlasku() {
        WebElement tlacitkoOdeslat = prohlizec.findElement(By.xpath("//input[@type='submit']"));
        tlacitkoOdeslat.click();

        return new EnrolmentConfirmationPage(prohlizec);
    }

    public void overNadpis() {
        WebElement nadpisStranky = prohlizec.findElement(By.xpath("//header//h1"));
        Assertions.assertEquals("Nová přihláška", nadpisStranky.getText());
    }
}
