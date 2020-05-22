import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;

public class RegisterApplication extends MyApplication {

    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button submit;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="Register.fxml";
        title="注册";
        super.start(primaryStage);
    }

    @Override
    protected void WindowInit() {

        super.WindowInit();
    }
}
