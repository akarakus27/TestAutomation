package bootcamp.tests.kata_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        lunchDemoTest();
    }

    @Test
    public void test(){
        lunchDemoTest();
    }

    private static void lunchDemoTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://the-internet.herokuapp.com/forgot_password");
        WebElement inputBox =chromeDriver.findElement(By.id("email"));
        inputBox.sendKeys("abdulkadirkarakus27@gmail.com");
        chromeDriver.findElement(By.xpath("//input[@type='email']"));

        //chromeDriver.findElement(By.xpath("//i[contains(.,'Retrieve password')]");

        chromeDriver.quit();
    }



}
