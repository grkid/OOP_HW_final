import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SellerPerformanceInfoApplication extends MyApplication {
    @FXML
    private TableView list;
    @FXML
    private Label sumLabel;

    private TableColumn customerIDColumn;
    private TableColumn recipeIDColumn;
    private TableColumn countColumn;
    private TableColumn timeColumn;
    private TableColumn actualPriceColumn;

    private ObservableList<TableRecord> data;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="SellerPerformanceInfo.fxml";
        title="业绩信息";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String result=People.getInstance().RequestGetInfo(People.getInstance().getId());

        customerIDColumn=new TableColumn("顾客ID");customerIDColumn.setPrefWidth(100);
        recipeIDColumn=new TableColumn("商品ID");recipeIDColumn.setPrefWidth(100);
        countColumn=new TableColumn("数量");countColumn.setPrefWidth(100);
        timeColumn=new TableColumn("时间");timeColumn.setPrefWidth(100);
        actualPriceColumn=new TableColumn("实际支付");actualPriceColumn.setPrefWidth(100);

        list.getColumns().addAll(customerIDColumn,recipeIDColumn,countColumn,timeColumn,actualPriceColumn);

        data= FXCollections.observableArrayList();

        list.setItems(data);

        String[] results=result.split(";");
        for (int i=1;i<results.length;i++)
            data.add(TableRecordAdapter.adapt(results[i]));

        customerIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecord,String>("customerID")
        );
        recipeIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecord,String>("recipeID")
        );
        countColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecord,String>("count")
        );
        timeColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecord,String>("time")
        );
        actualPriceColumn.setCellValueFactory(
                new PropertyValueFactory<TableRecord,String>("actualPrice")
        );

        double sum=0;
        int s=data.size();
        for(int i=0;i<s;i++)
        {
            TableRecord r=data.get(i);
            sum+=Double.parseDouble(r.getActualPrice());
        }
        sumLabel.setText("总销售额："+sum);
    }


}
