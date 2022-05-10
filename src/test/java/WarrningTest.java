import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WarrningTest {

    WebDriver driver;
    String url = "http://automationpractice.com/index.php";
    WebElement signButton;
    WebElement emailInput;
    WebElement createAccountButton;
    boolean warning;





    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }



    @Test
    public void doLogin() {
        driver.get(url);
        signButton = driver.findElement(By.className("login"));
        signButton.click();
        emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("poczta@poczta.pl");
        createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error"))));
        warning = driver.findElement(By.id("create_account_error")).isDisplayed();
        Assert.assertTrue(warning);






    }









    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
