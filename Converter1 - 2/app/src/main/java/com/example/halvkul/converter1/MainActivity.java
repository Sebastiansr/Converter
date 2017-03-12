package com.example.halvkul.converter1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


import static android.R.attr.value;
import static com.example.halvkul.converter1.R.id.activity_main;
import static com.example.halvkul.converter1.R.id.enterFoot;
import static com.example.halvkul.converter1.R.id.formatAnswer;
import static com.example.halvkul.converter1.R.id.spinner2;
import static com.example.halvkul.converter1.R.id.textView3;
import static java.lang.String.format;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    String secondChoice;
    DecimalFormat twoZeroes = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.metric, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        }
        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            Spinner spinner = (Spinner) parent;

                secondChoice = parent.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }

        public void swap(View view) {
            Intent intent = new Intent(this, SwapActivity.class);
            startActivity(intent);
        }

        public void convertNow (View view) {

            EditText enterYard = (EditText) findViewById(R.id.enterYard);
            EditText enterFoot = (EditText) findViewById(R.id.enterFoot);
            EditText enterInch = (EditText) findViewById(R.id.enterInch);
            TextView answer = (TextView) findViewById(textView3);

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
            String Yard = enterYard.getText().toString();
            String Foot = enterFoot.getText().toString();
            String Inch = enterInch.getText().toString();
            Double yardDouble = new Double(Yard);
            Double footDouble = new Double(Foot);
            Double inchDouble = new Double(Inch);
            yardDouble = yardDouble * 0.9144;
            inchDouble = inchDouble * 0.0254;
            footDouble = footDouble / 3.28;
            Double result;
            String resultDecimals;

            switch (secondChoice) {
                case "Metre":
                    result = (yardDouble + inchDouble + footDouble);
                    resultDecimals = twoZeroes.format(result);
                    answer.setText(resultDecimals + "m");
                    break;
                case "Decimetre":
                    result = (yardDouble + inchDouble + footDouble) * 10;
                    resultDecimals = twoZeroes.format(result);
                    answer.setText(resultDecimals + "dm");
                    break;
                case "Centimetre":
                    result = (yardDouble + inchDouble + footDouble) * 100;
                    resultDecimals = twoZeroes.format(result);
                    answer.setText(resultDecimals + "cm");
                    break;
                default:
                    answer.setText("0");
            }


            }

        }










    //public void convert(){




