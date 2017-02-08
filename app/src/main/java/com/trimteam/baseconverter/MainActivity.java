package com.trimteam.baseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button button;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerChange();
    }

    private void spinnerChange(){
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.convert_button);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.position = position;
                switch(position){
                    case 0:
                        onDecimalBase();
                        break;
                    case 1:
                        onBinaryBase();
                        break;
                    case 2:
                        onHexadecimalBase();
                        break;
                    case 3:
                        onOctalBase();
                        break;
                    default:
                        onDecimalBase();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                onDecimalBase();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        onDecimalBaseValue();
                        break;
                    case 1:
                        onBinaryBaseValue();
                        break;
                    case 2:
                        onHexadecimalBaseValue();
                        break;
                    case 3:
                        onOctalBaseValue();
                        break;
                    default:
                        onDecimalBaseValue();
                }
            }
        });

    }


    private void onDecimalBaseValue(){
        EditText editInsert  = (EditText) findViewById(R.id.insert_value_field);
        String string = editInsert.getText().toString();
        if(string  == null || string.isEmpty()) return ;
        long value = Long.valueOf(string);
        EditText editTextBase0 = (EditText) findViewById(R.id.base_0_value);
        editTextBase0.setText(Converter.convertDecimalBinary(value));
        EditText editTextBase1 = (EditText) findViewById(R.id.base_1_value);
        editTextBase1.setText(Converter.convertDecimalHexa(value));
        EditText editTextBase2 = (EditText) findViewById(R.id.base_2_value);
        editTextBase2.setText(Converter.convertDecimalOctal(value));
    }

    private void onBinaryBaseValue(){
        EditText editInsert  = (EditText) findViewById(R.id.insert_value_field);
        String string = editInsert.getText().toString() ;
        if(string  == null || string.isEmpty()) return ;

        long value = Long.valueOf(string);
        EditText editTextBase0 = (EditText) findViewById(R.id.base_0_value);
        editTextBase0.setText(Converter.convertBinaryDecimal(value));
        EditText editTextBase1 = (EditText) findViewById(R.id.base_1_value);
        editTextBase1.setText(Converter.convertBinaryHexa(value));
        EditText editTextBase2 = (EditText) findViewById(R.id.base_2_value);
        editTextBase2.setText(Converter.convertBinaryOctal(value));
    }

    private void onHexadecimalBaseValue(){
        EditText editInsert  = (EditText) findViewById(R.id.insert_value_field);
        String value = editInsert.getText().toString();
        if(value  == null || value.isEmpty()) return ;

        EditText editTextBase0 = (EditText) findViewById(R.id.base_0_value);
        editTextBase0.setText(Converter.convertHexaBinary(value));
        EditText editTextBase1 = (EditText) findViewById(R.id.base_1_value);
        editTextBase1.setText(Converter.convertHexaDecimal(value));
        EditText editTextBase2 = (EditText) findViewById(R.id.base_2_value);
        editTextBase2.setText(Converter.convertHexaOctal(value));
    }

    private void onOctalBaseValue(){
        EditText editInsert  = (EditText) findViewById(R.id.insert_value_field);
        String string = editInsert.getText().toString() ;
        if(string  == null || string.isEmpty()) return ;

        long value = Long.valueOf(string);
        EditText editTextBase0 = (EditText) findViewById(R.id.base_0_value);
        editTextBase0.setText(Converter.convertOctalBinary(value));
        EditText editTextBase1 = (EditText) findViewById(R.id.base_1_value);
        editTextBase1.setText(Converter.convertOctalHexa(value));
        EditText editTextBase2 = (EditText) findViewById(R.id.base_2_value);
        editTextBase2.setText(Converter.convertOctalDecimal(value));

    }
    private void onDecimalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);
        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);

        EditText editTextBase0 = (EditText) findViewById(R.id.insert_value_field);
        editTextBase0.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
     //   editTextBase0.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    private void onBinaryBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.decimal);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);

        EditText editTextBase0 = (EditText) findViewById(R.id.insert_value_field);
        editTextBase0.setKeyListener(DigitsKeyListener.getInstance("01"));
       // editTextBase0.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);


    }

    private void onHexadecimalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.decimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);
        EditText editTextBase0 = (EditText) findViewById(R.id.insert_value_field);

        editTextBase0.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEF"));
        editTextBase0.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS );


    }

    private void onOctalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.decimal);

        EditText editTextBase0 = (EditText) findViewById(R.id.insert_value_field);
        editTextBase0.setKeyListener(DigitsKeyListener.getInstance("01234567"));
       // editTextBase0.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);


    }
}
