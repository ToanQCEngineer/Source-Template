package WeMasterTrade.messages;

import WeMasterTrade.utils.LoggerUtils;

public class SuccessMessages {
    //Class Success Messages: Sử dụng Thông báo khi thao tác thành công (thêm, xoá, cập nhật, đăng ký...) | icon : 🎫, 🔍


    public static void createDataSuccess(String message)
    {
        LoggerUtils.info("✅ " + message);
    }

    public static void createDataSuccess(String message, String details)
    {
        LoggerUtils.info("✅ " + message + details);
    }
    public static void getDataSuccess(String message)
    {
        LoggerUtils.info(message);
    }
    public static void getDataSuccess(String message, String details)
    {
        LoggerUtils.info(message + details);
    }

    public static void loginSuccess(String message)
    {
        LoggerUtils.info("✅ " + message);
    }
    public static void loginSuccess(String message, String details)
    {
        LoggerUtils.info("✅ " + message + details);
    }

    public static void searchSuccess(String message)
    {
        LoggerUtils.info("✅ " + message);
    }
    public static void searchSuccess(String message, String details)
    {
        LoggerUtils.info("✅ " + message + details);
    }


}
