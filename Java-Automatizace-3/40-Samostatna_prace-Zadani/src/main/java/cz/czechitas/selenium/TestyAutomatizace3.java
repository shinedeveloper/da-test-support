package cz.czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestyAutomatizace3 {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /*
    @Test
    public void po5nasobnemStiskuTlacikaLajkMusiBytPocetLajku5() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/selectors.html");

        // TODO: Sem vepiste svuj program
    }
    */

    /*
    @Test
    public void poStiskuPridejKockuMusiBytSpravnyPocetObrazkuKocek() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/adding.html");

        // TODO: Sem vepiste svuj program
    }
    */

    /*
    @Test
    public void poStiskuPridejAOdeberKockuMusiBytSpravnyPocetObrazkuKocek() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/adding.html");

        // TODO: Sem vepiste svuj program
    }
    */

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
