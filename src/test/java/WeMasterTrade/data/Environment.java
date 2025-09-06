package WeMasterTrade.data;

import lombok.Data;
import lombok.Getter;


@Getter  //Dùng thư viện lambok: sử dụng @Getter để không phải tạo đi tạo lại nhiều hàm getter.
    public enum Environment
    {
        STG("https://stg3-wmt-bo.wecopytrade.com/", "adminroot", "ejI443?:Vu5L"),
        UAT("https://uat-wmt-bo.wecopytrade.com/wp-admin/", "adminroot", "ejI443?:Vu5L");

        private final String url;
        private final String username;
        private final String password;

        // Constructor (hàm tạo) cho Enum
        Environment(String url, String username, String password)
        {
            this.url = url;
            this.username = username;
            this.password = password;
        }

    }

