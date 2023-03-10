package org.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumUtils {
    public AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//akhizchnyakova//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;
    }
}
