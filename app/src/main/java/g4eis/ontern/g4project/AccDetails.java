package g4eis.ontern.g4project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.famoussoft.libs.JSON.JSONArray;
import com.famoussoft.libs.JSON.JSONException;
import com.famoussoft.libs.JSON.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by peekay on 8/8/17.
 */

public class AccDetails extends AppCompatActivity {

    TextView acc_name,accHead,accOdc,accMgr,accDetail,accInfo;

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    private String oauth;
    JSONArray jarray=new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_details);

        acc_name = (TextView) findViewById(R.id.acc_name);
        accHead = (TextView) findViewById(R.id.accHead);
        accOdc = (TextView) findViewById(R.id.accOdc);
        accMgr = (TextView) findViewById(R.id.accMgr);
        accInfo = (TextView) findViewById(R.id.accRecp);
        accDetail=(TextView) findViewById(R.id.user_profile_short_bio);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        oauth = sharedpreferences.getString("oauth","null");

        //Intent chatIntent=getIntent();
        String id=getIntent().getStringExtra("accid");

        downloadData();
        getData(id);


    }
    private void downloadData() {
        JSONObject data = new JSONObject();
        try {
            data.put("id", "1");
            data.put("name", "Johnson and Johnson");
            data.put("descp","Johnson and Johnson Description!@#Instruction 1!@#Instruction 2!@#Instruction 3");
            data.put("acchead","Rishabh Vohra!@#ris@tcs.com!@#54R");
            data.put("odc","Prince Kumar!@#prince@tcs.com!@#29A");
            data.put("mgr","XYZ!@#xyz@tcs.com!@#55Q");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data1 = new JSONObject();
        try {
            data1.put("id", "2");
            data1.put("name", "Motorola");
            data1.put("descp","Motorola Description!@#Instruction 1!@#Instruction 2!@#Instruction 3");
            data1.put("acchead","Rahul Singh!@#rah@tcs.com!@#84R");
            data1.put("odc","Shubanil Bag!@#sbag@tcs.com!@#19A");
            data1.put("mgr","XYZ!@#xyz@tcs.com!@#55Q");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data2 = new JSONObject();
        try {
            data2.put("id", "3");
            data2.put("name", "JP Morgan Chase & Co");
            data2.put("descp","JP Morgan Chase & Co Description!@#Instruction 1!@#Instruction 2!@#Instruction 3");
            data2.put("acchead","Prafull Kumar!@#prafull@tcs.com!@#54R");
            data2.put("odc","Jayanta!@#jynta@tcs.com!@#29A");
            data2.put("mgr","XYZ!@#xyz@tcs.com!@#55Q");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data3 = new JSONObject();
        try {
            data3.put("id", "4");
            data3.put("name", "J.C. Penney Company");
            data3.put("descp","J.C. Penney Company Description!@#Instruction 1!@#Instruction 2!@#Instruction 3");
            data3.put("acchead","Prafull Kumar!@#prafull@tcs.com!@#54R");
            data3.put("odc","Piyush!@#praja@tcs.com!@#82H");
            data3.put("mgr","XYZ!@#xyz@tcs.com!@#55Q");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data4 = new JSONObject();
        try {
            data4.put("id", "5");
            data4.put("name", "John Bean Technologies Corporation");
            data4.put("descp","John Bean Technologies Corporation Description!@#Instruction 1!@#Instruction 2!@#Instruction 3");
            data4.put("acchead","Suraj!@#srj@tcs.com!@#34R");
            data4.put("odc","Debayan!@#dbyn@tcs.com!@#89A");
            data4.put("mgr","XYZ!@#xyz@tcs.com!@#55Q");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        jarray.put(data);
        jarray.put(data1);
        jarray.put(data2);
        jarray.put(data3);
        jarray.put(data4);
    }

    private void getData(String acc_id){
        Integer z=new Integer(acc_id);
        JSONObject jobj=new JSONObject(jarray.getJSONObject(z-1).toString());

        String accnm=jobj.getString("name").toString();
        acc_name.setGravity(Gravity.CENTER);
        acc_name.setText(accnm);

        String desc=jobj.getString("descp").toString();
        String parts[]=desc.split("!@#");
        int len=parts.length;
        accInfo.setTextColor(Color.BLACK);
        accDetail.setGravity(Gravity.CENTER);
        accDetail.setText(Html.fromHtml("<big>"+parts[0]+"</big><br>"));
        accInfo.setText(Html.fromHtml("<big>"+"Onboaring Instructions"+":</big> <br>"));
        int i=1;
        while(len>1)
        {
            accInfo.append(Html.fromHtml("<big>"+i+")</big> "+parts[i]+"<br>"));
            i++;
            len--;
        }

        String odcInfo=jobj.getString("odc").toString();
        String parts1[]=odcInfo.split("!@#");
        accOdc.setTextColor(Color.BLACK);
        accOdc.setText(Html.fromHtml("<big>ODC Access"+":</big> <br>Name : "+parts1[0]+"<br>Email : "+parts1[1]+
                "<br>Desk No : "+parts1[2]));

        String accHd=jobj.getString("acchead").toString();
        String parts2[]=accHd.split("!@#");
        accHead.setTextColor(Color.BLACK);
        accHead.setText(Html.fromHtml("<big>Account Head"+":</big> <br>Name : "+parts2[0]+"<br>Email : "+parts2[1]+
                "<br>Desk No : "+parts2[2]));

        String accMg=jobj.getString("mgr").toString();
        String parts3[]=accMg.split("!@#");
        accMgr.setTextColor(Color.BLACK);
        accMgr.setText(Html.fromHtml("<big>Account Manager"+":</big> <br>Name : "+parts3[0]+"<br>Email : "+parts3[1]+
                "<br>Desk No : "+parts3[2]));
                                //Toast.makeText(Splashscreen.this, "print"+oauth2, Toast.LENGTH_LONG).show();

    }
}

