package installed;

import com.appium.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToastMsgTest extends Base {
    @Test
    public void toastMsgTest(){
        //Scroll and Select India from the dropdown
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
//        //Type name in text field
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arpita");
//        driver.hideKeyboard(); // for hiding keyboard
        //select radio button
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // inspect toast message and get the text tagName=android.widget.Toast
        String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("text");
        Assert.assertEquals(toastMsg, "Please enter your name");
    }
}
