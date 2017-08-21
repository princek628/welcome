package g4eis.ontern.g4project;



/**
 * Created by piyush on 23/7/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
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

public class Splashscreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                Boolean data=sharedpreferences.getBoolean("login",false);
                if (data==true) {
                    startActivity(new Intent(Splashscreen.this, Main2Activity.class));
                    finish();
                }
                else {
                    //getOauth2();
                    Intent i = new Intent(Splashscreen.this, WelcomeActivity.class);
                    startActivity(i);
                    // close this activity
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

}