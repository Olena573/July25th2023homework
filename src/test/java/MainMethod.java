import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;


public class MainMethod {
    public static void main (String [] args){
       // System.getProperty("C:\\QA_Automation_Studying\\", "chromedriver.exe");
        // I've left this "System.getProperty..." in comments, because I want to have it written down somewhere.
        // And just in case, because I have Chrome 15.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //here I have longer locators in comments; I saved them because they work and with them I can test shorter ones.

        // By result = By.xpath("/html/body/div[3]/h1/span[1]");
       // By shorterResult1 = By.xpath("/html//div[3]//span[1]");
        By shorterResult = By.xpath("//*[@id=\"firstHeading\"]/span[1]");
        // By search = By.xpath("//input=[@name='search']");
       //  By firstHeader = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[4]/ul/li[1]/table/tbody/tr/td[2]/div[1]/a");
        //Here I have a bit shorter xpath, which works too.
      //  By secondxpathHeader = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[4]//li[1]//td[2]/div[1]/a");
        By thirdxpathHeader = By.xpath("//span[text() ='Ubisoft']/..");
       // By fourthxpathHeader = By.xpath("//a[contains(a href='/wiki/Ubisoft')]");


        //Here a program opens a Wikipedia page.
        getWiki (driver);

        //here we saved an id of the window;
       // driver.findElement(firstHeader).click();

        searchInput (driver);
        //Here we searched for the Ubisoft;

        driver.findElement(thirdxpathHeader).click();
        //Here we clicked on the required result in the search list.

        WebDriverWait wait = new WebDriverWait(driver, 15);

      //  assert "Ubisoft" == getText(driver, shorterResult);

        assertEquals("",  getText(driver, shorterResult));


    }

    static void getWiki (WebDriver driver) {
        driver.get("https://uk.wikipedia.org");
        //I've used the Ukrainian Wikipedia. And I've used a short link on it.
        driver.manage().window().fullscreen();
        System.out.println (driver.getWindowHandle());
        //I've decided to put everything in separate methods too.
    }

    static void searchInput (WebDriver driver){
        driver.findElement(By.id("searchInput")).sendKeys("Ubisoft");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        //Here we searched for the Ubisoft: entered it's name and pressed "Enter" key.
    }

    static String getText (WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        // Here I've used a shorter wait time.
        return wait.until(d ->driver.findElement(locator)).getText();

    }
}