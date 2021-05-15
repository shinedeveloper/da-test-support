package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver prohlizec;

    public HomePage(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void vyberKategoriiCislo(int poradiKategorie) {
        List<WebElement> tlacitkaKurzuViceInformaci = prohlizec.findElements(By.xpath("//div[@class = 'card']//a[text() = 'Více informací']"));
        WebElement tlacitkoViceInformaci = tlacitkaKurzuViceInformaci.get(poradiKategorie);
        tlacitkoViceInformaci.click();
    }



}
