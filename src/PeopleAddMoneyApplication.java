import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PeopleAddMoneyApplication extends MyApplication {
    @FXML
    private TextField moneyTextField;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="PeopleAddMoney.fxml";
        title="转账";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        //todo
    }
}
