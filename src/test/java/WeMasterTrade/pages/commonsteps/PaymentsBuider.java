package WeMasterTrade.pages.commonsteps;

import WeMasterTrade.utils.WebUI;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;


@Data
@NoArgsConstructor

public class PaymentsBuider
{
    private By dropdown;
    private By option;
    private By nameField ;
    private String nameValue ;
    //private String path ;


    public void PaymentsBuider (By dropdown, By option, By nameField, String nameValue )
    {
        this.dropdown = dropdown;
        this.option = option;
        this.nameField = nameField;
        this.nameValue = nameValue;
    }

    public void PaymentsBuider (By nameField, String nameValue)
    {
        this.nameField = nameField;
        this.nameValue = nameValue;
    }

//    public void PaymentsBuider (By nameField, String path)
//    {
//        this.nameField = nameField;
//        this.path = path;
//    }

}
