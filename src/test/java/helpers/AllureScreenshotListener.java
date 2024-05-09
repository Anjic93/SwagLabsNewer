package helpers;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AllureScreenshotListener extends BaseTest implements IInvokedMethodListener {

    @Override
    public void afterInvocation (IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE || testResult.getStatus() == ITestResult.SKIP) {
            takeAndSaveScreenshot();
        }
    }

    private void takeAndSaveScreenshot() {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                File savedScreenshot = new File("target/screenshots/" + System.currentTimeMillis() + ".jpg");
                FileUtils.copyFile(screenshot, savedScreenshot);
                Allure.addAttachment("Screenshot", new FileInputStream(savedScreenshot));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
