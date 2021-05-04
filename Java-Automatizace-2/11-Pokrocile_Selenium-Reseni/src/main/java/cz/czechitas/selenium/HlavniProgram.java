package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HlavniProgram {

    public void run() throws Exception {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");

        WebDriver prohlizec;
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        prohlizec.navigate().to("https://automation2.shinekamil.repl.co/");

        WebElement zalozkaLogin = prohlizec.findElement(By.id("login"));
        zalozkaLogin.click();

        WebElement polickoUsername = prohlizec.findElement(By.id("login-username"));
        polickoUsername.sendKeys("czechitas");
        WebElement polickoPassword = prohlizec.findElement(By.id("login-password"));
        polickoPassword.sendKeys("D4Ostr4v42020");
        WebElement loginButton = prohlizec.findElement(By.id("login-submit"));
        loginButton.click();

        Thread.sleep(10_000);
        prohlizec.close();
    }
}
