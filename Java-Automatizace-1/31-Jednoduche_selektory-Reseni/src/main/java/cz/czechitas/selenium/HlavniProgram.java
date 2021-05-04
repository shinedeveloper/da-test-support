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

        WebDriver prohlizec;
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        prohlizec.navigate().to("https://automation.shinekamil.repl.co/");

        WebElement zalozkaButtons = prohlizec.findElement(By.id("selectorsButtons"));
        zalozkaButtons.click();

        WebElement idButton = prohlizec.findElement(By.id("button1"));
        idButton.click();
        WebElement nameButton = prohlizec.findElement(By.name("clickingOnMe"));
        nameButton.click();
        WebElement classNameButton = prohlizec.findElement(By.className("click-click-click"));
        classNameButton.click();
//      WebElement theButton = prohlizec.findElement(By.linkText("This is THE button"));
        WebElement theButton = prohlizec.findElement(By.xpath("//button[text() = 'This is THE button']"));
        theButton.click();
//      WebElement partialButton = prohlizec.findElement(By.partialLinkText("Partial"));
        WebElement partialButton = prohlizec.findElement(By.xpath("//button[contains(text(), 'Partial')]"));
        partialButton.click();
        WebElement dataButton = prohlizec.findElement(By.xpath("//button[@data-qa='customAttribute-button']"));
        dataButton.click();
        WebElement xpathButton = prohlizec.findElement(By.xpath("//p/button"));
        xpathButton.click();
        WebElement mimoButton = prohlizec.findElement(By.xpath("/html/body/div/button"));
        mimoButton.click();

        Thread.sleep(5_000);

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
