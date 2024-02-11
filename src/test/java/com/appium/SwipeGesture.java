package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeGesture extends Base{
    @Test
    public void swipeGestureTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();

        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        String firstTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals("true", firstTimeValue);
//      perform swipe action
        swipeAction(firstImage, "left");
//        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "elementId",((RemoteWebElement)firstImage).getId(), "direction", "left", "percent", 0.20));
        Thread.sleep(6000);
        String secondTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals("false", secondTimeValue);
    }
}
