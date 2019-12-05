package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCheckBoxes {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://AutomationPracticeMaven//src//test//resources//libs//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver.get("http://qaclickacademy.com/practice.php");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        WebElement firstCheckBox = driver.findElement(By.id("checkBoxOption1"));
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected());
        System.out.println(firstCheckBox.isSelected());
        firstCheckBox.click();
        Assert.assertFalse(firstCheckBox.isSelected());
        System.out.println(firstCheckBox.isSelected());
        Thread.sleep(5000);

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //Practicando Manejo de alertas
        String text = "Rahul";
        String firstTxt = "Hello " + text + ", share this practice page and share your knowledge";
        String secondTxt = "Hello , Are you sure you want to confirm?";

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        String firstAlertTxt = driver.switchTo().alert().getText();
        Assert.assertTrue(firstAlertTxt.equals(firstTxt));
        System.out.println((firstAlertTxt.equals(firstTxt)));
        System.out.println(firstAlertTxt);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        String secondAlertTxt = driver.switchTo().alert().getText();
        Assert.assertTrue(secondAlertTxt.equals(secondTxt));
        System.out.println((secondAlertTxt.equals(secondTxt)));
        System.out.println(secondAlertTxt);
        driver.switchTo().alert().dismiss();


        //Segunda Práctica
        driver.get("http://www.cleartrip.com/");

//calendar

        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")).click();

        //First Selector
        WebElement adult = driver.findElement(By.id("Adults"));

        Select s = new Select(adult);
        s.selectByVisibleText("2");

        //Second Selector
        WebElement ch = driver.findElement(By.id("Childrens"));
        Select s1 = new Select(ch);
        s1.selectByVisibleText("1");

        driver.findElement(By.xpath("//a[@title='More search options']")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Aeromexico");
        driver.findElement(By.id("SearchBtn")).click();

//validate error message

        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
        Thread.sleep(5000);

        driver.quit();

    }
}
