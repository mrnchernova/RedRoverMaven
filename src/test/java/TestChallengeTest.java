import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class TestChallengeTest {
    private WebDriver driver;
    private WebDriverWait wait5;
    private WebDriverWait wait10;
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
    public void selenium1Test() throws InterruptedException {
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


        Thread.sleep(5000);
        WebElement textBox2 = driver.findElement(By.name("firstname"));
        WebElement submitButton2 = driver.findElement(By.cssSelector("input.button"));

        textBox2.sendKeys("");
        submitButton2.click();

        WebElement message2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/ul/li"));

        String value2 = message2.getText();
        assertEquals(value2, "Empty value");


//        driver.quit();
    }

//
//    @Test
//    public void selenium2Test(){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//        driver.get("http://testingchallenges.thetestingmap.org/index.php");
//
//        String title = driver.getTitle();
//        assertEquals(title, "Testing Challenges");
//
//        WebElement textBox = driver.findElement(By.name("firstname"));
//        WebElement submitButton = driver.findElement(By.cssSelector("input.button"));
//
//        textBox.sendKeys("");
//        submitButton.click();
//
//        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/ul/li"));
//
//        String value = message.getText();
//        assertEquals(value, "Empty value");
//
//        driver.quit();
//    }
//
//

    protected WebDriver getDriver() {
        if (driver == null) {
            synchronized (WebDriver.class) {
                driver = new ChromeDriver();
            }
        }

        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            synchronized (WebDriverWait.class) {
                wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            }
        }

        return wait5;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            synchronized (WebDriverWait.class) {
                wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            }
        }

        return wait10;
    }

    @Test
    public void testHorizontalSliderTBank() throws InterruptedException {

        getDriver().get("https://www.tbank.ru/loans/cash-loan/realty/form/autoloan/");

        getWait5().until(d -> getDriver().getTitle() != null); //  проверка загрузки страницы

        WebElement slider = getDriver().findElement(By.xpath("//div[@data-field-name='cashloan_calculator_term_field']//div[@data-qa-type='uikit/Draggable']"));

        Actions actions = new Actions(getDriver());

        actions.dragAndDropBy(slider, 50, 0).perform();
        WebElement sliderLenght = getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[2]/div/div/div[4]/div[1]/div/div[2]/div[3]/div/div/div"));

        WebElement sliderValue2 = getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[2]/div/div/div[4]/div[1]/div/div[1]/div/input"));

        System.out.println(sliderLenght.getAttribute("aria-valuenow")+ "!!!!!!!!!");
        Thread.sleep(2000);

        Assert.assertEquals(sliderValue2.getAttribute("value"), "15\u00A0лет");
        Thread.sleep(2000);
        driver.quit();
    }
}
