package com.herokuapp;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import java.util.Optional;

import static com.herokuapp.WebDriverSettings.driver;

@Slf4j
public class ScreenshotExtension implements TestWatcher {

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable){
        log.info("test failed");
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        log.info("screenshot");
        driver.close();
        driver.quit();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        driver.close();
        driver.quit();
    }


}
