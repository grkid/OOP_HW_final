import javafx.stage.Stage;

public class ShowPicApplication extends MyApplication {
    static String fileName;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="showPic.fxml";
        
        super.start(primaryStage);
    }
}
