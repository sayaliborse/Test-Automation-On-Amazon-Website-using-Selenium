import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;


public class Test_Case_3 {
    public static ExtentReports extent;
    public ExtentTest test;

    public void TestCase3() throws InterruptedException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=sdf.format(dt);
        try {
            System.setProperty("webdriver.chrome.driver","bin/chromedriver");
            WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("file:///Users/rajashreenaik/Downloads/SeleniumTestProject/bin/TestCase3.html");
            Thread.sleep(5000);
            driver.get("https://www.amazon.com/");
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_AmazonCom","bin/ScreenShots/","jpg");

            WebElement searchBox=driver.findElement(By.linkText("Sign in"));
            searchBox.click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_SignIn","bin/ScreenShots/","jpg");

            WebElement input_email = driver.findElement(By.name("email"));
            input_email.clear();
            input_email.sendKeys("Group4@gmail.com");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Input_Email","bin/ScreenShots/","jpg");

            WebElement input_pw = driver.findElement(By.name("password"));
            input_pw.sendKeys("****");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Input_Password","bin/ScreenShots/","jpg");

            driver.findElement(By.id("signInSubmit")).click();
            Thread.sleep(100);

            searchBox=driver.findElement(By.name("field-keywords"));
            searchBox.clear();
            searchBox.sendKeys("selenium book");
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Search_Input","bin/ScreenShots/","jpg");

            driver.findElement(By.className("nav-input")).click();
            Thread.sleep(400);
            ScreenCap.cutPic("Test_Case_3_Search_Result","bin/ScreenShots/","jpg");

            driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/div")).click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Choose_Item","bin/ScreenShots/","jpg");

            driver.findElement(By.id("add-to-cart-button")).click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Add_To_Cart","bin/ScreenShots/","jpg");

            String urlBefore = driver.getCurrentUrl();

            driver.findElement(By.cssSelector("#hlb-ptc-btn > span")).click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_3_Check_Out","bin/ScreenShots/","jpg");

            String urlAfter = driver.getCurrentUrl();
            assertFalse(urlAfter == urlBefore);
            test = Test_Case_1_Negative.extent.startTest("Test_Case_3");
            if (!urlAfter.equals(urlBefore)) {
                test.log(LogStatus.PASS, "User successfully proceed to Submit order page.");
            } else {
                test.log(LogStatus.FAIL, "Website failed to proceed.");
            }
            Test_Case_1_Negative.extent.endTest(test);
            Test_Case_1_Negative.extent.flush();
            Thread.sleep(5000);
            driver.get("file:///Users/rajashreenaik/Downloads/SeleniumTestProject/bin/Amazon_Selenium_Testing_Test.html#");
            Thread.sleep(10000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
