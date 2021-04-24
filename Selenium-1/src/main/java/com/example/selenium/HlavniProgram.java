package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HlavniProgram {

    private WebDriver browser;

    public void run() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        browser = new FirefoxDriver();
        try {

            browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            browser.navigate().to("https://www.wikipedia.org/");

            waitUntilJavaScriptFindsElement("#searchInput");
            WebElement searchElement = browser.findElement(By.cssSelector("#searchInput"));
            searchElement.sendKeys("Hello World program");
            //searchElement.submit();

            WebElement searchButton = browser.findElement(By.cssSelector("button.pure-button-primary-progressive"));
            searchButton.click();

            waitUntilJavaScriptFindsElement("#History");
            WebElement historyParagraph = browser.findElement(By.cssSelector("#History"));
            System.out.println("Success");



        } finally {
            browser.close();
        }
    }

    private void waitUntilJavaScriptFindsElement(String cssSelector) {
        waitUntilJavaScriptReturnsNonNull("return document.querySelector('"+cssSelector+"');");
    }

    private void waitUntilJavaScriptReturnsNonNull(String script) {
        WebDriverWait wait = new WebDriverWait(browser, 60);
        wait.until(it -> {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) it;
            Object result = javascriptExecutor.executeScript(script);
            return result != null;
        });
    }
}
