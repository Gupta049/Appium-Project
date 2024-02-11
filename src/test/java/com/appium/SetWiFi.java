package com.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SetWiFi extends Base{
    @Test
    public void setWiFiTest() throws InterruptedException {
        System.out.println("Hello child class started successfully");
        Thread.sleep(3000);
        WebElement pref = driver.findElement(AppiumBy.accessibilityId("Preference"));
        pref.click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Network123");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
