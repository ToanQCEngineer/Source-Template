package WeMasterTrade.drives;

import WeMasterTrade.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        LoggerUtils.info("🧹 [closeDriver] Thread ID: " + Thread.currentThread().getId());
        driver.remove();
    }
}
