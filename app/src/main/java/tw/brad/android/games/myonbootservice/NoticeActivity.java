package tw.brad.android.games.myonbootservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        tv = (TextView)findViewById(R.id.tv);
        Intent it = getIntent();
        int key = it.getIntExtra("key", -1);
        tv.setText("Key: " + key);


    }
}
