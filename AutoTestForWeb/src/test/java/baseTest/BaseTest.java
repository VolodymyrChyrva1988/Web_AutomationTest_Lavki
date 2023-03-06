package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

protected WebDriver webDriver;
Logger logger = Logger.getLogger(getClass());


@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

}
@After
    public void TearDown(){
webDriver.quit();
logger.info("Browser was closet");
}
}
