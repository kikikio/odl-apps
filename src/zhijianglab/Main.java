package zhijianglab;

import zhijianglab.OdlUtil;
import java.io.IOException;

public class Main
{
    public static void main(String args[])throws IOException
    {
        OdlUtil ou = new OdlUtil("10.3.0.34", 8181);
        ou.getTopo("admin", "admin");
    }
}
