package pl.lodz.uni.math.kuba.homeworkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText numberEditText;
    private TextView showResultTextView;
    private Button addNumberButton;
    private Button subtractNumberButton;
    private Button multiplyNumberButton;
    private Button divideNumberButton;
    private Button calculateButton;
    private Button calculateHistoryButton;
    private String result;
    private BigDecimal score = null;
    private ArrayList<String> calculateHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateHistoryList = new ArrayList<String>();

        init();

        addingOperationOnButton();
        subtractionOperationOnButton();
        multiplicationOperationOnButton();
        divisionOperationOnButton();

        calculateMathematicalEquation();

        goToHistoryOfCalculations();
    }

    private void init() {
        numberEditText = (EditText) findViewById(R.id.number_edit_text);
        showResultTextView = (TextView) findViewById(R.id.show_result_text_view);
        addNumberButton = (Button) findViewById(R.id.add_number_button);
        subtractNumberButton = (Button) findViewById(R.id.subtract_number_button);
        multiplyNumberButton = (Button) findViewById(R.id.multiply_number_button);
        divideNumberButton = (Button) findViewById(R.id.divide_number_button);
        calculateButton = (Button) findViewById(R.id.calculate_button);
        calculateHistoryButton = (Button) findViewById(R.id.calculate_history_button);
    }

    private void checkMathematicalOperation(char character) {
        result = numberEditText.getText().toString();
        if (!(numberEditText.getText().toString().equals(""))) {
            if (result.charAt(result.length() - 1) != character) {
                numberEditText.setText(result + character);

            }
        } else {
            numberEditText.setText(result + character);
        }
        numberEditText.setSelection(numberEditText.getText().length());
    }

    private void addingOperationOnButton() {
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMathematicalOperation('+');
            }
        });

    }

    private void subtractionOperationOnButton() {
        subtractNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMathematicalOperation('-');
            }
        });

    }

    private void multiplicationOperationOnButton() {
        multiplyNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMathematicalOperation('*');
            }
        });
    }

    private void divisionOperationOnButton() {
        divideNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMathematicalOperation('/');
            }
        });
    }

    private void calculateMathematicalEquation() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = new Expression(numberEditText.getText().toString()).eval();
                showResultTextView.setText(score.toString());
                calculateHistoryList.add(numberEditText.getText().toString() + " = " + score.toString());
            }
        });
    }

    private void goToHistoryOfCalculations() {
        calculateHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryOfCalculationsActivity.class);
                intent.putExtra("LIST", calculateHistoryList);
                startActivity(intent);
            }
        });
    }
}
