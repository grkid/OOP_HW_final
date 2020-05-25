import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InfoApplication extends MyApplication {
    @FXML
    private Label InfoLabel;

    String info;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="Info.fxml";
        title="提示";
        super.start(primaryStage);
    }

    public void setInfo(String a)
    {
        info=a;
    }

    @Override
    protected void WindowInit() {
        InfoLabel.setText(info);
        super.WindowInit();
    }
}
