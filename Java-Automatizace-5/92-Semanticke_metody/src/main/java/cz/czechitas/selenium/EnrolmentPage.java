package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnrolmentPage {

    WebDriver prohlizec;

    public EnrolmentPage(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public HomePage zapocniNovouPrihlasku() {
        WebElement tlacitkoVytvoritNovouPrihlasku = prohlizec.findElement(By.linkText("Vytvořit novou přihlášku"));
        tlacitkoVytvoritNovouPrihlasku.click();

        HomePage domovskaStranka = new HomePage(prohlizec);
        return domovskaStranka;
    }

}
