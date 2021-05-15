package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentHomePage extends GenericPage {

    WebDriver prohlizec;

    public ParentHomePage(WebDriver prohlizec) {
        super(prohlizec);
        this.prohlizec = prohlizec;
    }

    public CourseListPage zapocniNovouPrihlasku() {
        WebElement tlacitkoVytvoritNovouPrihlasku = prohlizec.findElement(By.linkText("Vytvořit novou přihlášku"));
        tlacitkoVytvoritNovouPrihlasku.click();

        return new CourseListPage(prohlizec);
    }

    public void overNadpisStranky() {
        super.overNadpisStranky("Přihlášky");
    }
}
