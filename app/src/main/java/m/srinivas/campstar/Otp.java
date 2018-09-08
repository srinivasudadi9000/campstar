package m.srinivas.campstar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Otp extends Activity implements View.OnClickListener {
Button changeno_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);
        changeno_btn = (Button) findViewById(R.id.changeno_btn);
        changeno_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeno_btn:
                Intent home = new Intent(Otp.this,Home.class);
                startActivity(home);
                break;
        }
    }
}
