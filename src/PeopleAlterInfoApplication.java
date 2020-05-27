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
        if(!nameTextField.getText().equals(""))
        {
            String newName=nameTextField.getText().replace(" ","");
            String result=People.getInstance().RequestAlterName(People.getInstance().getId(),newName);
            String[] results=result.split(" ");
            if(results.length==2 && results[1].equals(Str.success.strip()))
            {
                InfoApplication.showMessage("修改名称成功，新的名称为："+newName+"。请刷新个人信息。");
                People.getInstance().setName(newName);
            }
            else
            {
                InfoApplication.showMessage("修改名称失败，请检查网络连接。");
                return;
            }
        }
        if(
                !originPasswordField.getText().equals("")
                &&!newPasswordField.getText().equals("")
                &&!newPasswordConfirmField.getText().equals("")
        )
        {
            if(!newPasswordField.getText().equals(newPasswordConfirmField.getText()))
            {
                InfoApplication.showMessage("两次输入的密码不相同，请检查输入。");
                newPasswordField.clear();
                newPasswordConfirmField.clear();
                return;
            }
            if(!originPasswordField.getText().equals(People.getInstance().getPassword()))
            {
                InfoApplication.showMessage("输入的原始密码错误。");
                return;
            }
            String result=People.getInstance().RequestAlterPassword(People.getInstance().getId(),originPasswordField.getText(),newPasswordField.getText());
            String[] results=result.split(" ");
            if(results.length==2 && results[1].equals(Str.success.strip()))
            {
                InfoApplication.showMessage("修改密码成功。");
                People.getInstance().setPassword(newPasswordField.getText());
            }
            else
            {
                InfoApplication.showMessage("修改密码失败，请检查网络连接。");
                return;
            }

        }
        closeWindow(event);
    }
}
