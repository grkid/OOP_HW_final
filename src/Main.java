import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
public class Main {

    public static void main(String[] v)
    {
        Customer p=new Customer();
        String a=p.requestBuy(10003,10008,1,15.0);
        System.out.println(a);
    }
}
