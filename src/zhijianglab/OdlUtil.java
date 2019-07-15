package zhijianglab;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import zhijianglab.HttpRequest;
import zhijianglab.Host;
import zhijianglab.Switch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;



public class OdlUtil
{
    private String url = null;
    private String rawTopo = null;
    private ArrayList<Switch> switches = new ArrayList<Switch>();
    private ArrayList<Host> hosts = new ArrayList<Host>();
    private String uname = null;
    private String pwd = null;

    public OdlUtil(String host, int port, String uname, String pwd)
    {
        this.url = "http://" + host + ":" + port;
        this.uname = uname;
        this.pwd = pwd;
    }

    public void getTopo()throws IOException
    {
        String result = null;
        HttpRequest hr = new HttpRequest();

        result = hr.doGet(url + "/restconf/operational/network-topology:network-topology/topology/flow:1", uname, pwd);

        rawTopo = result;
    }

    public void parseTopo()throws IOException
    {
        JSONObject jsonObject = JSONObject.fromObject(rawTopo);
        String topology = jsonObject.optString("topology");

        JSONArray jsonArray = JSONArray.fromObject(topology);
        //System.out.println(jsonArray.size());
        jsonObject = jsonArray.getJSONObject(0);

        String node = jsonObject.optString("node");
        String link = jsonObject.optString("link");

        //System.out.println(node);
        //System.out.println(link);

        JSONArray nodeArray = JSONArray.fromObject(node);
        JSONArray linkArray = JSONArray.fromObject(link);


        // parse nodes
        for (int i = 0; i < nodeArray.size(); i++)
        {
            JSONObject nodeObject = nodeArray.getJSONObject(i);

            String nodeType = nodeObject.optString("node-id");

            // find a host
            if (nodeType.charAt(0) == 'h')
            {
                String hostId = nodeType;
                String hostInfo = nodeObject.optString("host-tracker-service:addresses");

                JSONArray hostInfoArray = JSONArray.fromObject(hostInfo);

                JSONObject hostInfoObject = hostInfoArray.getJSONObject(0);

                int nodeId = hostInfoObject.optInt("id");
                String nodeMac = hostInfoObject.optString("mac");
                String nodeIp = hostInfoObject.optString("ip");

                Host newHost = new Host(nodeId, nodeIp, nodeMac, hostId);
                hosts.add(newHost);
                //newHost.showInfo();

            }
            // find a switch
            else if (nodeType.charAt(0) == 'o')
            {
                String switchId = nodeType;

                Switch newSwitch = new Switch(switchId, url, uname, pwd);

                switches.add(newSwitch);
                //newSwitch.showInfo();

            }
            // other devices
            else
            {
                System.out.println("parse error! unknown node type.");
            }


        }

        // parse links
        for (int i = 0; i < linkArray.size(); i++)
        {

        }


    }
    public void showAllHosts()
    {
        for (int i = 0; i < hosts.size(); i++)
        {
            hosts.get(i).showInfo();
        }
    }
    public void showAllSwitchs()
    {
        for (int i = 0; i < switches.size(); i++)
        {
            switches.get(i).showInfo();
        }
    }

    public String setFlowEntry() throws IOException {
        String result = null;

        HttpRequest hr = new HttpRequest();

        result = hr.doPut(url + "/restconf/config/opendaylight-inventory:nodes/node/openflow:93180999844825/flow-node-inventory:table/0/flow/523", uname, pwd, " {\n" +
                "\n" +
                "    \"flow\": [\n" +
                "        {\n" +
                "            \"id\": \"523\",\n" +
                "            \"match\": {\n" +
                "                \"in-port\": \"1\",\n" +
                "                \"ethernet-match\": {\n" +
                "                    \"ethernet-type\": {\n" +
                "                        \"type\": \"2048\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ipv4-source\": \"10.0.0.1/32\",\n" +
                "                \"ipv4-destination\": \"10.0.0.3/32\"\n" +
                "            },\n" +
                "            \"instructions\": {\n" +
                "                \"instruction\": [\n" +
                "                    {\n" +
                "                        \"order\": \"0\",\n" +
                "                        \"apply-actions\": {\n" +
                "                            \"action\": [\n" +
                "                                {\n" +
                "                                    \"order\": \"0\",\n" +
                "                                    \"drop-action\": {}\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"flow-name\": \"15s-drop\",\n" +
                "            \"priority\": \"65535\",\n" +
                "            \"hard-timeout\": \"15\",\n" +
                "            \"table_id\": \"0\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        return result;
    }
}
