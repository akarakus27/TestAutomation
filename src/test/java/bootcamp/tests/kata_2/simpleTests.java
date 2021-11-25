package bootcamp.tests.kata_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class simpleTests {
    public void main(String[] args) {
        firstTest();
        beforeTest();
    }

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com");
        driver.findElement(By.linkText("A/B Testing")).click();
        WebElement title =driver.findElement(By.xpath("//h3[@class='heading']"));
        String ActualTitle = title.getText();
        String ExpectedTitle = "A/B Test Variation 1";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

    }

    @Test
    public void beforeTest(){
        WebDriver driver = new ChromeDriver();
        driver.quit();

    }
}
