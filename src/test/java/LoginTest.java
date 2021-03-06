import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    WebElement emailInput;
    WebElement passwordInput;
    WebElement submitButton;
    String title;



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
        submitButton = driver.findElement((By.id("SubmitLogin")));
        submitButton.click();
        title = driver.findElement(By.className("info-account")).getText();
        System.out.println(title);
        Assert.assertEquals(title, "Welcome to your account. Here you can manage all of your personal information and orders.", "wartosc pobrana jest rozna od wartosci oczekiwanej");



    }









    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
