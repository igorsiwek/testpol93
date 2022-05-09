import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicDesktopIconUI;

public class FirstRefactor {

    private WebDriver driver;
    String pageTitle = "";
    String url = "http://automationpractice.com/index.php";
    String expectedTitle = "My Store";

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
         }
    @Test
    public void checkPageTitle(){
        driver.get(url);
        pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedTitle, "Wartosc oczekiwana jest roóżna od wartości pobranej");
        }
   @AfterTest
    public void tearDown(){
        driver.quit();
       }
}



