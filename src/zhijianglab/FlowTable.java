package zhijianglab;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhijianglab.Flowentries;

public class FlowTable
{
    private int tableId = 0;
    private int pktLookUp = 0;
    private int pktMatched = 0;
    private int activeFlows = 0;
    private ArrayList<Flowentries> flowentries = new ArrayList<Flowentries>();

    public FlowTable(JSONObject tableObject)
    {
        String tableStaticInfo = tableObject.optString("opendaylight-flow-table-statistics:flow-table-statistics");
        JSONObject tableStaticObject = JSONObject.fromObject(tableStaticInfo);
        this.tableId = tableObject.optInt("id");
        this.pktLookUp = tableStaticObject.optInt("packets-looked-up");
        this.pktMatched = tableStaticObject.optInt("packets-matched");
        this.activeFlows = tableStaticObject.optInt("active-flows");

        if (this.pktLookUp == 0 && this.pktMatched == 0)
        {
            return;
        }

        String flowEntriesInfo = tableStaticObject.optString("flow");
        JSONArray flowEntriesArray = JSONArray.fromObject(flowEntriesInfo);

        for (int i = 0; i < flowEntriesArray.size(); i++)
        {
            JSONObject perFlowEntryObject = flowEntriesArray.getJSONObject(i);
            Flowentries newFlowEntry = new Flowentries(perFlowEntryObject);
            flowentries.add(newFlowEntry);
        }




    }

    public int getPktLookUp()
    {
        return pktLookUp;
    }

    public int getPktMatched()
    {
        return pktMatched;
    }

    public void showInfo()
    {
        System.out.println("useful table id : " + tableId);
    }
}
