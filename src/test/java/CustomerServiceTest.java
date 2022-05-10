import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.print.attribute.standard.OrientationRequested;
import java.io.File;

public class CustomerServiceTest {

    WebDriver driver;
    String url = "http://automationpractice.com/index.php";
    WebElement contactUsButton;
    Select subjectHeader;
    WebElement emailInput;
    WebElement orderInput;
    WebElement messageInput;
    WebElement fileInput;
    WebElement sendButton;
    boolean successMsg;









    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void doLogin() {
        driver.get(url);
        contactUsButton = driver.findElement(By.id("contact-link"));
        contactUsButton.click();
        subjectHeader = new Select(driver.findElement(By.id("id_contact")));
        subjectHeader.selectByVisibleText("Customer service");
        emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("poczta@poczta.pl");
        orderInput = driver.findElement(By.id("id_order"));
        orderInput.sendKeys("12312");
        messageInput = driver.findElement(By.id("message"));
        messageInput.sendKeys("omg");
        fileInput = driver.findElement(By.id("fileUpload"));
        File file = new File("src/main/resources/testy.txt");
        fileInput.sendKeys(file.getAbsolutePath());
        sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='alert alert-success']"))));
        successMsg = driver.findElement(By.xpath("//p[@class='alert alert-success']")).isDisplayed();
        Assert.assertTrue(successMsg);






    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
