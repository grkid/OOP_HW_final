import java.io.File;
import java.util.Random;

public class ImgHandler {

    static String basePath="./pic/";

    public static void ImgInit()
    {
        File f=new File(basePath);
        if(!f.exists())
            f.mkdir();
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void CleanImgs()
    {
        File f=new File("./pic");
        if(!f.exists())
            return;
        File[] pics=f.listFiles();
        for(File p:pics)
        {
            p.delete();
        }
    }
}
