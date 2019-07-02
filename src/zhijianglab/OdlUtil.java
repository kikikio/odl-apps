package zhijianglab;

import zhijianglab.HttpRequest;
import java.io.IOException;
import java.util.Base64;

public class OdlUtil
{
    public static String url = null;

    public OdlUtil(String host, int port)
    {
        this.url = "http://" + host + ":" + port;
    }

    public String getTopo(String uname, String pwd)throws IOException
    {
        String result = null;
        HttpRequest hr = new HttpRequest();

        result = hr.doGet(url + "/restconf/operational/network-topology:network-topology/topology/flow:1", uname, pwd);

        System.out.println(result);

        return result;
    }
}
