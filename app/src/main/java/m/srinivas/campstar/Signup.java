package m.srinivas.campstar;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import m.srinivas.campstar.Helper.Validations;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Signup extends Activity implements View.OnClickListener {
    TextView login_tv;
    ProgressDialog pd;
    Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        register_btn = findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);
        login_tv = (TextView) findViewById(R.id.login_tv);
        login_tv.setOnClickListener(this);
        givepermissionaccess();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED
        ) {
            //resume tasks needing this permission

        } else {
            //finish();
            Toast.makeText(getBaseContext(), "you can not use this application without givivng access to ur location Thanks!!", Toast.LENGTH_SHORT).show();


        }
    }

    public void givepermissionaccess() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE}, 0);
        } else {
            Toast.makeText(getBaseContext(), "All permissions granted.", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                if (Validations.hasActiveInternetConnection(Signup.this)) {
                    pd = new ProgressDialog(this);
                    pd.setMessage("Fetching Messages..");
                    pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pd.setIndeterminate(true);
                    pd.setCancelable(false);
                    pd.show();
                    try {
                        GetLeaveBalancesByEmpID();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                }
                break;
            case R.id.login_tv:


                break;
        }
    }


    public void GetLeaveBalancesByEmpID() throws IOException {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();


        RequestBody formBody = new FormBody.Builder()
                .add("FullName", "Suresh")
                .add("UserEmail", "saragadamsures1@gmail.com")
                .add("UserPassword", "Suresh")
                .add("FullName", "Suresh")
                .add("UserPassword_confirmation", "Suresh")
                .add("UserPhone", "9010303509")
                .add("MCC", "12")
              /*  .add("UserCity", "Visakhapatnam")
                .add("UserState", "AndhraPradesh")
                .add("UserCountry", "India")
                .add("RegType", "2")
                .add("UserDob", "2018-07-01")
                .add("UserSex", "Male")
                .add("UserStatus", "Hello")
                .add("AboutUser", "Nothing hto worry")
                .add("UserJob", "Private Employee")
                .add("password", "Suresh")*/
                .build();
        Request request = new Request.Builder()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .url("http://campstar.in/campstar_api_services/public/api/register")
                .post(formBody)
                .build();



        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d("result", e.getMessage().toString());
                e.printStackTrace();
            }

            @Override
            public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {
                pd.dismiss();
                if (!response.isSuccessful()) {
                    Log.d("result", response.toString());
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d("result", response.toString());
                    String responseBody = response.body().string();
                    JSONObject obj;
                    try {
                        obj = new JSONObject(responseBody);
                        System.out.println("JONDDDd " + obj.getString("token"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


}
