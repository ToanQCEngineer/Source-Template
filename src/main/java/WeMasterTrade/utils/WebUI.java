package WeMasterTrade.utils;

import WeMasterTrade.drives.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class WebUI {
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGELOAD_TIMEOUT = 10;



    //Thread.currentThread().getStackTrace()[1].getMethodName(): Dùng để lấy tên hàm không phải là Annotation (@Test)
    //getStackTrace()[0]: Gọi hàm StackTrace
    //getStackTrace()[1]: Trả về hàm hiện tại  (VD: Hàm test gọi hàm String getMethodName, nó sẽ Trả về hàm String getMethodName)
    //getStackTrace()[2]: Trả về hàm mà gọi tới nó. (VD: Hàm test gọi hàm String getMethodName, nó sẽ Trả về hàm Test)
    public static String getMethodName (int stackIndex)
    {
        return Thread.currentThread().getStackTrace()[stackIndex].getMethodName();
    }


    //Lấy token từ Local storage và gán vào hàm setToken để lưu giữ dữ liệu
    public static void saveTokenFromLocalStorage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String token = (String) js.executeScript("return window.localStorage.getItem('accessToken');");
        TestContext.setToken(token);
        System.out.println("setToken: " + token);
    }

    //Lấy URL và chỉ lấy phần cuối của URL và gán vào hàm setTicketId để lưu giữ dữ liệu.
    public static void saveTicketIdFromCurrentUrl() {
        String currentUrl = getCurrentUrl(); // Lấy URL
        String ticketId = currentUrl.substring(currentUrl.lastIndexOf("/") + 1); // từ URL => chỉ lấy phần cuối của URL
        TestContext.setTicketId(ticketId);
        System.out.println("setTicketID: " + ticketId);
    }

    public static void saveScreenshot(String name) {
        try {
            // Chụp màn hình từ Driver hiện tại
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Tạo thư mục nếu chưa có
//
            String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";
            File theDir = new File(screenshotDir);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }

            // Tạo timestamp để tránh trùng file
            String timestamp = new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(new Date());
            String filePath = screenshotDir + name + "_" + timestamp + ".png";
            //String filePath = "C:\\Screenshots\\" + name + "_" + timestamp + ".png";

            // Lưu file ảnh
            FileHandler.copy(source, new File(filePath));
            LoggerUtils.info("✅📸 Screenshot saved success: " + filePath);

        } catch (Exception e) {
            LoggerUtils.error("❌📸 Error while saving screenshot: " + e.getMessage());
        }
    }

    public void hoverOnElement(By by) {
        waitForElementVisible(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(getElement(by));
        LoggerUtils.info("=> Hover on element " + by);
    }

    public static void uploadFile_Sendkey(By by, String filePath) {
        waitForElementVisible(by);
        WebElement fileInput = DriverManager.getDriver().findElement(by);
        fileInput.sendKeys(filePath);
    }


    public static void uploadFile_Robot(By by, String filePath) {
        //Click để mở form upload
        clickElement(by);
        sleep(Sleeps.WAIT_TWO);
        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        sleep(Sleeps.WAIT_ONE);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        sleep(Sleeps.WAIT_ONE);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        sleep(Sleeps.WAIT_TWO);

        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        sleep(Sleeps.WAIT_ONE);

    }

    public static WebElement highLightElement(By by) {
        waitForElementVisible(by);
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getElement(by));
            sleep(1);
        }
        return getElement(by);
    }

    public void rightClickElement(By by) {
        waitForElementVisible(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(getElement(by));
        LoggerUtils.info("=> Right click on element: " + by);
    }

    public static void logConsole(String message) {
        System.out.println(message);

    }

    public static void openURL(String URL) {
        DriverManager.getDriver().get(URL);
        waitForPageLoaded();
        LoggerUtils.info("🌐 Open URL:" + URL);

    }

    public static String getCurrentUrl() {
        waitForPageLoaded();
        LoggerUtils.info("🌐 Get CurrentUrl URL: " + DriverManager.getDriver().getCurrentUrl());
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static WebElement getElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }


    public static void clickElement(By by) {
        waitForElementVisible(by);
        getElement(by).click();
        LoggerUtils.info("=> Click on Element: " + by);
    }

    public static void setText(By by, String value) {
        waitForElementVisible(by);
        getElement(by).sendKeys(value);
        LoggerUtils.info("=> Set Text: " + value + " on Element " + by);
    }

    public static String getTextElement(By by) {
        waitForElementVisible(by);
        //LoggerUtils.info("=> Get text of Element: " + by); // Tạm đóng, khi cần thì Enable (Giảm tối thiểu logs nhiều Element khi Run)
        LoggerUtils.info("=> Text: " + getElement(by).getText());
        return getElement(by).getText();
    }

    public static String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        LoggerUtils.info("=> Get Attribute of Element: " + by);
        LoggerUtils.info("=> Value: " + getElement(by).getAttribute(attributeName));
        return getElement(by).getAttribute(attributeName);
    }

    public static void actionSrollToElement(By by) {
        waitForElemenpresence(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(getElement(by)).build().perform();
        LoggerUtils.info("=> Scroll to Element: " + by);
    }

    public static void actionClickElement(By by) {
        waitForElemenpresence(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.click(WebUI.getElement(by)).build().perform();
        LoggerUtils.info("=> Click on Element: " + by);
    }

    public static void actionDoubleClickElement(By by) {
        waitForElemenpresence(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.doubleClick(getElement(by)).build().perform();
        LoggerUtils.info("=> Double Click Element: " + by);
        //logConsole("Srool to Element " + by);
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            LoggerUtils.error("❌ Error Element not visible: " + by);
            throw e;
        }
    }

    public static void waitForElemenpresence(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(By.xpath(xpath));
        if (listElement.size() > 0) {
            LoggerUtils.info("Element " + xpath + "exiting.");
            return true;
        } else {
            LoggerUtils.error("❌ Element" + xpath + "NOT exits.");
            return false;
        }
    }

    //Kiểm tra phần tử có tồn tại trong DOM
    public static boolean verifyElementVisible(By by) {
        LoggerUtils.info("🔍 Start verifying element is visible: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LoggerUtils.info("✅ Element is visible: " + by);
            return true;
        } catch (TimeoutException e) {
            LoggerUtils.warn("⚠️ Element is NOT visible: " + by);
            return false;
        }

    }


    //Kiểm tra phần tử có tồn tại nhưng không hiển thị. (Chờ Element không hiển thị)
    public static boolean verifyElementNOTVisible(By by) {
        LoggerUtils.info("🔍 Start verify Element NOT Visible: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            LoggerUtils.info("✅ Element is NOT visible: " + by);
            return true;
        } catch (TimeoutException e) {
            LoggerUtils.warn("⚠️ Element is still visible: " + by);
            return false;
        }

    }

    //kiểm tra phần tử có trong DOM hay không.
    public static boolean verifyElementNotPresent(By by) {
        LoggerUtils.info("=> 🔍Start verify Element NOT Present: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LoggerUtils.debug("Element is present: " + by);
            return false;
        } catch (TimeoutException e) {
            LoggerUtils.warn("⚠️ Element is NOT present: " + by);
            return true;
        }

    }

    //     * Wait for Page loaded
//     * Chờ đợi trang tải xong (Javascript tải xong)
//     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGELOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LoggerUtils.warn("⚠️ Javascript NOT Ready, please wait a moment.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                LoggerUtils.error("❌ FAILED. Timeout waiting for page load.");
            }
        }
    }
}
