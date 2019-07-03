package zhijianglab;


import java.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class HttpRequest
{
    public static String doGet(String url, String uname, String pwd)throws IOException
    {
        //System.out.println(url);
        String result = "";

        BufferedReader in = null;

        String usrinfo = uname + ":" + pwd;

        URL realurl = new URL(url);

        HttpURLConnection conn = (HttpURLConnection)realurl.openConnection();

        String encodeedpwd = Base64.getEncoder().encodeToString((usrinfo).getBytes());

        conn.setRequestProperty("Authorization", "Basic " + encodeedpwd);
        conn.setConnectTimeout(6000*5);
        conn.setReadTimeout(6000*5);
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println(result);

        if(in!=null){
            in.close();
        }
        return result;
    }
}
