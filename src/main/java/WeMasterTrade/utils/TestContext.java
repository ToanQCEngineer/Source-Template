package WeMasterTrade.utils;

public class TestContext {

    private static final ThreadLocal<String> token = new ThreadLocal<>();
    private static final ThreadLocal<String> ticketId = new ThreadLocal<>();


    public static void setToken(String value) {
        token.set(value);
        LoggerUtils.info("setToken: " + value);
    }

    public static String getToken() {
        return token.get();
    }

    public static void removeToken() {
        String removedToken = getToken(); // Gọi và Lưu lại Token
        token.remove(); // Remove Token
        LoggerUtils.info("🗝️ Removed Token: " + removedToken);

    }

    public static void setTicketId(String value) {
        ticketId.set(value);
        LoggerUtils.info("setTicketID : " + value);
        LoggerUtils.info("==================== End Stage Create API Ticket  ====================");
    }

    public static String getTicketId() {
        return ticketId.get();
    }

    public static void removeTicketId() {
        String removedticketId = getTicketId(); // Gọi và Lưu lại TicketId
        ticketId.remove(); // Remove ticketId
        LoggerUtils.info("🗑️🎫 Removed TicketID: " + removedticketId);
    }

    public static void clear() {
        removeToken();
        removeTicketId();
    }


}
