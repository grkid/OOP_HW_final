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

public class CustomerWindowApplication extends MyApplication {
    @FXML
    private TableView list;
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

    private TableColumn idColumn,nameColumn,userIdColumn,priceColumn,descriptionColumn;

    private ObservableList<TableRecipe> data;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerWindow.fxml";
        title="用户";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String result=((Customer)(People.getInstance())).GetAllRecipe();

        idColumn=new TableColumn("ID");idColumn.setPrefWidth(210);
        nameColumn=new TableColumn("名称");nameColumn.setPrefWidth(210);
        userIdColumn=new TableColumn("商家ID");userIdColumn.setPrefWidth(210);
        priceColumn=new TableColumn("价格");priceColumn.setPrefWidth(210);
        descriptionColumn=new TableColumn("描述");descriptionColumn.setPrefWidth(210);

        list.getColumns().addAll(idColumn,nameColumn,userIdColumn,priceColumn,descriptionColumn);

       data=FXCollections.observableArrayList();

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

        IDLabel.setText("账号："+People.getInstance().getId());
        nameLabel.setText("名称："+People.getInstance().getName());
        moneyLabel.setText("余额："+People.getInstance().getMoney());
    }

    public void onBuyButtonClick(ActionEvent event) {
        TableRecipe selectRecipe=(TableRecipe) list.getSelectionModel().getSelectedItem();

        if(selectRecipe==null)
            InfoApplication.showMessage("未选择所需的菜品。");

        String result=((Customer)(People.getInstance())).requestBuy(People.getInstance().getId(),Integer.parseInt(selectRecipe.getId()),1,Double.parseDouble(selectRecipe.getPrice()));

        String[] results=result.split(" ");
        if(results.length==2 && results[1].equals(Str.success.strip())) {
            InfoApplication.showMessage("购买成功。");
            onRefreshInfoButtonClick(event);
        }
        else
            InfoApplication.showMessage("购买失败，请检查您的余额。如余额足够购买，请检查网络连接。");
    }

    public void onRefreshRecipeButtonClick(ActionEvent event) {
        String result=((Customer)(People.getInstance())).GetAllRecipe();
        String[] results=result.split(";");
        data.clear();
        for (int i=1;i<results.length;i++)
            data.add(TableRecipeAdapter.adapt(results[i]));
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
        IDLabel.setText("账号："+People.getInstance().getId());
        nameLabel.setText("名称："+People.getInstance().getName());
        moneyLabel.setText("余额："+People.getInstance().getMoney());

    }
}
