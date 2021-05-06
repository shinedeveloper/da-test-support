package cz.czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
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


    @Test
    public void po5nasobnemStiskuTlacikaLajkMusiBytPocetLajku5() {
        int zadanyPocetLajku = 5;

        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/selectors.html");
        WebElement tlacitkoLajk = prohlizec.findElement(By.id("like-button"));
        for (int i = 0; i < zadanyPocetLajku; i++) {
            tlacitkoLajk.click();
        }
        WebElement spanPocetLajku = prohlizec.findElement(By.id("lvlAwesome"));
        int skutecnyPocetLajku = Integer.parseInt(spanPocetLajku.getText());
        Assertions.assertEquals(zadanyPocetLajku, skutecnyPocetLajku);
    }


    @Test
    public void poStiskuPridejKockuMusiBytSpravnyPocetObrazkuKocek() throws Exception {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/adding.html");
        for (int i = 1; i <= 10; i++) {
            WebElement tlacitkoPridejKocku = prohlizec.findElement(By.id("addItem"));
            tlacitkoPridejKocku.click();
            List<WebElement> obdelnikyKocek = prohlizec.findElements(By.xpath("//div[@class = 'card cat']"));
            WebElement spanPocetKocek = prohlizec.findElement(By.id("counter"));
            Assertions.assertEquals(i, obdelnikyKocek.size());
            Assertions.assertEquals(i, Integer.parseInt(spanPocetKocek.getText()));
        }
    }

    @Test
    public void poStiskuPridejAOdeberKockuMusiBytSpravnyPocetObrazkuKocek() {
        prohlizec.navigate().to("https://automation3.shinekamil.repl.co/adding.html");
        WebElement tlacitkoPridejKocku = prohlizec.findElement(By.id("addItem"));
        WebElement tlacitkoOdeberKocku = prohlizec.findElement(By.id("removeItem"));
        for (int i = 0; i < 10; i++) {
            tlacitkoPridejKocku.click();
        }
        List<WebElement> obdelnikyKocek = prohlizec.findElements(By.xpath("//div[@class = 'card cat']"));
        WebElement spanPocetKocek = prohlizec.findElement(By.id("counter"));
        Assertions.assertEquals(10, obdelnikyKocek.size());
        Assertions.assertEquals(10, Integer.parseInt(spanPocetKocek.getText()));
        tlacitkoOdeberKocku.click();
        obdelnikyKocek = prohlizec.findElements(By.xpath("//div[@class = 'card cat']"));
        spanPocetKocek = prohlizec.findElement(By.id("counter"));
        Assertions.assertEquals(9, obdelnikyKocek.size());
        Assertions.assertEquals(9, Integer.parseInt(spanPocetKocek.getText()));
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
