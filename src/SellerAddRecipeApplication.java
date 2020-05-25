import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SellerAddRecipeApplication extends MyApplication {
    @FXML
    private Button submitButton;
    @FXML
    private TextArea descriptionTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField picDirTextField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerAddRecipe.fxml";
        title="添加商品";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        //todo
    }
}
