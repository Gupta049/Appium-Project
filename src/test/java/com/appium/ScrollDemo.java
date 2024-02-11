package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends Base{
    @Test
    public void scrollDemoTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll until view an element

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"));"));

//        driver.findElement(AppiumBy.xpath("//*[contains(@text,'Lists')]")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))")).click(); //scroll down to the element and click
        Thread.sleep(5000);

//        String list = "Lists";
        //scrollToElement("Lists");
        //scroll as long as the App has elements.
       /* boolean canScrollMore;
        do {
            canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
        }while (canScrollMore);*/
        scrollToEnd();
    }
}
