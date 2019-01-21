package pl.lodz.uni.math.kuba.homeworkandroid;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryOfCalculationsActivity extends AppCompatActivity {
    private TextView listOfResults;
    private ArrayList<String> historyList;
    private Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_of_calculations);

        initializeVariables();

        setListOfResults();
    }

    @Override
    protected void onDestroy() {
        database.close();
        super.onDestroy();
    }

    private void setListOfResults() {
        historyList = database.getAll();
        for (int i = 0; i < historyList.size(); i++) {
            listOfResults.setText(listOfResults.getText() + "\n" + historyList.get(i));
        }
    }

    private void initializeVariables() {
        database = new Database(this);
        listOfResults = (TextView) findViewById(R.id.list_of_results_tv);
    }


}
