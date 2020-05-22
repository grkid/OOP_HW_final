import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//这个类作为程序入口较为特殊，无法继承MyApplication
public class LoginApplication extends Application {
    protected Stage stage=new Stage();

    protected String fxmlFileName="Login.fxml";

    protected String title="登录";

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField userIDTextField;
    @FXML
    private PasswordField userPasswordTextField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(fxmlFileName+" "+title);
        Parent root= FXMLLoader.load(getClass().getResource(fxmlFileName));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root,600,400));
        WindowInit();
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    protected void WindowInit()
    {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
            }
        });

    }

    public void onRegisterButtonClick(ActionEvent event) throws Exception
    {
        RegisterApplication r=new RegisterApplication();
        r.showWindow();
    }

    public void onLoginButtonClick(ActionEvent event) {
        String id=userIDTextField.getText();
        System.out.println(id);

    }
}
