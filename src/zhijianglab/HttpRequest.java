package zhijianglab;


import java.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;




public class HttpRequest
{
    public static String doGet(String url, String uname, String pwd)throws IOException
    {
        //System.out.println(url);
        String result = null;

        BufferedReader in = null;
        PrintWriter out = null;

        String input = uname + ":" + pwd;

        URL realurl = new URL(url);

        HttpURLConnection conn = (HttpURLConnection)realurl.openConnection();

        String encodeedpwd = Base64.getEncoder().encodeToString((input).getBytes());

        conn.setRequestProperty("Authorization", "Basic " + encodeedpwd);
        conn.setConnectTimeout(6000*5);
        conn.setReadTimeout(6000*5);
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println("resultMessage="+result);

        if(in!=null){
            in.close();
        }
        return result;
    }
}
