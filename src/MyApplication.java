import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public abstract class MyApplication extends Application {
    protected Stage stage=new Stage();

    protected String fxmlFileName="";

    protected String title="";

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(fxmlFileName+" "+title);
        Parent root= FXMLLoader.load(getClass().getResource(fxmlFileName));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root,600,400));
        WindowInit();
        primaryStage.show();
    }

    public void showWindow() throws Exception
    {
        start(stage);
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
}
