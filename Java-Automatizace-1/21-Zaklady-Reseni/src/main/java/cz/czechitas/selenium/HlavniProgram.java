package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HlavniProgram {

    public void run() throws Exception {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");

        WebDriver prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        prohlizec.navigate().to("https://automation.shinekamil.repl.co/");

        WebElement zalozkaButtons = prohlizec.findElement(By.id("selectorsButtons"));
//      WebElement zalozkaButtons = prohlizec.findElement(By.xpath("//li[@id='selectorsButtons']"));
//      WebElement zalozkaButtons = prohlizec.findElement(By.xpath("//*[text() = 'Buttons']"));
//      WebElement zalozkaButtons = prohlizec.findElement(By.xpath("//ul/li"));
        zalozkaButtons.click();

        Thread.sleep(5_000);

        WebElement tlacitkoButton1 = prohlizec.findElement(By.id("button1"));
        tlacitkoButton1.click();

        System.out.println("\n\nHotovo!\n\n");
        Thread.sleep(10_000);

        prohlizec.close();
    }

}
