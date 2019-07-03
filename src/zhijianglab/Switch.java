package zhijianglab;

import java.util.ArrayList;

public class Switch
{
    private String switchId = null;
    private ArrayList<String> ports = new ArrayList<String>();

    public Switch(String switchId)
    {
        this.switchId = switchId;
    }

    public void showInfo()
    {
        System.out.println("this is switch " + switchId);
        for (int i = 0; i < ports.size(); i++)
        {
            System.out.println(ports.get(i));
        }
        System.out.println();
    }

    public void addPort(String portId)
    {
        ports.add(portId);
    }

}
