package com.route.androidbasicsfridayc43;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    TextView resultTv;
    String lhs = "";
    String savedOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.resultTv);

    }

    //7 + 10 + 20
    public void onDigitClick(View v) {
        TextView clickedText = (TextView) v;
        if(resultTv.getText().toString().contains(".")
                && clickedText.getText().toString().equals(".")){
            return;
        }
        resultTv.append(clickedText.getText());
    }

    public void onOperatorClick(View v) {
        TextView clickedOperator = (TextView) v;
        if (savedOperator.isEmpty()) {
            lhs = resultTv.getText().toString();
        } else {
            lhs = calculate(lhs, savedOperator, resultTv.getText().toString());
        }
        savedOperator = clickedOperator.getText().toString();
        resultTv.setText("");
        Log.e("Calculator", "LHS: " + lhs + " Saved Operator: " + savedOperator);
    }

    public void onEqualClick(View v){
      String result =  calculate(lhs, savedOperator, resultTv.getText().toString());
      resultTv.setText(result);
      lhs = "";
      savedOperator = "";
    }

    String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);
        if (operator.equals("+")) {
            return n1 + n2 + "";
        } else if (operator.equals("-")) {
            return n1 - n2 + "";
        } else if (operator.equals("*")) {
            return n1 * n2 + "";
        } else {
            return n1 / n2 + "";
        }
    }
}

///Syntax
///Runtime
///Logical