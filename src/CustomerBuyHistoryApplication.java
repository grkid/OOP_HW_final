import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class CustomerBuyHistoryApplication extends MyApplication {
    @FXML
    private TableView list;
    @FXML
    private Label totalCost;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerBuyHistory.fxml";
        title="购买";
        super.start(primaryStage);
    }

}
