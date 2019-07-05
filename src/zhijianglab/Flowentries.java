package zhijianglab;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhijianglab.Action;
import zhijianglab.Match;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;


public class Flowentries
{
    private String entryId = null;
    private ArrayList<Action> actions = new ArrayList<Action>();
    private int byteCnt = 0;
    private int pktCnt = 0;
    private int priority = 0;
    private Match matchField = null;

    public Flowentries(JSONObject flowEntryObject)
    {
        this.entryId = flowEntryObject.optString("id");


        String staticInfo = flowEntryObject.optString("opendaylight-flow-statistics:flow-statistics");
        JSONObject staticJsonObject = JSONObject.fromObject(staticInfo);
        this.byteCnt = staticJsonObject.optInt("byte-count");
        this.pktCnt = staticJsonObject.optInt("packet-count");
        this.priority = flowEntryObject.optInt("priority");

        /*
        actions
         */

        String instructionInfo = flowEntryObject.optString("instructions");
        if (instructionInfo.isEmpty())
        {
            //System.out.println("this entry no actions");
        }
        else
        {
            JSONObject instructionObj = JSONObject.fromObject(instructionInfo);
            String instructionArray = instructionObj.optString("instruction");
            JSONArray insArray = JSONArray.fromObject(instructionArray);

            //maybe many instructions
            JSONObject insObj = insArray.getJSONObject(0);
            //System.out.println(insObj.toString());
            String aplActionArrayInfo = insObj.optString("apply-actions");

            JSONObject aplActionObject = JSONObject.fromObject(aplActionArrayInfo);

            String actionArrayInfo = aplActionObject.optString("action");

            JSONArray actionArray = JSONArray.fromObject(actionArrayInfo);

            for (int i = 0; i < actionArray.size(); i++)
            {
                JSONObject perActionObject = actionArray.getJSONObject(i);

                Action newAction = new Action(perActionObject);

                actions.add(newAction);

                //newAction.showInfo();

            }
        }

        //System.out.println(actions.size());


        /*
        match
         */
        String matchInfo = flowEntryObject.getString("match");


        //System.out.println("11111111111111111111111");

        // no match fields
        if (matchInfo.equals("{}"))
        {
            matchField = null;
            //System.out.println("11111111111111111111111");
        }
        else
        {
            JSONObject matchObject = JSONObject.fromObject(matchInfo);
            //System.out.println(matchObject.toString());
            matchField = new Match(matchObject);
            //matchField.showInfo();
        }

    }
    public void showInfo()
    {

        System.out.println("########## entry ： " + this.entryId + " info ##########");
        System.out.println("entryId : " + this.entryId);
        System.out.println("byteCnt : " + this.byteCnt);
        System.out.println("pktCnt : " + this.pktCnt);
        System.out.println("priority : " + this.priority);

        if (matchField != null)
        {
            matchField.showInfo();
        }
        else
        {
            System.out.println("there is no match field in this entry");
        }




        System.out.println("########## entry ：" + this.entryId + " info end ##########");
        System.out.println();


    }
}
