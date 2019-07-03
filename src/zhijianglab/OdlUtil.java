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


// data : {"topology":[{"topology-id":"flow:1","node":[{"node-id":"openflow:2","termination-point":[{"tp-id":"openflow:2:LOCAL","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:LOCAL']"},{"tp-id":"openflow:2:1","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:1']"},{"tp-id":"openflow:2:2","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:2']"}],"opendaylight-topology-inventory:inventory-node-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']"},{"node-id":"openflow:1","termination-point":[{"tp-id":"openflow:1:1","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:1']"},{"tp-id":"openflow:1:2","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:2']"},{"tp-id":"openflow:1:3","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:3']"},{"tp-id":"openflow:1:LOCAL","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:LOCAL']"},{"tp-id":"openflow:1:4","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:4']"}],"opendaylight-topology-inventory:inventory-node-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']"},{"node-id":"openflow:4","termination-point":[{"tp-id":"openflow:4:6","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:6']"},{"tp-id":"openflow:4:2","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:2']"},{"tp-id":"openflow:4:3","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:3']"},{"tp-id":"openflow:4:4","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:4']"},{"tp-id":"openflow:4:5","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:5']"},{"tp-id":"openflow:4:LOCAL","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:LOCAL']"},{"tp-id":"openflow:4:1","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:1']"}],"opendaylight-topology-inventory:inventory-node-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']"},{"node-id":"openflow:3","termination-point":[{"tp-id":"openflow:3:LOCAL","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:LOCAL']"},{"tp-id":"openflow:3:1","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:1']"},{"tp-id":"openflow:3:2","opendaylight-topology-inventory:inventory-node-connector-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:2']"}],"opendaylight-topology-inventory:inventory-node-ref":"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']"},{"node-id":"host:32:ab:b6:45:08:e9","termination-point":[{"tp-id":"host:32:ab:b6:45:08:e9"}],"host-tracker-service:attachment-points":[{"tp-id":"openflow:1:1","corresponding-tp":"host:32:ab:b6:45:08:e9","active":true}],"host-tracker-service:id":"32:ab:b6:45:08:e9","host-tracker-service:addresses":[{"id":1,"mac":"32:ab:b6:45:08:e9","first-seen":1562055118428,"last-seen":1562117975945,"ip":"10.0.0.1"}]},{"node-id":"host:aa:ef:34:fe:96:64","termination-point":[{"tp-id":"host:aa:ef:34:fe:96:64"}],"host-tracker-service:attachment-points":[{"tp-id":"openflow:4:5","corresponding-tp":"host:aa:ef:34:fe:96:64","active":true}],"host-tracker-service:id":"aa:ef:34:fe:96:64","host-tracker-service:addresses":[{"id":2,"mac":"aa:ef:34:fe:96:64","first-seen":1562055118430,"last-seen":1562117975931,"ip":"10.0.0.3"}]},{"node-id":"host:de:26:d6:be:12:89","termination-point":[{"tp-id":"host:de:26:d6:be:12:89"}],"host-tracker-service:attachment-points":[{"tp-id":"openflow:4:6","corresponding-tp":"host:de:26:d6:be:12:89","active":true}],"host-tracker-service:id":"de:26:d6:be:12:89","host-tracker-service:addresses":[{"id":3,"mac":"de:26:d6:be:12:89","first-seen":1562055131740,"last-seen":1562117975913,"ip":"10.0.0.4"}]},{"node-id":"host:6a:d3:9f:80:79:80","termination-point":[{"tp-id":"host:6a:d3:9f:80:79:80"}],"host-tracker-service:attachment-points":[{"tp-id":"openflow:4:4","corresponding-tp":"host:6a:d3:9f:80:79:80","active":true}],"host-tracker-service:id":"6a:d3:9f:80:79:80","host-tracker-service:addresses":[{"id":0,"mac":"6a:d3:9f:80:79:80","first-seen":1562055118416,"last-seen":1562117975914,"ip":"10.0.0.2"}]}],"link":[{"link-id":"openflow:4:4/host:6a:d3:9f:80:79:80","source":{"source-node":"openflow:4","source-tp":"openflow:4:4"},"destination":{"dest-tp":"host:6a:d3:9f:80:79:80","dest-node":"host:6a:d3:9f:80:79:80"}},{"link-id":"openflow:4:3","source":{"source-node":"openflow:4","source-tp":"openflow:4:3"},"destination":{"dest-tp":"openflow:3:2","dest-node":"openflow:3"}},{"link-id":"openflow:4:6/host:de:26:d6:be:12:89","source":{"source-node":"openflow:4","source-tp":"openflow:4:6"},"destination":{"dest-tp":"host:de:26:d6:be:12:89","dest-node":"host:de:26:d6:be:12:89"}},{"link-id":"openflow:4:5/host:aa:ef:34:fe:96:64","source":{"source-node":"openflow:4","source-tp":"openflow:4:5"},"destination":{"dest-tp":"host:aa:ef:34:fe:96:64","dest-node":"host:aa:ef:34:fe:96:64"}},{"link-id":"host:aa:ef:34:fe:96:64/openflow:4:5","source":{"source-node":"host:aa:ef:34:fe:96:64","source-tp":"host:aa:ef:34:fe:96:64"},"destination":{"dest-tp":"openflow:4:5","dest-node":"openflow:4"}},{"link-id":"host:de:26:d6:be:12:89/openflow:4:6","source":{"source-node":"host:de:26:d6:be:12:89","source-tp":"host:de:26:d6:be:12:89"},"destination":{"dest-tp":"openflow:4:6","dest-node":"openflow:4"}},{"link-id":"openflow:2:1","source":{"source-node":"openflow:2","source-tp":"openflow:2:1"},"destination":{"dest-tp":"openflow:1:2","dest-node":"openflow:1"}},{"link-id":"openflow:1:2","source":{"source-node":"openflow:1","source-tp":"openflow:1:2"},"destination":{"dest-tp":"openflow:2:1","dest-node":"openflow:2"}},{"link-id":"openflow:1:3","source":{"source-node":"openflow:1","source-tp":"openflow:1:3"},"destination":{"dest-tp":"openflow:3:1","dest-node":"openflow:3"}},{"link-id":"openflow:3:1","source":{"source-node":"openflow:3","source-tp":"openflow:3:1"},"destination":{"dest-tp":"openflow:1:3","dest-node":"openflow:1"}},{"link-id":"openflow:2:2","source":{"source-node":"openflow:2","source-tp":"openflow:2:2"},"destination":{"dest-tp":"openflow:4:2","dest-node":"openflow:4"}},{"link-id":"openflow:4:1","source":{"source-node":"openflow:4","source-tp":"openflow:4:1"},"destination":{"dest-tp":"openflow:1:4","dest-node":"openflow:1"}},{"link-id":"openflow:1:4","source":{"source-node":"openflow:1","source-tp":"openflow:1:4"},"destination":{"dest-tp":"openflow:4:1","dest-node":"openflow:4"}},{"link-id":"openflow:3:2","source":{"source-node":"openflow:3","source-tp":"openflow:3:2"},"destination":{"dest-tp":"openflow:4:3","dest-node":"openflow:4"}},{"link-id":"host:32:ab:b6:45:08:e9/openflow:1:1","source":{"source-node":"host:32:ab:b6:45:08:e9","source-tp":"host:32:ab:b6:45:08:e9"},"destination":{"dest-tp":"openflow:1:1","dest-node":"openflow:1"}},{"link-id":"openflow:4:2","source":{"source-node":"openflow:4","source-tp":"openflow:4:2"},"destination":{"dest-tp":"openflow:2:2","dest-node":"openflow:2"}},{"link-id":"openflow:1:1/host:32:ab:b6:45:08:e9","source":{"source-node":"openflow:1","source-tp":"openflow:1:1"},"destination":{"dest-tp":"host:32:ab:b6:45:08:e9","dest-node":"host:32:ab:b6:45:08:e9"}},{"link-id":"host:6a:d3:9f:80:79:80/openflow:4:4","source":{"source-node":"host:6a:d3:9f:80:79:80","source-tp":"host:6a:d3:9f:80:79:80"},"destination":{"dest-tp":"openflow:4:4","dest-node":"openflow:4"}}]}]}


