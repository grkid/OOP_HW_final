import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PeopleAlterInfoApplication extends MyApplication{
    @FXML
    private TextField nameTextField;
    @FXML
    private PasswordField originPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField newPasswordConfirmField;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="PeopleAlterInfo.fxml";
        title="更改信息";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        //todo
    }
}
