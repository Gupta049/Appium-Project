package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LongPress extends Base{
    @Test
    public void longPressTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
        WebElement longPressElem = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

//       TouchAction action = new TouchAction(driver).longPress(longPressOptions().withElement(element(longPressElem)).withDuration(Duration.ofMillis(10000))).release().perform();
//       action.perform();
//       // Thread.sleep(5000);
         ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) longPressElem).getId(), "duration", 4000));
        Thread.sleep(2000);
        WebElement sMenu = driver.findElement(By.id("android:id/title"));
        String peopleText = sMenu.getText();
        Assert.assertEquals(peopleText, "Sample menu");

        boolean display = sMenu.isDisplayed();
        Assert.assertTrue(display);
    }
}
