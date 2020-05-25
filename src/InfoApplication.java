import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoApplication extends MyApplication implements Initializable {
    @FXML
    private Label InfoLabel;

    static String Myinfo="";

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="Info.fxml";
        title="提示";
        super.start(primaryStage);
    }

    public static void setInfo(String a)
    {
        Myinfo=a;
    }

    //直接展示一条提示信息
    public static void showMessage(String a) throws Exception
    {
        InfoApplication ia=new InfoApplication();
        InfoApplication.setInfo(a);
        ia.showWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InfoLabel.setText(Myinfo);
        //System.out.println("settext");
    }


}
