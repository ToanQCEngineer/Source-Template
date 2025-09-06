package WeMasterTrade.messages;

import WeMasterTrade.utils.LoggerUtils;

public class InfoMessages {

    // Class InfoMessages: Sử dụng thông báo hiển thị thao tác/ hành động từng bước (step) trong quá trình test hoặc log lại quá trình chạy.


    public static void info (String message)
    {
        LoggerUtils.info(message);
    }

    public static void info (String message, String details)
    {
        LoggerUtils.info(message + details);
    }


}
