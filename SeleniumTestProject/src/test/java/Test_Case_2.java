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


public class Test_Case_2 {
    public static ExtentReports extent;
    public ExtentTest test;

    public void TestCase2() throws InterruptedException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=sdf.format(dt);
        try {
            System.setProperty("webdriver.chrome.driver","bin/chromedriver");
            WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("file:///Users/rajashreenaik/Downloads/SeleniumTestProject/bin/TestCase2.html");
            Thread.sleep(5000);
            driver.get("https://www.amazon.com/");
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_2_AmazonCom","bin/ScreenShots/","jpg");

            WebElement searchBox=driver.findElement(By.linkText("Sign in"));
            searchBox.click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_2_SignIn","bin/ScreenShots/","jpg");

            WebElement input_email = driver.findElement(By.name("email"));
            input_email.clear();
            input_email.sendKeys("Group4@gmail.com");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_2_Input_Email","bin/ScreenShots/","jpg");


            WebElement input_pw = driver.findElement(By.name("password"));
            input_pw.sendKeys("12345678");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_2_Password","bin/ScreenShots/","jpg");


            String urlBefore = driver.getCurrentUrl();
            driver.findElement(By.id("signInSubmit")).click();
            String urlAfter = driver.getCurrentUrl();
            assertFalse(urlAfter == urlBefore);
            test = Test_Case_1_Negative.extent.startTest("TestCase2");
            if (!urlAfter.equals(urlBefore)) {
                test.log(LogStatus.PASS, "User was successfully Signed-in");
            } else {
                test.log(LogStatus.FAIL, "Website failed sign in");
            }
            Test_Case_1_Negative.extent.endTest(test);
            Test_Case_1_Negative.extent.flush();
            Thread.sleep(5000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
