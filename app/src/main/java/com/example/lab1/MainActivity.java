
package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements {
    TextView resultDisplay, solutionDisplay;
    Button buttonC, buttonOpenBracket,buttonEndBracket,buttonDivide, button7,button8,button9;
    Button buttonMultiply,button4,button5,button6,buttonMinus,button1,button2,button3,buttonPlus;
    Button buttonAC,button0,buttonComma,buttonEquals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay=findViewById(R.id.resultDisplay);
        solutionDisplay=findViewById(R.id.solutionDisplay);

        assignID(buttonC, R.id.button_C);
        assignID(buttonOpenBracket, R.id.button_OpenBracket);
        assignID(buttonEndBracket, R.id.button_endBracket);
        assignID(buttonDivide, R.id.button_Divide);
        assignID(button7, R.id.button_7);
        assignID(button8, R.id.button_8);
        assignID(button9, R.id.button_9);
        assignID(buttonMultiply, R.id.button_Multiply);
        assignID(button4, R.id.button_4);
        assignID(button5, R.id.button_5);
        assignID(button6, R.id.button_6);
        assignID(button1, R.id.button_1);
        assignID(button2, R.id.button_2);
        assignID(button3, R.id.button_3);
        assignID(buttonPlus, R.id.button_Plus);
        assignID(buttonMinus, R.id.button_Minus);
        assignID(buttonAC, R.id.button_AC);
        assignID(button0, R.id.button_AC);
        assignID(buttonComma, R.id.button_Comma);
        assignID(buttonEquals, R.id.button_Equals);
        assignID(buttonC, R.id.button_C);
    }

    void assignID(Button btn, int id)
    {
        btn=findViewById(id);
        btn.setOnClickListener((View.OnClickListener) this);
    }

    public void OnClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        solutionDisplay.setText(buttonText);
    }
}