package zhijianglab;

import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhijianglab.FlowTable;
import zhijianglab.HttpRequest;
import zhijianglab.Port;


public class Switch
{
    private String switchId = null;
    private ArrayList<Port> ports = new ArrayList<Port>();
    private String rawSwitchJsonInfo = null;
    private ArrayList<FlowTable> flowTables = new ArrayList<FlowTable>();

    public Switch(String switchId, String url, String uname, String pwd)throws IOException
    {
        this.switchId = switchId;
        this.rawSwitchJsonInfo = getSwitchInfo(url, uname, pwd);
        JSONObject switchJsonObject = JSONObject.fromObject(rawSwitchJsonInfo);
        String nodeArrayInfo = switchJsonObject.optString("node");

        JSONArray nodeArray = JSONArray.fromObject(nodeArrayInfo);
        JSONObject portJsonObject = nodeArray.getJSONObject(0);

        String portsRawJsonInfo = portJsonObject.optString("node-connector");
        //System.out.println(portsRawJsonInfo);
        JSONArray portJsonArray = JSONArray.fromObject(portsRawJsonInfo);

        for (int i = 0; i < portJsonArray.size(); i++)
        {
            JSONObject perPortObject = portJsonArray.getJSONObject(i);

            Port newPort = new Port(perPortObject);

            ports.add(newPort);

        }

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

    }

    public String getSwitchInfo(String url, String uname, String pwd)throws IOException
    {
        String result = null;
        HttpRequest hr = new HttpRequest();

        result = hr.doGet(url + "/restconf/operational/opendaylight-inventory:nodes/node/" + switchId, uname, pwd);

        //rawSwitchJsonInfo = result;

        //System.out.println(result);

        return result;
    }


    public void getFlowTable()
    {

    }

    public String getSwitchId()
    {
        return this.switchId;
    }
}
