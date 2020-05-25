import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SellerAlterRecipeApplication extends MyApplication {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField picDirTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerAlterRecipe.fxml";
        title="更改商品信息";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        //todo
    }
}
