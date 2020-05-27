import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PeopleAddMoneyApplication extends MyApplication {
    @FXML
    private TextField moneyTextField;
    @FXML
    private Button submitButton;
    @FXML
    private ImageView img;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="PeopleAddMoney.fxml";
        title="转账";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo 图片加载失败
        //img.setImage(new Image("/pic_resource/Alipay.jpg"));
    }

    public void onSubmitButtonClick(ActionEvent event) {
        String money=moneyTextField.getText();
        boolean isNum=money.equals(String.valueOf(Double.parseDouble(money))) || money.equals(String.valueOf(Integer.parseInt(money)));
        if(moneyTextField.getText().equals("") || !isNum)
        {
            ;InfoApplication.showMessage("请输入正确的数字。");
            return;
        }

        String result=People.getInstance().RequestAddMoney(People.getInstance().getId(),Double.parseDouble(money));
        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("充值成功，请刷新个人信息。");
            People.getInstance().setMoney(People.getInstance().getMoney()+Double.parseDouble(money));
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("充值失败，请检查网络连接。");
        }
    }
}
