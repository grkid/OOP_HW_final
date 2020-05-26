import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class CustomerWindowApplication extends MyApplication {
    @FXML
    private TableView<RecipeForTable> list;
    @FXML
    private Button buyButton;
    @FXML
    private Button refreshRecipeButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button infoAlterButton;
    @FXML
    private Button withdrawMoneyButton;
    @FXML
    private Button addMoneyButton;
    @FXML
    private Label IDLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label moneyLabel;
    @FXML
    private Button refreshInfoButton;

    private final ObservableList<RecipeForTable> recipes= FXCollections.observableArrayList();

    private TableColumn idC,nameC,userIDC,priceC,descriptionC;

    CustomerWindowApplication()
    {
        idC= new TableColumn<>(RecipeForTable.p_id);
        nameC= new TableColumn<>(RecipeForTable.p_name);
        userIDC= new TableColumn<>(RecipeForTable.p_userID);
        priceC= new TableColumn<>(RecipeForTable.p_price);
        descriptionC= new TableColumn<>(RecipeForTable.p_description);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameLabel.setText("名称："+People.getInstance().getName());
        moneyLabel.setText("余额："+People.getInstance().getMoney());
        IDLabel.setText("账号："+People.getInstance().getId());

        String result=People.getInstance().GetAllRecipe();
        //# RESULT SUCCESS;<ID> <base64 name> <userID> <price> <base64 description>;
        String[] results=result.split(";");
        if(!results[0].split(" ")[1].equals(Str.success.strip()))
            InfoApplication.showMessage("加载外卖信息失败。");
        for(int i=1;i<results.length;i++)
        {
            String[] info=results[i].split(" ");
            String id=info[0];
            String name=Base64handler.Base64ToString(info[1].strip());
            String userID=info[2];
            String price=info[3];
            String description=Base64handler.Base64ToString(info[4]);
            recipes.add(new RecipeForTable(id,name,userID,price,description));
        }

//        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
//        userIDC.setCellValueFactory(new PropertyValueFactory<>("userID"));
//        priceC.setCellValueFactory(new PropertyValueFactory<>("price"));
//        descriptionC.setCellValueFactory(new PropertyValueFactory<>("description"));

        list.getColumns().addAll(idC,nameC,userIDC,priceC,descriptionC);

//        list.setItems(recipes);
//        list.getColumns().addAll(idC,nameC,userIDC,priceC,descriptionC);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerWindow.fxml";
        title="用户";
        super.start(primaryStage);
    }

    public void onBuyButtonClick(ActionEvent event) {
        //TODO
    }

    public void onRefreshRecipeButtonClick(ActionEvent event) {
        //TODO
    }

    public void onHistoryButtonClick(ActionEvent event) throws Exception
    {
        CustomerBuyHistoryApplication cbha=new CustomerBuyHistoryApplication();
        cbha.showWindow();
    }

    public void onInfoAlterButtonClick(ActionEvent event) throws Exception
    {
        PeopleAlterInfoApplication paia=new PeopleAlterInfoApplication();
        paia.showWindow();
    }

    public void onWithdrawMoneyButtonClick(ActionEvent event) throws Exception
    {
        PeopleWithdrawMoneyApplication a=new PeopleWithdrawMoneyApplication();
        a.showWindow();
    }

    public void onAddMoneyButtonClick(ActionEvent event) throws Exception
    {
        PeopleAddMoneyApplication a=new PeopleAddMoneyApplication();
        a.showWindow();
    }

    public void onRefreshInfoButtonClick(ActionEvent event)
    {
        //todo
    }
}
