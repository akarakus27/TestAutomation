package bootcamp.tests.kata_1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/");
        WebElement title =driver.findElement(By.xpath("//h1[@class='heading']"));
        title.getText();
        Thread.sleep(2000);
        driver.quit();
    }
}
