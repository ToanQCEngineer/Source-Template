package WeMasterTrade.listeners;

import WeMasterTrade.reports.ExtentReportManager;
import WeMasterTrade.reports.ExtentTestManager;
import WeMasterTrade.utils.LoggerUtils;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
// Class TestListener: Nơi chứa các hàm dùng để xử lý các sự kiện xảy ra trong quá trình chạy test.
    // VD: chụp hình khi TestCase chạy Fail, Ghi log kết quả test, Gửi báo cáo qua email sau khi chạy xong.

    public String getTestName(ITestResult result)
    {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result)
    {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        LoggerUtils.info("🗓️ Setup environment onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        LoggerUtils.info("🗓️ End all test case: " + result.getEndDate());

        ExtentReportManager.getExtentReports().flush(); //Kết thúc và thực thi Extents Report
    }

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtils.info("🧪 Start run test case: " + result.getName());

        ExtentTestManager.saveToReport(getTestName(result),getTestDescription(result)); //Bắt đầu ghi 1 TCs mới vào Extent Report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtils.info("✅ Test case: " + result.getName() + " is passed");
        ExtentTestManager.logMessage(Status.PASS, result.getName()+ " is passed"); //Extent Report
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Khởi tạo đối tượng result thuộc ITestResult "Interface" để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //Định nghĩa: passed = SUCCESS ( = 1) và failed = FAILURE (= 2)

        LoggerUtils.error("❌ Test case: " + result.getName() + " is failed");
        LoggerUtils.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtils.info("=> Test case: " + result.getName() + " is skipped");
        LoggerUtils.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

}
