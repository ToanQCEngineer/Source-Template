package WeMasterTrade.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static boolean isInitialized = false;

    public synchronized static ExtentReports getExtentReports() {

        if (!isInitialized)
        {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentreport/extentreport.html");
            reporter.config().setReportName("Project Automation Testing WeMasterTrade"); //Đặt tên tiêu đề cho report HTML.
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Framework Name", "Selenium Java | Project WeMasterTrade");
            extentReports.setSystemInfo("Author", "toan.trinh@lfglobaltech.com");
            extentReports.setSystemInfo("Environment", "Staging");
            extentReports.setSystemInfo("Browser", "Chrome Headless");
            isInitialized= true;
        }
        return extentReports;

    }
}
