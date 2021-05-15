package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyPrihlaseniNaKurz {

    // Nejdrive konstanty
    private static final String URL_APLIKACE = "https://cz-test-jedna.herokuapp.com/";

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void prihlaseniMusiFungovat() {
        prohlizec.navigate().to(URL_APLIKACE);
        klikniNaTlacitkoPrihlasitUzivatele();

        prihlasUzivatele();

        Assertions.assertTrue(prohlizec.getCurrentUrl().endsWith("/zaci"));
        WebElement nadpisStranky = najdiNadpisStranky();
        Assertions.assertEquals("Přihlášky", nadpisStranky.getText());
    }

    @Test
    public void rodicSeMusiBytSchopenPrihlasitAVybratTerminKurzuProDite() {
        String urlZakovychPrihlasek = URL_APLIKACE + "zaci";
        prohlizec.navigate().to(urlZakovychPrihlasek);

        prihlasUzivatele();

        WebElement tlacitkoVytvoritNovouPrihlasku = prohlizec.findElement(By.linkText("Vytvořit novou přihlášku"));
        tlacitkoVytvoritNovouPrihlasku.click();

        vyberKategoriiCislo(2);

        vyberKurzCislo(0);

        vyplnPrihlaskuNaKurz();

        WebElement tlacitkoOdeslat = prohlizec.findElement(By.xpath("//input[@type='submit']"));
        tlacitkoOdeslat.click();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    public void rodicMusiBytSchopenVybratDitetiTerminKurzuAPrihlasitHo() {
        prohlizec.navigate().to(URL_APLIKACE);

        vyberKategoriiCislo(2);
        vyberKurzCislo(0);
        prihlasUzivatele();

        WebElement nadpisStranky = najdiNadpisStranky();
        Assertions.assertEquals("Nová přihláška", nadpisStranky.getText());

        vyplnPrihlaskuNaKurz();

        WebElement tlacitkoOdeslat = prohlizec.findElement(By.xpath("//input[@type='submit']"));
        tlacitkoOdeslat.click();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    //-------------------------------------------------------------------------

    private void klikniNaTlacitkoPrihlasitUzivatele() {
        WebElement odkazPrihlasit = prohlizec.findElement(By.linkText("Přihlásit"));
        odkazPrihlasit.click();
    }

    private void prihlasUzivatele() {
        WebElement nadpisStranky = najdiNadpisStranky();
        Assertions.assertEquals("Přihlášení", nadpisStranky.getText());

        vyplnUzivatelskeJmeno("petr.otec@seznam.cz");
        vyplnHeslo("Czechitas123");
        potvrdPrihlaseni();
    }

    private WebElement najdiNadpisStranky() {
        return prohlizec.findElement(By.xpath("//header//h1"));
    }

    private void vyplnUzivatelskeJmeno(String uzivJmeno) {
        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        polickoEmail.sendKeys(uzivJmeno);
    }

    private void vyplnHeslo(String heslo) {
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys(heslo);
    }

    private void potvrdPrihlaseni() {
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//form//button[contains(text(), 'Přihlásit')]"));
        tlacitkoPrihlasit.click();
    }

    private void vyberKurzCislo(int poradiKurzu) {
        List<WebElement> tlacitkaKurzuVytvoritPrihlasku = prohlizec.findElements(By.xpath("//div[@class = 'card']//a[text() = 'Vytvořit přihlášku']"));
        WebElement tlacitkoVytvoritPrihlasku = tlacitkaKurzuVytvoritPrihlasku.get(poradiKurzu);
        tlacitkoVytvoritPrihlasku.click();
    }

    private void vyberKategoriiCislo(int poradiKategorie) {
        List<WebElement> tlacitkaKurzuViceInformaci = prohlizec.findElements(By.xpath("//div[@class = 'card']//a[text() = 'Více informací']"));
        WebElement tlacitkoViceInformaci = tlacitkaKurzuViceInformaci.get(poradiKategorie);
        tlacitkoViceInformaci.click();
    }

    private void vyplnPrihlaskuNaKurz() {
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

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
