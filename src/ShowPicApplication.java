import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowPicApplication extends MyApplication {
    private static String fileName;

    @FXML
    private ImageView image;


    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlFileName="showPic.fxml";
        title="图片";
        super.start(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println("图片不存在，请检查目录。");
                return;
            }
            String localUrl=f.toURI().toURL().toString();
            Image i=new Image(localUrl,false);
            image.setImage(i);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void showPic(String f)
    {
        try {
            fileName = f;
            ShowPicApplication a = new ShowPicApplication();
            a.showWindow();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
