import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PeopleWithdrawMoneyApplication extends MyApplication {
    @FXML
    private TextField withdrawMoneyTextField;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="PeopleWithdrawMoney.fxml";
        title="提现";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        String money=withdrawMoneyTextField.getText();
        boolean isNum=money.equals(String.valueOf(Double.parseDouble(money))) || money.equals(String.valueOf(Integer.parseInt(money)));
        if(withdrawMoneyTextField.getText().equals("") || !isNum)
        {
            ;InfoApplication.showMessage("请输入正确的数字。");
            return;
        }

        String result=People.getInstance().RequestWithdrawMoney(People.getInstance().getId(),Double.parseDouble(money));
        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("提现成功，请刷新个人信息。");
            People.getInstance().setMoney(People.getInstance().getMoney()-Double.parseDouble(money));
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("提现失败，请检查余额是否足够。");
        }
    }
}
