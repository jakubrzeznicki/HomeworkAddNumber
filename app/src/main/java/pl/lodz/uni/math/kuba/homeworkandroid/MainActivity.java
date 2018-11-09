package pl.lodz.uni.math.kuba.homeworkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Button addNumberButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNumberActivity.class);
                intent.putExtra("FIRST_NUMBER", firstNumberEditText.getText().toString());
                intent.putExtra("SECOND_NUMBER", secondNumberEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void init() {
        firstNumberEditText = (EditText) findViewById(R.id.first_number_edit_text);
        secondNumberEditText = (EditText) findViewById(R.id.second_number_edit_text);
        addNumberButton = (Button) findViewById(R.id.add_number_button);
    }
}
