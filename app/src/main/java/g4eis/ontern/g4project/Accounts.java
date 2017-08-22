package g4eis.ontern.g4project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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
import java.util.Map;

public class Accounts extends AppCompatActivity{

    protected String qry="";
    public int id;
    JSONArray message=null;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    JSONArray jarray=new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //editSearch = (SearchView) findViewById(R.id.search);
        //editSearch.setOnQueryTextListener(this);
        //Toast.makeText(Accounts.this, oauth2, Toast.LENGTH_LONG).show();
        downloadData();
        loadList();
    }


    private void loadList() {
        // TODO Auto-generated method stub
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.accounts_form);
        mainLayout.removeAllViews();
        //int total=Integer.parseInt(data.getString("total").toString());
        //this.total=total;
        message=jarray;
        for (int i=0; i<jarray.length(); i++) {
            JSONObject jobj=new JSONObject(jarray.getJSONObject(i).toString());
            String name = jobj.getString("name").toString();
            id = jobj.getInt("id");

            LinearLayout ll = new LinearLayout(this);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setPadding(10, 10, 10, 10);

            final LinearLayout sll = new LinearLayout(this);
            sll.setId(id);
            sll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            sll.setPadding(15, 15, 5, 15);
            sll.setOrientation(LinearLayout.VERTICAL);
            //sll.setBackgroundColor(Color.WHITE);

            TextView tvTitle = new TextView(this);
            tvTitle.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tvTitle.setText(Html.fromHtml("<big><b><h3><i>"+"</i></b>"+""+name+"</h3></big>"));
            tvTitle.setTextColor(Color.BLACK);
            tvTitle.setClickable(true);
            tvTitle.setGravity(Gravity.CENTER);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(Accounts.this,"Clicked "+sll.getId(),Toast.LENGTH_LONG).show();
                    accountDetails(sll.getId());
                }
            });

            sll.addView(tvTitle);

            ll.addView(sll);
            mainLayout.addView(ll);
        }
    }

    private void downloadData()
    {
        JSONObject data = new JSONObject();
        try {
            data.put("id", "1");
            data.put("name", "Johnson and Johnson");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data1 = new JSONObject();
        try {
            data1.put("id", "2");
            data1.put("name", "Motorola");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data2 = new JSONObject();
        try {
            data2.put("id", "3");
            data2.put("name", "JP Morgan Chase & Co");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data3 = new JSONObject();
        try {
            data3.put("id", "4");
            data3.put("name", "J.C. Penney Company");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject data4 = new JSONObject();
        try {
            data4.put("id", "5");
            data4.put("name", "John Bean Technologies Corporation");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        jarray.put(data);
        jarray.put(data1);
        jarray.put(data2);
        jarray.put(data3);
        jarray.put(data4);
    }

    private void accountDetails(final int id){
        Intent chatIntent=new Intent(Accounts.this,AccDetails.class);
        String id1=Integer.toString(id);
        chatIntent.putExtra("accid",id1);
        startActivity(chatIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}








