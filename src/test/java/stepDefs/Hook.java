package stepDefs;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
//        WebDriverManager.edgedriver().setup();
//        base.driver = new EdgeDriver();
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        //takeAScreenShot();
        Thread.sleep(3000);
        base.driver.close();
        base.driver.quit();
    }

    public void takeAScreenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) base.driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("target/screenshorts/screenshort" + System.currentTimeMillis() + ".png"));
    }
}
