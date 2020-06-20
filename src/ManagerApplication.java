import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class ManagerApplication extends MyApplication {

    //由于框架的原因，不能继承CustomerBuyHistoryApplication。FXML文件只绑定了一个类。

    @FXML
    private TableView list;
    @FXML
    protected Label totalCost;

    private TableColumn customerIDColumn;
    private TableColumn recipeIDColumn;
    private TableColumn countColumn;
    private TableColumn timeColumn;
    private TableColumn actualPriceColumn;

    protected ObservableList<TableRecord> data;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="ManagerApplication.fxml";
        title="销售记录";
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

        showData();
    }

    protected void showData() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c=Calendar.getInstance();
        Date currentDate=new Date(System.currentTimeMillis());
        Date oneWeekAgo;
        Date oneMonthAgo;
        c.setTime(currentDate);
        c.add(Calendar.DATE,-7);
        oneWeekAgo=(Date)c.getTime().clone();
        c.add(Calendar.DATE,-23);
        oneMonthAgo=(Date)c.getTime().clone();
        System.out.println(oneWeekAgo);
        System.out.println(oneMonthAgo);
        double sum=0;
        double weekSum=0;
        double monthSum=0;
        int s=data.size();
        for (TableRecord r : data) {
            try {
                Date date = format.parse(r.getTime());
                if (date.compareTo(oneWeekAgo) > 0)
                    weekSum += Double.parseDouble(r.getActualPrice());
                else if (date.compareTo(oneMonthAgo) > 0)
                    monthSum += Double.parseDouble(r.getActualPrice());
            } catch (Exception e) {
                System.out.println("ERROR ManagerApplication：时间格式不正确。");
            }
            sum += Double.parseDouble(r.getActualPrice());
        }
        totalCost.setText("总销售额："+sum+",周销售额："+weekSum+",月销售额："+monthSum);
    }
}
