import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestChallengeTest {

//    WebDriver driver;
//    @BeforeEach
//    public void setup() {
//        driver = new ChromeDriver();
//    }
//    @AfterEach
//    public void teardown() {
//        driver.quit();
//    }


    @Test
    public void selenium1Test(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://testingchallenges.thetestingmap.org/index.php");

        String title = driver.getTitle();
        assertEquals(title, "Testing Challenges");

        WebElement textBox = driver.findElement(By.name("firstname"));
//        WebElement submitButton = driver.findElement(By.cssSelector("input[class='button']"));
        WebElement submitButton = driver.findElement(By.cssSelector("input.button"));

        textBox.sendKeys("q");
        submitButton.click();

//        WebElement message = driver.findElement(By.id("message"));
//        WebElement message = driver.findElement(By.className("values-description t10"));
        WebElement message = driver.findElement(By.cssSelector("span.values-tested"));
        String value = message.getText();
        assertEquals(value, "1");

        driver.quit();
    }


    @Test
    public void selenium2Test(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://testingchallenges.thetestingmap.org/index.php");

        String title = driver.getTitle();
        assertEquals(title, "Testing Challenges");

        WebElement textBox = driver.findElement(By.name("firstname"));
        WebElement submitButton = driver.findElement(By.cssSelector("input.button"));

        textBox.sendKeys("");
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/ul/li"));

        String value = message.getText();
        assertEquals(value, "Empty value");

        driver.quit();
    }



}
