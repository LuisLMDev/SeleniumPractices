package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://AutomationPracticeMaven//src//test//resources//libs//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait w = new WebDriverWait(driver, 5);
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        System.out.println(driver.findElement(By.id("results")).getText());
    }
}

