import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainMethod {
    public static void main (String [] args){
        System.getProperty("C:\\QA_Automation_Studying\\", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0");
        //I've used the Ukrainian Wikipedia.
        driver.manage().window().fullscreen();
        System.out.println (driver.getWindowHandle());
        //here we saved an id of the window;
        driver.findElement(By.id("searchInput")).sendKeys("Ubisoft");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        //Here we searched for the Ubisoft;

        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[4]/div[3]/div[4]/ul/li[1]/table/tbody/tr/td[2]/div[1]/a/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 900000);

        try {
            Thread.sleep(90000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}