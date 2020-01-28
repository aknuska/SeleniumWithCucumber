
package org.selenium;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserInstance {

    private static WebDriver driver;

    public static void openURL(String url) {
        if (driver != null) {
            driver.close();
        }

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void waitForAllConnectionsToClose() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            while ((Boolean) js.executeScript("return jQuery.active != 0")) {
                //       System.out.println((Boolean)js.executeScript("return jQuery.active == 0"));
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            //System.out.println(ex);
        }
    }

    public static void closeBrowser() {
        driver.close();
        driver = null;
    }

}
