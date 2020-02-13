import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertEquals;


public class Test_Case_1_Negative {
    public static ExtentReports extent;
    public ExtentTest test;

    public void TestCase1_Negative() throws InterruptedException {
        try {
            System.setProperty("webdriver.chrome.driver","bin/chromedriver");
            WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("file:///Users/rajashreenaik/Downloads/SeleniumTestProject/bin/TestCase1Negative.html");
            Thread.sleep(5000);
            driver.get("https://www.amazon.com/");
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_AmazonCom","bin/ScreenShots/","jpg");

            WebElement searchBox=driver.findElement(By.linkText("Sign in"));
            searchBox.click();
            searchBox=driver.findElement(By.linkText("Create your Amazon account"));
            searchBox.click();
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_Sign_In","bin/ScreenShots/","jpg");

            WebElement input_name = driver.findElement(By.name("customerName"));
            input_name.clear();
            input_name.sendKeys("Rajashree");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_Input_Name","bin/ScreenShots/","jpg");

            WebElement input_email = driver.findElement(By.name("email"));
            input_email.clear();
            input_email.sendKeys("naik.ra@husky.neu.edu");//input name
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_Input_Email","bin/ScreenShots/","jpg");


            WebElement input_pw = driver.findElement(By.name("password"));
            input_pw.sendKeys("12345678");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_Input_Password","bin/ScreenShots/","jpg");


            WebElement reinput_pw = driver.findElement(By.name("passwordCheck"));
            reinput_pw.sendKeys("125678");//input password
            Thread.sleep(100);
            ScreenCap.cutPic("Test_Case_1_Negative_Password_Check","bin/ScreenShots/","jpg");

            extent = new ExtentReports("bin/Amazon_Selenium_Testing_Test.html", true);

            test = extent.startTest("Test_Case_1_Negative");
            String urlBefore = driver.getCurrentUrl();
            driver.findElement(By.id("continue")).click();
            String urlAfter = driver.getCurrentUrl();
            assertEquals(urlBefore, urlAfter);
            if(urlAfter.equals(urlBefore)){
                test.log(LogStatus.PASS, "User is unable to Register with Password Mismatch");
            }
            else{
                test.log(LogStatus.FAIL, "Website failed to Registration");
            }
            Thread.sleep(5000);
            extent.endTest(test);
            extent.flush();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