public class OdlUtil
{
    private String url = null;
    private String rawTopo = "{\"topology\":[{\"topology-id\":\"flow:1\",\"node\":[{\"node-id\":\"openflow:2\",\"termination-point\":[{\"tp-id\":\"openflow:2:LOCAL\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:LOCAL']\"},{\"tp-id\":\"openflow:2:1\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:1']\"},{\"tp-id\":\"openflow:2:2\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:2:2']\"}],\"opendaylight-topology-inventory:inventory-node-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:2']\"},{\"node-id\":\"openflow:1\",\"termination-point\":[{\"tp-id\":\"openflow:1:1\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:1']\"},{\"tp-id\":\"openflow:1:2\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:2']\"},{\"tp-id\":\"openflow:1:3\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:3']\"},{\"tp-id\":\"openflow:1:LOCAL\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:LOCAL']\"},{\"tp-id\":\"openflow:1:4\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:1:4']\"}],\"opendaylight-topology-inventory:inventory-node-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:1']\"},{\"node-id\":\"openflow:4\",\"termination-point\":[{\"tp-id\":\"openflow:4:6\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:6']\"},{\"tp-id\":\"openflow:4:2\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:2']\"},{\"tp-id\":\"openflow:4:3\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:3']\"},{\"tp-id\":\"openflow:4:4\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:4']\"},{\"tp-id\":\"openflow:4:5\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:5']\"},{\"tp-id\":\"openflow:4:LOCAL\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:LOCAL']\"},{\"tp-id\":\"openflow:4:1\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:4:1']\"}],\"opendaylight-topology-inventory:inventory-node-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:4']\"},{\"node-id\":\"openflow:3\",\"termination-point\":[{\"tp-id\":\"openflow:3:LOCAL\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:LOCAL']\"},{\"tp-id\":\"openflow:3:1\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:1']\"},{\"tp-id\":\"openflow:3:2\",\"opendaylight-topology-inventory:inventory-node-connector-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']/opendaylight-inventory:node-connector[opendaylight-inventory:id='openflow:3:2']\"}],\"opendaylight-topology-inventory:inventory-node-ref\":\"/opendaylight-inventory:nodes/opendaylight-inventory:node[opendaylight-inventory:id='openflow:3']\"},{\"node-id\":\"host:32:ab:b6:45:08:e9\",\"termination-point\":[{\"tp-id\":\"host:32:ab:b6:45:08:e9\"}],\"host-tracker-service:attachment-points\":[{\"tp-id\":\"openflow:1:1\",\"corresponding-tp\":\"host:32:ab:b6:45:08:e9\",\"active\":true}],\"host-tracker-service:id\":\"32:ab:b6:45:08:e9\",\"host-tracker-service:addresses\":[{\"id\":1,\"mac\":\"32:ab:b6:45:08:e9\",\"first-seen\":1562055118428,\"last-seen\":1562117975945,\"ip\":\"10.0.0.1\"}]},{\"node-id\":\"host:aa:ef:34:fe:96:64\",\"termination-point\":[{\"tp-id\":\"host:aa:ef:34:fe:96:64\"}],\"host-tracker-service:attachment-points\":[{\"tp-id\":\"openflow:4:5\",\"corresponding-tp\":\"host:aa:ef:34:fe:96:64\",\"active\":true}],\"host-tracker-service:id\":\"aa:ef:34:fe:96:64\",\"host-tracker-service:addresses\":[{\"id\":2,\"mac\":\"aa:ef:34:fe:96:64\",\"first-seen\":1562055118430,\"last-seen\":1562117975931,\"ip\":\"10.0.0.3\"}]},{\"node-id\":\"host:de:26:d6:be:12:89\",\"termination-point\":[{\"tp-id\":\"host:de:26:d6:be:12:89\"}],\"host-tracker-service:attachment-points\":[{\"tp-id\":\"openflow:4:6\",\"corresponding-tp\":\"host:de:26:d6:be:12:89\",\"active\":true}],\"host-tracker-service:id\":\"de:26:d6:be:12:89\",\"host-tracker-service:addresses\":[{\"id\":3,\"mac\":\"de:26:d6:be:12:89\",\"first-seen\":1562055131740,\"last-seen\":1562117975913,\"ip\":\"10.0.0.4\"}]},{\"node-id\":\"host:6a:d3:9f:80:79:80\",\"termination-point\":[{\"tp-id\":\"host:6a:d3:9f:80:79:80\"}],\"host-tracker-service:attachment-points\":[{\"tp-id\":\"openflow:4:4\",\"corresponding-tp\":\"host:6a:d3:9f:80:79:80\",\"active\":true}],\"host-tracker-service:id\":\"6a:d3:9f:80:79:80\",\"host-tracker-service:addresses\":[{\"id\":0,\"mac\":\"6a:d3:9f:80:79:80\",\"first-seen\":1562055118416,\"last-seen\":1562117975914,\"ip\":\"10.0.0.2\"}]}],\"link\":[{\"link-id\":\"openflow:4:4/host:6a:d3:9f:80:79:80\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:4\"},\"destination\":{\"dest-tp\":\"host:6a:d3:9f:80:79:80\",\"dest-node\":\"host:6a:d3:9f:80:79:80\"}},{\"link-id\":\"openflow:4:3\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:3\"},\"destination\":{\"dest-tp\":\"openflow:3:2\",\"dest-node\":\"openflow:3\"}},{\"link-id\":\"openflow:4:6/host:de:26:d6:be:12:89\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:6\"},\"destination\":{\"dest-tp\":\"host:de:26:d6:be:12:89\",\"dest-node\":\"host:de:26:d6:be:12:89\"}},{\"link-id\":\"openflow:4:5/host:aa:ef:34:fe:96:64\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:5\"},\"destination\":{\"dest-tp\":\"host:aa:ef:34:fe:96:64\",\"dest-node\":\"host:aa:ef:34:fe:96:64\"}},{\"link-id\":\"host:aa:ef:34:fe:96:64/openflow:4:5\",\"source\":{\"source-node\":\"host:aa:ef:34:fe:96:64\",\"source-tp\":\"host:aa:ef:34:fe:96:64\"},\"destination\":{\"dest-tp\":\"openflow:4:5\",\"dest-node\":\"openflow:4\"}},{\"link-id\":\"host:de:26:d6:be:12:89/openflow:4:6\",\"source\":{\"source-node\":\"host:de:26:d6:be:12:89\",\"source-tp\":\"host:de:26:d6:be:12:89\"},\"destination\":{\"dest-tp\":\"openflow:4:6\",\"dest-node\":\"openflow:4\"}},{\"link-id\":\"openflow:2:1\",\"source\":{\"source-node\":\"openflow:2\",\"source-tp\":\"openflow:2:1\"},\"destination\":{\"dest-tp\":\"openflow:1:2\",\"dest-node\":\"openflow:1\"}},{\"link-id\":\"openflow:1:2\",\"source\":{\"source-node\":\"openflow:1\",\"source-tp\":\"openflow:1:2\"},\"destination\":{\"dest-tp\":\"openflow:2:1\",\"dest-node\":\"openflow:2\"}},{\"link-id\":\"openflow:1:3\",\"source\":{\"source-node\":\"openflow:1\",\"source-tp\":\"openflow:1:3\"},\"destination\":{\"dest-tp\":\"openflow:3:1\",\"dest-node\":\"openflow:3\"}},{\"link-id\":\"openflow:3:1\",\"source\":{\"source-node\":\"openflow:3\",\"source-tp\":\"openflow:3:1\"},\"destination\":{\"dest-tp\":\"openflow:1:3\",\"dest-node\":\"openflow:1\"}},{\"link-id\":\"openflow:2:2\",\"source\":{\"source-node\":\"openflow:2\",\"source-tp\":\"openflow:2:2\"},\"destination\":{\"dest-tp\":\"openflow:4:2\",\"dest-node\":\"openflow:4\"}},{\"link-id\":\"openflow:4:1\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:1\"},\"destination\":{\"dest-tp\":\"openflow:1:4\",\"dest-node\":\"openflow:1\"}},{\"link-id\":\"openflow:1:4\",\"source\":{\"source-node\":\"openflow:1\",\"source-tp\":\"openflow:1:4\"},\"destination\":{\"dest-tp\":\"openflow:4:1\",\"dest-node\":\"openflow:4\"}},{\"link-id\":\"openflow:3:2\",\"source\":{\"source-node\":\"openflow:3\",\"source-tp\":\"openflow:3:2\"},\"destination\":{\"dest-tp\":\"openflow:4:3\",\"dest-node\":\"openflow:4\"}},{\"link-id\":\"host:32:ab:b6:45:08:e9/openflow:1:1\",\"source\":{\"source-node\":\"host:32:ab:b6:45:08:e9\",\"source-tp\":\"host:32:ab:b6:45:08:e9\"},\"destination\":{\"dest-tp\":\"openflow:1:1\",\"dest-node\":\"openflow:1\"}},{\"link-id\":\"openflow:4:2\",\"source\":{\"source-node\":\"openflow:4\",\"source-tp\":\"openflow:4:2\"},\"destination\":{\"dest-tp\":\"openflow:2:2\",\"dest-node\":\"openflow:2\"}},{\"link-id\":\"openflow:1:1/host:32:ab:b6:45:08:e9\",\"source\":{\"source-node\":\"openflow:1\",\"source-tp\":\"openflow:1:1\"},\"destination\":{\"dest-tp\":\"host:32:ab:b6:45:08:e9\",\"dest-node\":\"host:32:ab:b6:45:08:e9\"}},{\"link-id\":\"host:6a:d3:9f:80:79:80/openflow:4:4\",\"source\":{\"source-node\":\"host:6a:d3:9f:80:79:80\",\"source-tp\":\"host:6a:d3:9f:80:79:80\"},\"destination\":{\"dest-tp\":\"openflow:4:4\",\"dest-node\":\"openflow:4\"}}]}]}\n";
    private ArrayList<Switch> switches = new ArrayList<Switch>();
    private ArrayList<Host> hosts = new ArrayList<Host>();

    public OdlUtil(String host, int port)
    {
        this.url = "http://" + host + ":" + port;
    }

    public String getTopo(String uname, String pwd)throws IOException
    {
        String result = null;
        HttpRequest hr = new HttpRequest();

        result = hr.doGet(url + "/restconf/operational/network-topology:network-topology/topology/flow:1", uname, pwd);

        rawTopo = result;

        return result;
    }

    public void parseTopo()
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

                Switch newSwitch = new Switch(switchId);

                String switchInfo = nodeObject.optString("termination-point");

                JSONArray switchInfoArray = JSONArray.fromObject(switchInfo);

                for (int j = 0; j < switchInfoArray.size(); j++)
                {
                    JSONObject switchPortObject = switchInfoArray.getJSONObject(j);
                    newSwitch.addPort(switchPortObject.optString("tp-id"));
                }

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

}
