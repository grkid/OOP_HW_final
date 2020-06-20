import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class CustomerBuyApplication extends MyApplication {

    @FXML
    private Button submitButton;
    @FXML
    private TextField countText;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerBuyApplication.fxml";
        title="添加至购物车";
        super.start(primaryStage);
    }


    public void onSubmitButtonClicked(javafx.event.ActionEvent event) {
        String t=countText.getText();
        if(Tools.isNumber(t))
        {
            CustomerReadyToBuy.addToBucket(Integer.parseInt(t));
            this.closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("请输入正确的数字。");
        }
    }
}
