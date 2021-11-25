package bootcamp.tests.kata_2;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleTestsSolu {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
        // sayfada elementi yüklenen kadar bekliyor implicitlywait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void firstTest(){

        driver.findElement(By.linkText("A/B Testing")).click();
        String title = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("A/B Test Variation 1", title);
    }
    @Test
    public void LoginTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
        WebElement Username =driver.findElement(By.id("username"));
        Username.sendKeys("tomsmith");
        // driver.findElement(By.id("username")).sendKeys("tomsmith");
        WebElement Password =driver.findElement(By.id("password"));
        Password.sendKeys("SuperSecretPassword!");
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa"));
        //driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualTitle = driver.findElement(By.className("subheader")).getText();
        String expectedTitle = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedTitle, actualTitle);
        //String verifyText = driver.findElement(By.tagName("h2")).getText();
        //Assert.assertEquals("Secure Area",verifyText);
        //String title = driver.findElement(By.tagName("h4")).getText();
        //Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", title);

    }
    @Test
    public void DynamicLogin1 () {

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2:")).click();
        driver.findElement(By.cssSelector("#start button")).click();
        //driver.findElement(By.xpath("//div[@id='start']/button"));
        //Thread.sleep(5000);
        String title = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals("Hello World!", title);
    }

    @Test
    public void DynamicLogin2 ()   {

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1:")).click();
        driver.findElement(By.cssSelector("#start button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loading = driver.findElement(By.id("loading"));
        wait.until(ExpectedConditions.invisibilityOf(loading));
        String title = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals("Hello World!", title);
    }


}