import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterApplication extends MyApplication {

    @FXML
    private ChoiceBox<String> type;
    @FXML
    private TextField nameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="Register.fxml";
        title="注册";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) throws Exception
    {
        String t=type.getValue();
        if(t.equals("用户"))
            t=Str.customer;
        else if(t.equals("商家"))
            t=Str.seller;
        else if(t.equals("一类会员用户（一元优惠）"))
            t=Str.customerDiscount1;
        else if(t.equals("二类会员用户（九五折优惠）"))
            t=Str.customerDiscount2;
        else//管理员
            t=Str.admin;

        String name=nameTextField.getText();
        String password1=passwordField.getText();
        String password2=confirmPasswordField.getText();

        if(!password1.equals(password2)) {
            InfoApplication.showMessage("两次输入的密码不一致，请重新输入密码。");
            passwordField.clear();
            confirmPasswordField.clear();
            return;
        }

        String result=People.RequestRegister(t,password1,name);
        String[] results=result.split(" ");
        if(results.length==3 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("注册成功，您的ID为："+results[2]+"。请牢记。");
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("注册失败，请检查是否正确连接到服务器。");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.setItems(FXCollections.observableArrayList("用户","一类会员用户（一元优惠）","二类会员用户（九五折优惠）","商家","管理员"));
    }
}
