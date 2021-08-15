import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void openPage() throws InterruptedException {
        driver.get("https://www.elal.com/");//open page "elal"
        String addressOfPage = driver.getCurrentUrl();
        System.out.printf("The current url is = " + addressOfPage);
        try {
            Assert.assertEquals(addressOfPage, "https://www.elal.com/");//assert the open page
        }catch (AssertionError assertionError){
            System.out.println("Not equals");
        }

        //FIRST PAGE
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
        driver.findElement(By.cssSelector("button[aria-label='מצאו לי טיסות']")).click();



        //SECOND PAGE
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains("https://booking.elal.com/booking/flights?market=IL&lang=he"));
        driver.findElement(By.xpath("//*[@id=\"uiFlightPanel0\"]/div[3]/ui-panel/div/div[2]/div[2]/div[1]/ui-bound/div/div[1]/div[2]/div[1]/div[2]")).click();//choose when you fly to
        driver.findElement(By.cssSelector("div[class='ui-bound__price__selector ng-tns-c61-19']")).click();//choose when you fly back
        driver.findElement(By.cssSelector("div > ui-checkbox > div > div > span > ui-svg-picto > div")).click();//check box
        driver.findElement(By.id("cart-continueMainCta")).click();







        //THIRD PAGE
        //first Adult
        wait.until(ExpectedConditions.urlContains("https://booking.elal.com/booking/passengers"));
        driver.findElement(By.cssSelector("input[id='form-0-firstName']")).sendKeys("Bob");//first name
        driver.findElement(By.cssSelector("input[id='form-0-lastName']")).sendKeys("Sfoug");//last name
        driver.findElement(By.cssSelector("input[id='form-0-year']")).sendKeys("1985");//birth year
        driver.findElement(By.cssSelector("input[id='form-0-month']")).sendKeys("06");//birth month
        driver.findElement(By.cssSelector("input[id='form-0-day']")).sendKeys("13");//birth day
        driver.findElement(By.id("form-0-civility")).click();//drop down menu
        driver.findElement(By.cssSelector("div > div.ui-select__dropdown.flyout.ng-tns-c72-25.ng-trigger.ng-trigger-flyState > div:nth-child(1)")).click();//choose hwo you are
        driver.findElement(By.cssSelector("input[id='form-0-email']")).sendKeys("dollar1306@gmail.com");//email
        driver.findElement(By.cssSelector("input[id='form-0-number']")).sendKeys("502448568");//phone number

        driver.findElement(By.id("cart-nextPaxMainCta")).click();//next passenger


        //THIRD PAGE
        //second Adult
        driver.findElement(By.cssSelector("input[id='form-1-firstName']")).sendKeys("Tuty");//first name
        driver.findElement(By.cssSelector("input[id='form-1-lastName']")).sendKeys("Fruty");//last name
        driver.findElement(By.cssSelector("input[id='form-1-year']")).sendKeys("1986");//birth year
        driver.findElement(By.cssSelector("input[id='form-1-month']")).sendKeys("03");//birth month
        driver.findElement(By.cssSelector("input[id='form-1-day']")).sendKeys("17");//birth day
        driver.findElement(By.id("form-1-civility")).click();//drop down menu
        driver.findElement(By.cssSelector("div > div.ui-select__dropdown.flyout.ng-tns-c72-32.ng-trigger.ng-trigger-flyState > div:nth-child(2) > div")).click();//choose hwo you are
                                            //div > div.ui-select__dropdown.flyout.ng-tns-c72-25.ng-trigger.ng-trigger-flyState > div:nth-child(1)
        driver.findElement(By.id("cart-nextPaxMainCta")).click();//next passenger



        //THIRD PAGE
        //first child
        driver.findElement(By.cssSelector("input[id='form-2-firstName']")).sendKeys("Pink");//first name
        driver.findElement(By.cssSelector("input[id='form-2-lastName']")).sendKeys("Panther");//last name
        driver.findElement(By.cssSelector("input[id='form-2-year']")).sendKeys("2011");//birth year
        driver.findElement(By.cssSelector("input[id='form-2-month']")).sendKeys("08");//birth month
        driver.findElement(By.cssSelector("input[id='form-2-day']")).sendKeys("12");//birth day
        driver.findElement(By.id("cart-nextPaxMainCta")).click();//next passenger


        //THIRD PAGE
        //second child
        driver.findElement(By.cssSelector("input[id='form-3-firstName']")).sendKeys("rainbow");//first name
        driver.findElement(By.cssSelector("input[id='form-3-lastName']")).sendKeys("dash");//last name
        driver.findElement(By.cssSelector("input[id='form-3-year']")).sendKeys("2014");//birth year
        driver.findElement(By.cssSelector("input[id='form-3-month']")).sendKeys("04");//birth month
        driver.findElement(By.cssSelector("input[id='form-3-day']")).sendKeys("29");//birth day
                                //cart-continueMainCta
        driver.findElement(By.cssSelector("button[id='cart-continueMainCta']")).click();//next page




        //FOUR PAGE
        wait.until(ExpectedConditions.urlContains("https://booking.elal.com/booking/ancillaries"));
        driver.findElement(By.cssSelector("#anc-baggage-container > anc-bag > div > anc-header > div > div.anc-header__action.col-md-3.center-xs > anc-button > button")).click();//choose add suitcase
        driver.findElement(By.cssSelector("div > anc-pax-bags:nth-child(1) > div > div > div.pax-bags__bags > anc-bags-selection > div > form > div > label")).click();//add suitcase
        driver.findElement(By.cssSelector("div > anc-pax-bags:nth-child(2) > div > div > div.pax-bags__bags > anc-bags-selection > div > form > div > label")).click();//add suitcase
        driver.findElement(By.id("cart-checkoutMainCta")).click();//next page





        //FIFTH PAGE
        wait.until(ExpectedConditions.urlContains("https://booking.elal.com/booking/ancillaries"));
        driver.findElement(By.id("picto_check")).click();//i agree
        driver.findElement(By.id("cart-payMainCta")).click();//next page

    }

}
