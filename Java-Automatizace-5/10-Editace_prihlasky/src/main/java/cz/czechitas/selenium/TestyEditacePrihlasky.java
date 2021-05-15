package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyEditacePrihlasky {

    // Nejdrive konstanty
    private static final String URL_APLIKACE = "https://cz-test-dva.herokuapp.com/";

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void rodicMusiBytSchopenUpravitExistujiciPrihlaskuZeSeznamuPrihlasek() {
        String urlZakovychPrihlasek = URL_APLIKACE + "zaci";
        prohlizec.navigate().to(urlZakovychPrihlasek);

        WebElement polickoEmail = prohlizec.findElement(By.id("email"));
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//form//button[contains(text(), 'Přihlásit')]"));
        polickoEmail.sendKeys("petr.otec@seznam.cz");
        polickoHeslo.sendKeys("Czechitas123");
        tlacitkoPrihlasit.click();

        List<WebElement> bunkySeJmenyDeti = prohlizec.findElements(By.xpath("//table[@id = 'DataTables_Table_0']//td[1]"));
        int nalezenyRadekCislo = -1;
        for (int i = 0; i < bunkySeJmenyDeti.size(); i++) {
            WebElement bunka = bunkySeJmenyDeti.get(i);
            if (bunka.getText().equals("Jitka Dite1621055190111")) {
                nalezenyRadekCislo = i;
            }
        }
        Assertions.assertTrue(nalezenyRadekCislo > -1);

        WebElement tlacitkoUpravitPrihlasku = prohlizec.findElement(By.xpath("//table[@id = 'DataTables_Table_0']//tr["+(nalezenyRadekCislo+1)+"]/td/div[contains(@class, 'btn-group')]/a[@title = 'Upravit']"));
        tlacitkoUpravitPrihlasku.click();

        String adresaEditacniStranky = prohlizec.getCurrentUrl();

        WebElement polickoPoznamky = prohlizec.findElement(By.id("note"));
        polickoPoznamky.clear();
        String novyTextPoznamky = "Prave ted je " + System.currentTimeMillis();
        polickoPoznamky.sendKeys(novyTextPoznamky);

        WebElement tlacitkoOdeslat = prohlizec.findElement(By.xpath("//input[@type='submit']"));
        tlacitkoOdeslat.click();

        WebDriverWait explicitniCekani = new WebDriverWait(prohlizec, 30);
        explicitniCekani.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//div[@class='toast-message']"));
        String text = potvrzeniPrihlasky.getText();
        Assertions.assertTrue(text.startsWith("Žák "));
        Assertions.assertTrue(text.endsWith(" byl úspěšně upraven"));

        prohlizec.navigate().to(adresaEditacniStranky);
        WebElement polickoPoznamky2 = prohlizec.findElement(By.id("note"));
        String puvodniTextPoznamky = polickoPoznamky2.getAttribute("value");
        Assertions.assertEquals(puvodniTextPoznamky, novyTextPoznamky);
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
