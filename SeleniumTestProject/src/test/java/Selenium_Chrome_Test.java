import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Selenium_Chrome_Test {
    public static String DATE(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        File file = new File("bin/ScreenShots/"+sf.format(date));
        if(!file.exists()){
            file.mkdir();
        }
        return sf.format(date);
    }
    public static String date = Selenium_Chrome_Test.DATE();

    public static void main(String[] args) {
        Test_Case_1_Negative Case1Negative = new Test_Case_1_Negative();
        Test_Case_1_Positive Case1Positive = new Test_Case_1_Positive();
        Test_Case_2 case2 = new Test_Case_2();
        Test_Case_3 case3 = new Test_Case_3();
        try {
            Case1Negative.TestCase1_Negative();
            Case1Positive.TestCase1_Positive();
            case2.TestCase2();
            case3.TestCase3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}