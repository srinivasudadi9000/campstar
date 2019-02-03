package m.srinivas.campstar;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class Login extends Activity implements View.OnClickListener {
    TextView signup_tv, forgotpassword_tv;
    EditText email_et,password_tv;
    Button login_btn;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
        forgotpassword_tv = (TextView) findViewById(R.id.forgotpassword_tv);
        forgotpassword_tv.setOnClickListener(this);
        signup_tv = (TextView) findViewById(R.id.signup_tv);
        signup_tv.setOnClickListener(this);

        password_tv = findViewById(R.id.password_tv);
        email_et = findViewById(R.id.email_et);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_tv:
                Intent signup = new Intent(Login.this, Signup.class);
                startActivity(signup);
                break;
            case R.id.forgotpassword_tv:
                Intent forgotpassword_tv = new Intent(Login.this, Forgotpassword.class);
                startActivity(forgotpassword_tv);
                break;
            case R.id.login_btn:
                if (Validations.hasActiveInternetConnection(Login.this)) {
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
                }else{

                }


                break;
        }
    }

    public void GetLeaveBalancesByEmpID() throws IOException {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();


        RequestBody formBody = new FormBody.Builder()
               /* .add("UserEmail", "ramakrishna.sud@gmail.com")
                .add("password", "ramakrishna")*/
                .add("UserEmail", email_et.getText().toString())
                .add("password", password_tv.getText().toString())
                .build();
        Request request = new Request.Builder()
                .url("http://campstar.in/campstar_api_services/public/api/login?")
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
                        System.out.println("JONDDDd "+obj.toString());
                        System.out.println("JONDDDd "+obj.getString("token"));

                        Login.this.login_btn.post(new Runnable() {
                            public void run() {
                                showDialog(Login.this,"Successfully Logged in","true");
                            }
                        });


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    public void showDialog(Activity activity, String msg, final String status) {
        final Dialog dialog = new Dialog(activity, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        ImageView b = dialog.findViewById(R.id.b);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
