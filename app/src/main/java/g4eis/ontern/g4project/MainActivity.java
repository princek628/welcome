package g4eis.ontern.g4project;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.famoussoft.libs.JSON.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static g4eis.ontern.g4project.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    EditText etUId, etPwd;
    Button btnLogin;
    SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "MyPrefs";
    private String oauth1;
    private ProgressDialog mProgress,m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        etUId = (EditText) findViewById(R.id.etid);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Logging you in...");
        mProgress.setMessage("Please wait...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);

        //sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //oauth1=sharedpreferences.getString("oauth_login","null");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {        //for Login
                String uid=etUId.getText().toString();
                String pwd=etPwd.getText().toString();
                if(!pwd.equals("")&&!uid.equals("")){
                    if(uid.equals("admin") && pwd.equals("admin"))
                    {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean("login",true);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "Login Successful...", Toast.LENGTH_SHORT).show();
                        Intent chatIntent=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(chatIntent);
                        finish();
                    }
                }
                else{
                    Snackbar snackbar = Snackbar
                            .make(view, "Empty Email/Password field, Please fill to continue...", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            }
        });
    }

}
