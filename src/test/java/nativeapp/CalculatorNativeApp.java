package nativeapp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class CalculatorNativeApp {
    public AndroidDriver driver;

    @BeforeClass
    public void setUrl() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("plateformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("plateformVersion", "9.0");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Test(priority = 1)
    public void calculatorAddTest(){
        WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();

        five.click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
    }

    @Test(priority = 2)
    public void calculatorSubTest(){
        WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("minus"));
        plus.click();

        five.click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
    }

    @Test(priority = 3)
    public void calculatorMulTest(){
        WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("multiply"));
        plus.click();

        five.click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
    }

    @Test(priority = 4)
    public void calculatorDivTest(){
        WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("divide"));
        plus.click();

        five.click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
    }

    @Test(priority = 5)
    public void history() throws InterruptedException, IOException {
        WebElement moreOptions = driver.findElement(AppiumBy.accessibilityId("More options"));
        moreOptions.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout")).click();
        Thread.sleep(3000);

        Date date = new Date();
        String lDate = date.toString();
        String formCheDate = lDate.replaceAll(":", "_");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("C:\\Users\\chaitu\\JavaTask\\AppiumTask\\Calculator\\Screenshot\\"+ formCheDate + ".png");
        FileUtils.copyFile(srcFile, desFile);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
