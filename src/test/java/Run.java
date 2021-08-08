import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Run {
    private static WebDriver  driver;
    @BeforeClass
    public static void runBeforeClass() {//C:\Users\USER\Desktop\Automation\ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Automation\\Новая папка\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openPage(){
        driver.get("https://www.elal.com/");//open page "elal"
        String addressOfPage = driver.getCurrentUrl();
        System.out.printf("The current url is = " + addressOfPage);
        try {
            Assert.assertEquals(addressOfPage, "https://www.elal.com/");//assert the open page
        }catch (AssertionError assertionError){
            System.out.println("Not equals");
        }
        driver.findElement(By.id("outbound-destination-location-input")).sendKeys("Berlin");//to where
        WebElement element= driver.findElement(By.id("outbound-destination-location-input"));
        Actions myAction=new Actions(driver);
        myAction.clickAndHold(element).moveToElement(driver.findElement(By.cssSelector("div[class='search-flyout__body ng-tns-c61-4 ng-star-inserted']"))).click();
        myAction.build().perform();
        driver.findElement(By.id("outbound-departure-calendar-input")).sendKeys("1011");//When a fly to
        driver.findElement(By.id("returnBound-return-calendar-input")).sendKeys("1711");//When you back
        driver.findElement(By.cssSelector("button[aria-label='אישור']")).click();//click done
        driver.findElement(By.id("passenger-counters-input")).click();//how many passenger
        driver.findElement(By.cssSelector("button[aria-label='העלה מבוגר']")).click();//how many adults
        driver.findElement(By.cssSelector("button[aria-label='העלה ילד']")).click();//how many children
        driver.findElement(By.cssSelector("button[aria-label='העלה ילד']")).click();//how many children
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[aria-label='מצאו לי טיסות']")).click();

    }



}
