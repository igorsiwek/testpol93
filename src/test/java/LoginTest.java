import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    WebElement emailInput;
    WebElement passwordInput;


    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void doLogin() {
        driver.get(url);
        emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("poczta@poczta.pl");
        passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");


    }







    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
