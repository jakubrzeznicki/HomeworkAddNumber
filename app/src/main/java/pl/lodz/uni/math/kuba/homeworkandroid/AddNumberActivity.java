package pl.lodz.uni.math.kuba.homeworkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddNumberActivity extends AppCompatActivity {

    private TextView result;
    private String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_number);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s1 = extras.getString("FIRST_NUMBER");
            s2 =  extras.getString("SECOND_NUMBER");
        }
        result = (TextView) findViewById(R.id.result);

        result.setText(Integer.toString(Integer.parseInt(s1) + Integer.parseInt(s2)));
    }
}
