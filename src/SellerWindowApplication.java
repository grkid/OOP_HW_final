import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.stage.Stage;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerWindow.fxml";
        title="商家";
        super.start(primaryStage);
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
        //todo
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
        //todo
    }
}
