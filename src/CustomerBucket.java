import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerBucket extends MyApplication {
    @FXML
    private Button submitButton;
    @FXML
    private TextArea text;

    private double totalPrice=0;

    private boolean isEmpty=false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="CustomerBucket.fxml";
        title="购物车";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Bucket Init");
        StringBuilder text= new StringBuilder(new StringBuilder("您所购买的商品有：\n"));
        int size=CustomerReadyToBuy.getSize();
        for(int i=0;i<size;i++)
        {
            TableRecipe r=CustomerReadyToBuy.getItem(i);
            int count=CustomerReadyToBuy.getCount(i);
            if(r==null)
            {
                //什么都不做
            }
            else
            {
                String s="商品ID："+r.getId()+",商品名称："+r.getName()+",数量："+count+",单价："+r.getPrice()+".数量："+count+"\n";
                totalPrice+=count*Double.parseDouble(r.getPrice());
                text.append(s);
            }
        }

        if(size==0) {
            isEmpty=true;
            this.text.setText("您的购物车为空。");
            return;
        }

        this.text.setText(text.toString());
    }

    public void onSubmitButtonClicked(ActionEvent event) {
        if(isEmpty) {
            closeWindow(event);
            return;
        }

        boolean allSuccess=true;
        int size=CustomerReadyToBuy.getSize();
        for(int i=0;i<size;i++)
        {
            TableRecipe r=CustomerReadyToBuy.getItem(i);
            int count=CustomerReadyToBuy.getCount(i);
            if(r==null)
            {
                //什么都不做
            }
            else
            {
                String result=((Customer)(People.getInstance())).requestBuy(People.getInstance().getId(),Integer.parseInt(r.getId()),count,Double.parseDouble(r.getPrice()));
                if(result.split(" ")[1].equals(Str.failed.strip()))
                {
                    allSuccess=false;
                    InfoApplication.showMessage("余额不足，购买了前"+(i)+"件商品。");
                    CustomerReadyToBuy.clear();
                    closeWindow(event);
                    return;
                }

            }
        }

        InfoApplication.showMessage("全部商品下单完成，请刷新您的余额。");
        CustomerReadyToBuy.clear();
        closeWindow(event);

    }
}
