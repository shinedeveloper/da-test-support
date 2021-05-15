package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        GenericPage vychoziStranka = new GenericPage(prohlizec, URL_APLIKACE);

        LoginPage strankaSPrihlasenimUzivatele = vychoziStranka.klikniNaTlacitkoPrihlasitUzivatele();
        strankaSPrihlasenimUzivatele.prihlasUzivatele();

        ParentHomePage hlavniStrankaRodice = new ParentHomePage(prohlizec);
        hlavniStrankaRodice.overNadpisStranky();
    }

    @Test
    public void rodicSeMusiBytSchopenPrihlasitAVybratTerminKurzuProDite() {
        GenericPage vychoziStranka = new GenericPage(prohlizec, URL_APLIKACE);
        LoginPage strankaSPrihlasenimUzivatele = vychoziStranka.klikniNaTlacitkoPrihlasitUzivatele();
        strankaSPrihlasenimUzivatele.prihlasUzivatele();

        ParentHomePage hlavniStrankaRodice = new ParentHomePage(prohlizec);
        CourseListPage strankaSeSeznamemKurzu = hlavniStrankaRodice.zapocniNovouPrihlasku();
        strankaSeSeznamemKurzu.vyberKategoriiCislo(2);
        EnrolmentPage strankaSPrihlaskouNaKurz = strankaSeSeznamemKurzu.vyberKurzCislo(0);
        strankaSPrihlaskouNaKurz.overNadpis();
        strankaSPrihlaskouNaKurz.vyplnPrihlaskuNaKurz();
        EnrolmentConfirmationPage strankaSPotvrzenim = strankaSPrihlaskouNaKurz.odesliPrihlasku();

        strankaSPotvrzenim.overPotvrzeniPrihlasky();
    }

    @Test
    public void rodicMusiBytSchopenVybratDitetiTerminKurzuAPrihlasitHo() {
        CourseListPage vychoziStranka = new CourseListPage(prohlizec, URL_APLIKACE);

        vychoziStranka.vyberKategoriiCislo(2);
        EnrolmentPage strankaSPrihlaskouNaKurz = vychoziStranka.vyberKurzCislo(0);

        LoginPage prihlasovaciStranka = new LoginPage(prohlizec);
        prihlasovaciStranka.prihlasUzivatele();

        strankaSPrihlaskouNaKurz.overNadpis();
        strankaSPrihlaskouNaKurz.vyplnPrihlaskuNaKurz();
        EnrolmentConfirmationPage strankaSPotvrzenim = strankaSPrihlaskouNaKurz.odesliPrihlasku();

        strankaSPotvrzenim.overPotvrzeniPrihlasky();
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
