import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SellerPerformanceInfoApplication extends MyApplication {
    @FXML
    private TableView list;
    @FXML
    private Label sumLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerPerformanceInfo.fxml";
        title="业绩信息";
        super.start(primaryStage);
    }


}
