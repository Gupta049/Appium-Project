package installed;

import dev.failsafe.Timeout;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FacebookAppEmu {
    public AndroidDriver driver;

    @BeforeTest
    public void setUrl() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("appPackage", "com.facebook.katana");
        dc.setCapability("appActivity", "com.facebook.katana.LoginActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18000));
        WebElement mobileOrEmail = driver.findElement(By.xpath("(//android.view.View)[3]"));
        mobileOrEmail.click();
        driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("6205806083");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("(//android.view.View)[4]"));
        password.click();
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Sushil@049");
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//android.view.View)[5]")).click();
        Thread.sleep(8000);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
        Thread.sleep(3000);
        WebElement mobileField = driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
        mobileField.sendKeys("6205806083");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Find account']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Continue']")).click();
        Thread.sleep(3000);
        WebElement againPassword = driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
        againPassword.sendKeys("Sushil@049");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Log in']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Continue']")).click();
        WebElement code = driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
        code.sendKeys("575206");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Continue']")).click();

        //        driver.findElement(By.xpath("(//android.view.ViewGroup)[4]")).click();
//        Thread.sleep(2000);
//        driver.findElement(AppiumBy.accessibilityId("Continue in English (US)")).click(); ////android.view.ViewGroup)[13]
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Allow']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    }
}
