import javafx.collections.FXCollections;
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
import java.util.ResourceBundle;

public class SellerWindowApplication extends MyApplication {
    @FXML
    private Button addRecipeButton;
    @FXML
    private Button alterRecipeButton;
    @FXML
    private Button deleteRecipeButton;
    @FXML
    private Button sellInfoButton;
    @FXML
    private Button refreshRecipeButton;
    @FXML
    private Button alterInfoButton;
    @FXML
    private Button withdrawMoneyButton;
    @FXML
    private Button addMoneyButton;
    @FXML
    private TableView list;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label moneyLabel;
    @FXML
    private Button refreshInfoButton;

    private TableColumn idColumn,nameColumn,userIdColumn,priceColumn,descriptionColumn;

    private ObservableList<TableRecipe> data;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerWindow.fxml";
        title="商家";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //需要时可以改为仅显示自己上架的菜谱
        String result= People.getInstance().GetAllRecipe();

        idColumn=new TableColumn("ID");idColumn.setPrefWidth(210);
        nameColumn=new TableColumn("名称");nameColumn.setPrefWidth(210);
        userIdColumn=new TableColumn("商家ID");userIdColumn.setPrefWidth(210);
        priceColumn=new TableColumn("价格");priceColumn.setPrefWidth(210);
        descriptionColumn=new TableColumn("描述");descriptionColumn.setPrefWidth(210);

        list.getColumns().addAll(idColumn,nameColumn,userIdColumn,priceColumn,descriptionColumn);

        data= FXCollections.observableArrayList();

        list.setItems(data);

        String[] results=result.split(";");
        for (int i=1;i<results.length;i++)
            data.add(TableRecipeAdapter.adapt(results[i]));

        idColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecipe,String>("id")
        );
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecipe,String>("name")
        );
        userIdColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecipe,String>("userID")
        );
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecipe,String>("price")
        );
        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecipe,String>("description")
        );

        idLabel.setText("账号："+People.getInstance().getId());
        nameLabel.setText("名称："+People.getInstance().getName());
        moneyLabel.setText("余额："+People.getInstance().getMoney());
    }

    public void onAddRecipeButtonClick(ActionEvent event) throws Exception
    {
        SellerAddRecipeApplication a=new SellerAddRecipeApplication();
        a.showWindow();
    }

    public void onAlterRecipeButtonClick(ActionEvent event) throws Exception
    {
        SellerAlterRecipeApplication a=new SellerAlterRecipeApplication();
        a.showWindow();
    }

    public void onDeleteRecipeButtonClick(ActionEvent event) throws Exception
    {
        SellerDeleteRecipeApplication a=new SellerDeleteRecipeApplication();
        a.showWindow();
    }

    public void onSellInfoButtonClick(ActionEvent event) throws Exception
    {
        SellerPerformanceInfoApplication a=new SellerPerformanceInfoApplication();
        a.showWindow();
    }

    public void onRefreshRecipeButtonClick(ActionEvent event)
    {
        String result=(People.getInstance()).GetAllRecipe();
        String[] results=result.split(";");
        data.clear();
        for (int i=1;i<results.length;i++)
            data.add(TableRecipeAdapter.adapt(results[i]));
    }

    public void onAlterInfoButtonClick(ActionEvent event) throws Exception
    {
        PeopleAlterInfoApplication a=new PeopleAlterInfoApplication();
        a.showWindow();
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
        String result_money=People.getInstance().GetMoney(People.getInstance().getId());
        String[] results=result_money.split(" ");
        if(results.length==3 && results[1].equals(Str.success.strip()))
        {
            People.getInstance().setMoney(Double.parseDouble(results[2]));
        }
        else
        {
            InfoApplication.showMessage("刷新个人信息时发生失败。");
        }
        idLabel.setText("账号："+People.getInstance().getId());
        nameLabel.setText("名称："+People.getInstance().getName());
        moneyLabel.setText("余额："+People.getInstance().getMoney());
    }
}
