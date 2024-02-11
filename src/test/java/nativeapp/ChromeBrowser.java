package nativeapp;

import com.google.common.collect.ImmutableMultimap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser {

    public AndroidDriver driver;

    @BeforeClass
    public void setUrl() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        dc.setCapability("chromedriverExecutable", "C:\\Users\\chaitu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        dc.setCapability("chromeOptions", ImmutableMultimap.of("w3c", false));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }
    @Test
    public void run() throws InterruptedException {
        driver.get("https://www.amazon.in");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.click();
        search.sendKeys("Realme");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='puisg-col-inner'])[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//span[@class='a-size-base a-color-attainable added-to-cart-success a-text-bold']"));
        String succesMsg = text.getText();
        driver.findElement(By.xpath("//span[@class='a-sheet-close a-focus-hidden']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nav-cart-count")).click();
        WebElement plusIcon = driver.findElement(By.xpath("//span[@class='a-size-extra-large']"));
        plusIcon.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='a-declarative'])[8]")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Continue shopping")).click();

        Assert.assertEquals(succesMsg,"Added to cart");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
