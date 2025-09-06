package WeMasterTrade.base;

import WeMasterTrade.utils.LoggerUtils;
import WeMasterTrade.utils.TestContext;
import WeMasterTrade.drives.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {


    @BeforeMethod()
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = setupDriver(browser);
        //PropertiesHelper.loadAllFiles();
        LoggerUtils.info("🧵 [createDriver] Thread ID: " + Thread.currentThread().getId());

        //Set giá trị driver đã dc khởi tạo vào Threadlocal
        DriverManager.setDriver(driver);
    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                LoggerUtils.warn("⚠️ Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver()
    {
        LoggerUtils.info("🚀 Launching Chrome browser...");
        ChromeOptions options = new ChromeOptions();
        if (isCICD())
        {
            System.out.println("Running in CI/CD mode - enabling headless mode");
            options.addArguments("--headless"); // bắt buộc trong CI/CD
            options.addArguments("--no-sandbox"); // fix lỗi quyền
            options.addArguments("--disable-dev-shm-usage"); // fix lỗi bộ nhớ
            options.addArguments("--disable-gpu"); // tốt cho Linux headless
            options.addArguments("--window-size=1920,1080");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
       LoggerUtils.info("Launching Edge browser...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        LoggerUtils.info("Launching Firefox browser...");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
    private static boolean isCICD() {
        return "true".equalsIgnoreCase(System.getenv("CI"));
    }

    @AfterMethod()
    public void closeDriver() {

        if (DriverManager.getDriver() != null)
        {
            DriverManager.quit();
        }
        else // Tránh trường hợp tạo Driver thái bại trả về null
        {
            LoggerUtils.warn("⚠️ No WebDriver instance found for Thread: " + Thread.currentThread().getId());
        }
        TestContext.clear();

    }
}
