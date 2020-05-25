import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class MyApplication extends Application implements Initializable {
    protected Stage stage=new Stage();

    protected String fxmlFileName="";

    protected String title="";

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(fxmlFileName+" "+title);
        Parent root= FXMLLoader.load(getClass().getResource(fxmlFileName));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showWindow() throws Exception
    {
        start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
