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
        //todo
    }
}
