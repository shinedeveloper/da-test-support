package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HlavniProgram {

    public void run() throws Exception {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");

        WebDriver prohlizec;
        prohlizec = new FirefoxDriver();
        prohlizec.navigate().to("https://automation2.shinekamil.repl.co/selectors.html");

        List<WebElement> seznamOdstavcu = prohlizec.findElements(By.xpath("//*[@id='pohadka']/p"));
        for (int i=0; i<seznamOdstavcu.size(); i++) {
            WebElement jedenOdstavec = seznamOdstavcu.get(i);
            System.out.println("Odstavec: "+i);
            System.out.println(jedenOdstavec.getText());
        }
        for (WebElement jedenOdstavec : seznamOdstavcu) {
            System.out.println("Odstavec: ");
            System.out.println(jedenOdstavec.getText());
        }

        Thread.sleep(10_000);
        prohlizec.close();
    }
}
