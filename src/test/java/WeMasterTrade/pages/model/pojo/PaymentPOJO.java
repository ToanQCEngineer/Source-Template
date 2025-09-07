package WeMasterTrade.pages.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@Data
@NoArgsConstructor

public class PaymentPOJO {

    private By dropdown;
    private By option;
    private By nameField;
    private String nameValue;
    private By logoField;
    private String logoPath;

}
