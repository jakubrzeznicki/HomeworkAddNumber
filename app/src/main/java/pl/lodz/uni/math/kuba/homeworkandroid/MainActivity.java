package pl.lodz.uni.math.kuba.homeworkandroid;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {
    private TextView resultOfCalculationsView;
    private String result = "";
    private Button clickedButton;
    private Database database = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }

    private void initializeVariables() {
        resultOfCalculationsView = findViewById(R.id.result_text_view);
    }

    private String formatDoubleToString(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else {
            return String.format("%s", d);
        }
    }

    public void equalButtonOnClick(View view) {
        if (result != "") {
            try {
                Expression expression = new ExpressionBuilder(result).build();
                double calculated = expression.evaluate();
                resultOfCalculationsView.setText(formatDoubleToString(calculated));
                database.addValue(result + " = " + calculated);
                result = "";
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "wrong data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void backButtonOnClick(View view) {
        if (result != null) {
            if (result.length() > 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        resultOfCalculationsView.setText(result);
    }

    public void mathOperatorButtonOnClick(View view) {
        clickedButton = (Button) view;
        String mathOperator = clickedButton.getText().toString();
        result += mathOperator;
        resultOfCalculationsView.setText(result);
    }


    public void commaSignButtonOnClick(View view) {
        if (result != "") {
            result += ".";
            resultOfCalculationsView.setText(result);
        }
    }

    public void historyButtonOnClick(View view) {
        Intent intent = new Intent(this, HistoryOfCalculationsActivity.class);
        startActivity(intent);
    }

    public void resetTextViewButtonOnClick(View view) {
        result = "";
        resultOfCalculationsView.setText(result);

    }

    public void numberButtonOnClick(View view) {
        clickedButton = (Button) view;
        String number = clickedButton.getText().toString();
        result += number;
        resultOfCalculationsView.setText(result);
    }
}

