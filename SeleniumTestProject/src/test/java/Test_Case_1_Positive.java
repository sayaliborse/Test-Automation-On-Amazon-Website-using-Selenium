import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class Test_Case_1_Positive {
    public static ExtentReports extent;
    public ExtentTest test;

    public void TestCase1_Positive() throws InterruptedException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String date="";
        try {
            System.setProperty("webdriver.chrome.driver","bin/chromedriver");
            WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("file:///Users/rajashreenaik/Downloads/SeleniumTestProject/bin/TestCase1Positive.html");
            Thread.sleep(5000);
            driver.get("https://www.amazon.com/");
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_AmazonCom","bin/ScreenShots/","jpg");

            WebElement searchBox=driver.findElement(By.linkText("Sign in"));
            searchBox.click();
            searchBox=driver.findElement(By.linkText("Create your Amazon account"));
            searchBox.click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_Create_Acc","bin/ScreenShots/","jpg");

            WebElement input_name = driver.findElement(By.name("customerName"));
            input_name.clear();
            input_name.sendKeys("Group4");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_Input_Name","bin/ScreenShots/","jpg");

            WebElement input_email = driver.findElement(By.name("email"));
            input_email.clear();
            input_email.sendKeys("test"+sdf+"@gmail.com");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_Input_Email","bin/ScreenShots/","jpg");


            WebElement input_pw = driver.findElement(By.name("password"));
            input_pw.sendKeys("12345678");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_Input_Password","bin/ScreenShots/","jpg");


            WebElement reinput_pw = driver.findElement(By.name("passwordCheck"));
            reinput_pw.sendKeys("12345678");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Positive_Password_Check","bin/ScreenShots/","jpg");

            String urlBefore = driver.getCurrentUrl();
            driver.findElement(By.id("continue")).click();
            String urlAfter = driver.getCurrentUrl();
            assertFalse(urlAfter == urlBefore);
            test = Test_Case_1_Negative.extent.startTest("Test_Case_1_Positive");
            if(!urlAfter.equals(urlBefore)){
                test.log(LogStatus.PASS, "New User able to register on Amazon.com");
            }
            else{
                test.log(LogStatus.FAIL, "Website failed registration");
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
