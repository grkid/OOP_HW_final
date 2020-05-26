import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerWindow.fxml";
        title="用户";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String result=((Customer)(People.getInstance())).GetAllRecipe();
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
