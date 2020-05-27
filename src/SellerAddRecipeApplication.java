import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

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
        File a=new File(picDirTextField.getText());
        if(!a.exists())
        {
            InfoApplication.showMessage("输入的图片目录不存在，请检查。");
            return;
        }
        if(descriptionTextField.getText().equals(" ") || priceTextField.getText().equals(" ") || nameTextField.getText().equals(""))
        {
            InfoApplication.showMessage("各项信息不能为空，请重新输入。");
            return;
        }
        if(!Tools.isNumber(priceTextField.getText()))
        {
            InfoApplication.showMessage("请输入正确的价格。");
            return;
        }

        String name=nameTextField.getText();
        String description=descriptionTextField.getText();
        String picDir=picDirTextField.getText();
        double price=Double.parseDouble(priceTextField.getText());

        String result=((Seller)(People.getInstance())).RequestAddRecipe(People.getInstance().getId(),name,picDir,price,description);
        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("提交新商品成功。");
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("提交新商品失败，请检查网络连接。");
        }

    }
}
