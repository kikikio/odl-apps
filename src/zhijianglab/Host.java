package zhijianglab;

public class Host
{
    private static int id = 0;
    private static String ipAddr = null;
    private static String macAddr = null;
    public Host(int id, String ip, String mac)
    {
        this.id = id;
        this.ipAddr = ip;
        this.macAddr = mac;
    }
    public static void showInfo()
    {
        System.out.println("this is host" + id);
        System.out.println("ip : " + ipAddr);
        System.out.println("mac : " + macAddr);
    }
}
