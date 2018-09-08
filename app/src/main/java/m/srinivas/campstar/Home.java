package m.srinivas.campstar;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends Activity implements View.OnClickListener {
    LinearLayout myll;
    ImageView logout_img, notification_img, share_img, feedback_img, settings_img, profile_img, home_img;
    TextView logout_txt, notification_txt, share_txt, feedback_txt, settings_txt, profile_txt, home_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        logout_img = (ImageView) findViewById(R.id.logout_img);
        notification_img = (ImageView) findViewById(R.id.notification_img);
        share_img = (ImageView) findViewById(R.id.share_img);
        feedback_img = (ImageView) findViewById(R.id.feedback_img);
        settings_img = (ImageView) findViewById(R.id.settings_img);
        profile_img = (ImageView) findViewById(R.id.profile_img);
        home_img = (ImageView) findViewById(R.id.home_img);

        logout_txt = (TextView) findViewById(R.id.logout_txt);
        notification_txt = (TextView) findViewById(R.id.notification_txt);
        share_txt = (TextView) findViewById(R.id.share_txt);
        feedback_txt = (TextView) findViewById(R.id.feedback_txt);
        settings_txt = (TextView) findViewById(R.id.settings_txt);
        profile_txt = (TextView) findViewById(R.id.profile_txt);
        home_txt = (TextView) findViewById(R.id.home_txt);

        home_img.setOnClickListener(this);
        profile_img.setOnClickListener(this);
        settings_img.setOnClickListener(this);
        feedback_img.setOnClickListener(this);
        share_img.setOnClickListener(this);
        notification_img.setOnClickListener(this);
        logout_img.setOnClickListener(this);
        //  myll = (LinearLayout) findViewById(R.id.myll);


    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.home_img:
               home_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.profile_img:
               profile_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.settings_img:
               settings_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.feedback_img:
               feedback_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.share_img:
               share_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.notification_img:
               notification_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;
           case R.id.logout_img:
               logout_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
               break;

       }
    }
}
