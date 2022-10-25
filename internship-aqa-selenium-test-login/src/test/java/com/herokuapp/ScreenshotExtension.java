package com.herokuapp;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class ScreenshotExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable){

    }
}
