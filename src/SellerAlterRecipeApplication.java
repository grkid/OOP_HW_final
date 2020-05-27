import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

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
        File a=new File(picDirTextField.getText());
        if(!a.exists())
        {
            InfoApplication.showMessage("输入的图片目录不存在，请检查。");
            return;
        }
        if(descriptionTextArea.getText().equals(" ") || priceTextField.getText().equals(" ") || nameTextField.getText().equals("")|| idTextField.getText().equals(""))
        {
            InfoApplication.showMessage("各项信息不能为空，请重新输入。");
            return;
        }
        if(!Tools.isNumber(priceTextField.getText()))
        {
            InfoApplication.showMessage("请输入正确的价格。");
            return;
        }

        int id=Integer.parseInt(idTextField.getText());
        String name=nameTextField.getText();
        String description=descriptionTextArea.getText();
        String picDir=picDirTextField.getText();
        double price=Double.parseDouble(priceTextField.getText());

        String result=((Seller)(People.getInstance())).RequestAlterRecipe(id,People.getInstance().getId(),name,picDir,price,description);
        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip()))
        {
            InfoApplication.showMessage("修改商品成功。");
            closeWindow(event);
        }
        else
        {
            InfoApplication.showMessage("修改商品失败，您没有权限修改其他人的商品。如仍有问题，请检查网络连接。");
        }
    }
}
