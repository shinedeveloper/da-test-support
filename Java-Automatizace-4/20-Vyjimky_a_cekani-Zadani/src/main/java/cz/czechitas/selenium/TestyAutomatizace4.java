package cz.czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestyAutomatizace4 {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
//      prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void poStiskuTlacikaLoginMusiBytZobrazenaStrankaLoggedIn() {
        prohlizec.navigate().to("https://automation4.shinekamil.repl.co/login.html");

        WebElement polickoUsername = prohlizec.findElement(By.id("login-username"));
        WebElement polickoPassword = prohlizec.findElement(By.id("login-password"));
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.id("login-submit"));
        polickoUsername.sendKeys("czechitas");
        polickoPassword.sendKeys("D4Ostr4v42020");
        tlacitkoPrihlasit.click();

        WebElement hlaseniLogged = prohlizec.findElement(By.xpath("//h1[text() = 'LOGGED!']"));
        Assertions.assertNotNull(hlaseniLogged);
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
