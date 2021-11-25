package bootcamp.tests.kata_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kata1Tests {
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
        chromeDriver.get("https://google.com");
        chromeDriver.get("https://kloia.com");
        chromeDriver.navigate().back();
        chromeDriver.quit();
    }

}
