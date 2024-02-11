package installed;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.model.TouchPoint;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AmazonInstalled {
//    com.amazon.mShop.android.shopping
//public AndroidDriver driver;
//
//    @BeforeTest
//    public void setUrl() throws MalformedURLException {
//        DesiredCapabilities dc = new DesiredCapabilities();
//
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("deviceName", "emulator-5554");
//        dc.setCapability("platformVersion", "9.0");
//        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
//        dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
//    }

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        desiredCapabilities.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("nativeWebScreenshot", true);
        desiredCapabilities.setCapability("newCommandTimeout", 3600);
        desiredCapabilities.setCapability("connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void run() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement skipSignIn = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button"));
        skipSignIn.click();
        Thread.sleep(4000);
        WebElement searchField = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Search']"));
        searchField.click();
//        Thread.sleep(4000);
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Iphone");
//        searchField.sendKeys("Realme");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"iPhone SE 2 64GB Black LTE Cellular Boost Mobile MHHF3LL/A\"));"));

        WebElement item = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[2]"));
        item.click();
        Thread.sleep(3000);

//        int startY = (driver.manage().window().getSize().getHeight()*4/5);
//        int endY = (driver.manage().window().getSize().getHeight() / 60);
//
//        TouchAction tAction = new TouchAction(driver);
//        tAction.press(PointOption.point(0, startY)).moveTo(PointOption.point(0, endY)).release().perform();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));"));
        driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.id("com.amazon.mShop.android.shopping:id/bottom_tab_button_icon")).click();
        driver.findElement(By.xpath("(//androidx.appcompat.app.ActionBar.Tab)[3]")).click();

        driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
         //com.amazon.mShop.android.shopping:id/right_button

//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"iPhone X, US Version, 64GB, Space Gray - Fully Unlocked\"));"));
//        //Apple iPhone SE 2nd Generation, US Version, 64GB, Black - Unlocked (Renewed), iPhone X, US Version, 64GB, Space Gray - Fully Unlocked
    }
}
