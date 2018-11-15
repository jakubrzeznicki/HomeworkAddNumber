package pl.lodz.uni.math.kuba.homeworkandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryOfCalculationsActivity extends AppCompatActivity {

    private TextView result;
    private ArrayList<String> calculateHistoryList;
    private String historyCalculateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_of_calculations);

        calculateHistoryList = new ArrayList<String>();
        calculateHistoryList = (ArrayList<String>) getIntent().getSerializableExtra("LIST");
        result = (TextView) findViewById(R.id.result);
        for (int i = 0; i < calculateHistoryList.size(); i++) {
            historyCalculateString = result.getText().toString() + "\n";
            result.setText(historyCalculateString + calculateHistoryList.get(i));
        }
    }
}
