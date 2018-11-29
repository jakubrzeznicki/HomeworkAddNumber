package pl.lodz.uni.math.kuba.homeworkandroid;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryOfCalculationsActivity extends AppCompatActivity {

    private TextView result;
    private ArrayList<String> calculateHistoryList;
    private String historyCalculateString;
    private Baza baza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_of_calculations);
        baza = new Baza(this);
        result = (TextView) findViewById(R.id.result);

        calculateHistoryList = new ArrayList<String>();
        calculateHistoryList = (ArrayList<String>) getIntent().getSerializableExtra("LIST");


        for (int i = 0; i < calculateHistoryList.size(); i++) {
            baza.dodajWyrazenie(calculateHistoryList.get(i));
      //      historyCalculateString = result.getText().toString() + "\n";
       //     result.setText(historyCalculateString + calculateHistoryList.get(i));
        }

        Cursor k = baza.dajWszystkie();
        while(k.moveToNext()){
            int nr=k.getInt(0);
            String wyrazenie=k.getString(1);
            result.setText(result.getText() + "\n" + nr + " " + wyrazenie);
        }
        calculateHistoryList.clear();
    }
}
