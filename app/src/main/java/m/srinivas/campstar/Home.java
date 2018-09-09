package m.srinivas.campstar;

import android.app.Activity;
import android.content.Intent;
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
    LinearLayout logout_ll, notification_ll, share_ll, feedback_ll, settings_ll, profile_ll, home_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        logout_ll = (LinearLayout) findViewById(R.id.logout_ll);
        notification_ll = (LinearLayout) findViewById(R.id.notification_ll);
        share_ll = (LinearLayout) findViewById(R.id.share_ll);
        feedback_ll = (LinearLayout) findViewById(R.id.feedback_ll);
        settings_ll = (LinearLayout) findViewById(R.id.settings_ll);
        profile_ll = (LinearLayout) findViewById(R.id.profile_ll);
        home_ll = (LinearLayout) findViewById(R.id.home_ll);

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

        logout_ll.setOnClickListener(this);
        notification_ll.setOnClickListener(this);
        share_ll.setOnClickListener(this);
        feedback_ll.setOnClickListener(this);
        settings_ll.setOnClickListener(this);
        profile_ll.setOnClickListener(this);
        home_ll.setOnClickListener(this);
        //  myll = (LinearLayout) findViewById(R.id.myll);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_ll:
                home_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                home_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;
            case R.id.profile_ll:
                profile_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                profile_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));

                Intent profile = new Intent(Home.this,MyProfile.class);
                startActivity(profile);
                break;
            case R.id.settings_ll:
                settings_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                settings_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;
            case R.id.feedback_ll:
                feedback_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                feedback_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;
            case R.id.share_ll:
                share_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                share_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;
            case R.id.notification_ll:
                notification_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                notification_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;
            case R.id.logout_ll:
                logout_img.setColorFilter(ContextCompat.getColor(Home.this, R.color.tint_logo), android.graphics.PorterDuff.Mode.MULTIPLY);
                logout_txt.setTextColor(getResources().getColor(R.color.splash_bg_color));
                break;

        }
    }
}
