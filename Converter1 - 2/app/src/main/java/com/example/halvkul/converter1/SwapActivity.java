package com.example.halvkul.converter1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.R.attr.button;
import static com.example.halvkul.converter1.R.id.textView3;

/**
 * Created by Halvkul on 2/16/2017.
 */

public class SwapActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        Intent intent = getIntent();

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.imperial, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

    }
    @Override
    public void onItemSelected (AdapterView< ? > parent, View view, int position, long id){
        Spinner spinner = (Spinner) parent;

        secondChoice = parent.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }

    public void swap(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }





    public void convertNow (View view) {

        EditText enterYard = (EditText) findViewById(R.id.enterYard);
        EditText enterFoot = (EditText) findViewById(R.id.enterFoot);
        EditText enterInch = (EditText) findViewById(R.id.enterInch);
        TextView answer = (TextView) findViewById(textView3);
        TextView formatAnswer = (TextView) findViewById(R.id.formatAnswer);

        if (enterYard.getText().toString().equals("")) {
            enterYard.setText("0");
        }
        if (enterFoot.getText().toString().equals("")) {
            enterFoot.setText("0");
        }
        if (enterInch.getText().toString().equals("")) {
            enterInch.setText("0");
        }

        DecimalFormat twoZeroes = new DecimalFormat("#0.00");
        DecimalFormat noZeroes = new DecimalFormat("0.#");
        String Yard = enterYard.getText().toString();
        String Foot = enterFoot.getText().toString();
        String Inch = enterInch.getText().toString();
        Double yardDouble = Double.valueOf(Yard);
        Double footDouble = Double.valueOf(Foot);
        Double inchDouble = Double.valueOf(Inch);
        yardDouble = yardDouble * 1.09361;
        footDouble = footDouble * 0.109361;
        inchDouble = inchDouble * 0.0109361;
        Double result;
        String resultDecimals;

        switch (secondChoice) {
            case "Yard":
                result = (yardDouble + inchDouble + footDouble);
                resultDecimals = twoZeroes.format(result);
                answer.setText(resultDecimals + "yd");
                break;
            case "Foot":
                result = (yardDouble + inchDouble + footDouble) * 3;
                resultDecimals = twoZeroes.format(result);
                answer.setText(resultDecimals + "ft");
                break;
            case "Inch":
                result = (yardDouble + inchDouble + footDouble) * 36;
                resultDecimals = twoZeroes.format(result);
                answer.setText(resultDecimals + "in");
                break;
            default:
                answer.setText("0");
        }

    }

}
