import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SellerDeleteRecipeApplication extends MyApplication {
    @FXML
    private TextField idTextField;
    @FXML
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerDeleteRecipe.fxml";
        title="删除商品";
        super.start(primaryStage);
    }

    public void onSubmitButtonClick(ActionEvent event) {
        if(idTextField.getText().equals("")|| !Tools.isNumber(idTextField.getText()))
        {
            InfoApplication.showMessage("请确保正确的输入。");
            return;
        }
        int recipeID=Integer.parseInt(idTextField.getText());
        String result=((Seller)(People.getInstance())).RequestDeleteRecipe(recipeID,People.getInstance().getId());
        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("删除成功。");
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("删除失败。请注意您没有权限删除别人的商品。如仍有问题，请检查网络连接。");
        }
    }
}
