import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenCap {

    public static void cutPic(String imageName,String path,String imgType) throws AWTException, IOException{
        Dimension screenSz = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(screenSz);
        Robot robo = new Robot();
        BufferedImage image = robo.createScreenCapture(screenRect);
        ImageIO.write(image,imgType, new File(path+ Selenium_Chrome_Test.date+"/"+imageName+"."+imgType));

    }
}