package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultDisplay, solutionDisplay;
    StringBuilder calcData = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay = findViewById(R.id.resultDisplay);
        solutionDisplay = findViewById(R.id.solutionDisplay);

        Button buttonC = findViewById(R.id.button_C);
        Button buttonOpenBracket = findViewById(R.id.button_OpenBracket);
        Button buttonEndBracket = findViewById(R.id.button_endBracket);
        Button buttonDivide = findViewById(R.id.button_Divide);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonMultiply = findViewById(R.id.button_Multiply);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button buttonPlus = findViewById(R.id.button_Plus);
        Button buttonMinus = findViewById(R.id.button_Minus);
        Button buttonAC = findViewById(R.id.button_AC);
        Button button0 = findViewById(R.id.button_0);
        Button buttonComma = findViewById(R.id.button_Comma);
        Button buttonEquals = findViewById(R.id.button_Equals);

        buttonC.setOnClickListener(this);
        buttonOpenBracket.setOnClickListener(this);
        buttonEndBracket.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("AC"))
        {
            calcData = new StringBuilder();
            solutionDisplay.setText("");
            resultDisplay.setText("0");
        } else if (buttonText.equals("="))
        {
            solutionDisplay.setText(calcData);
            String result = calculateResult(calcData.toString());
            resultDisplay.setText(result);
        } else if (buttonText.equals("C"))
        {
            if (calcData.length() > 0) {
                calcData.deleteCharAt(calcData.length() - 1);
            }
        }else if(buttonText.equals("X"))
        {
            calcData.append("*");
        }
        else
        {
            calcData.append(buttonText);
        }

        solutionDisplay.setText(calcData.toString());
    }

    private String calculateResult(String expression)
    {
        try
        {
            return String.valueOf(eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }

    private double eval(final String str)
    {
        return new Object() {
            int pos = -1, ch;

            void nextChar()
            {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat)
            {
                while (ch == ' ') nextChar();
                if (ch == charToEat)
                {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse()
            {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression()
            {
                double x = parseTerm();
                for (;;)
                {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm()
            {
                double x = parseFactor();
                for (;;)
                {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor()
            {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('('))
                {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else
                {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }
}
