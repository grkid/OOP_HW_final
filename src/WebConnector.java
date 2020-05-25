
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WebConnector {
    static String ip;
    static String port;
    private static void readXml() throws Exception
    {
        File f=new File("./src/addr.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.parse(f);
        NodeList n=doc.getElementsByTagName("address");
        ip=doc.getElementsByTagName("IP").item(0).getFirstChild().getNodeValue();
        port=doc.getElementsByTagName("port").item(0).getFirstChild().getNodeValue();
    }

    private static String sendPost(String info) throws Exception {
        readXml();
        String USER_AGENT = "Mozilla/5.0";
        String url = "http://"+ip+":"+port;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = info;

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        return response.toString();
    }

    public static String post(String info)
    {
        String retVal;
        try {
            retVal = sendPost(info);
        }
        catch(Exception e)
        {
            retVal=Str.error+"网络错误：检查addr.xml以及网络连接。如仍有问题，联系服务器管理员。";
        }
        return retVal;
    }

    private static String postPic(int ID,String recipeName,String path)
    {
        //测试用方法
        String recipeName64= Base64handler.StringToBase64(recipeName);
        String info=Str.request+Str.save+String.valueOf(ID)+" "+recipeName64+" ";
        String base64=Base64handler.imageToBase64(path);
        info+=base64;
        String ret=post(info);
        return ret;
    }
}
