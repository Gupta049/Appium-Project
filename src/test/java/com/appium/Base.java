package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\chaitu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
        service.start();
        //Create Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        /*This is for ApiDemos-debugApp*/
//        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\ApiDemos-debug.apk");

        /*This is for GeneralStoreApp*/
        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\General-Store.apk");

        //Create Object for AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//        driver.findElement(By.id("android:id/checkbox")).click();
//        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//        driver.findElement(By.id("android:id/edit")).sendKeys("Network123");
//        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
    public void scrollToEnd(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "left", "percent", 3.0));
        }while (canScrollMore);
    }

    public void scrollToElement(String ele){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\"));"));

    }

    public void swipeAction(WebElement firstImage, String swipeDirection){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "elementId",((RemoteWebElement)firstImage).getId(), "direction", swipeDirection, "percent", 0.20));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
