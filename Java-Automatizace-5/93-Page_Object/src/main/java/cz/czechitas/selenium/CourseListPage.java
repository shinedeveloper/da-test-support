package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CourseListPage extends GenericPage {

    WebDriver prohlizec;

    public CourseListPage(WebDriver prohlizec) {
        super(prohlizec);
        this.prohlizec = prohlizec;
    }

    public CourseListPage(WebDriver prohlizec, String urlAplikace) {
        super(prohlizec, urlAplikace);
        this.prohlizec = prohlizec;
    }

    public void vyberKategoriiCislo(int poradiKategorie) {
        List<WebElement> tlacitkaKurzuViceInformaci = prohlizec.findElements(By.xpath("//div[@class = 'card']//a[text() = 'Více informací']"));
        WebElement tlacitkoViceInformaci = tlacitkaKurzuViceInformaci.get(poradiKategorie);
        tlacitkoViceInformaci.click();
    }

    public EnrolmentPage vyberKurzCislo(int poradiKurzu) {
        List<WebElement> tlacitkaKurzuVytvoritPrihlasku = prohlizec.findElements(By.xpath("//div[@class = 'card']//a[text() = 'Vytvořit přihlášku']"));
        WebElement tlacitkoVytvoritPrihlasku = tlacitkaKurzuVytvoritPrihlasku.get(poradiKurzu);
        tlacitkoVytvoritPrihlasku.click();

        return new EnrolmentPage(prohlizec);
    }

}
