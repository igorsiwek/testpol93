import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");

        String pageTitle = "";
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        pageTitle = driver.getTitle();

        if (pageTitle.equals("My Store")){
            System.out.println("Test przebiegl pozytywnie");
        } else {
            System.out.println("Coś poszło nie tak");
        }
    }
}
