package com.trimteam.baseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerChange();
    }

    private void spinnerChange(){
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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
    }

    private void onDecimalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);
    }

    private void onBinaryBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.decimal);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);
    }

    private void onHexadecimalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.decimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.octal);
    }

    private void onOctalBase(){
        TextView t = (TextView) findViewById(R.id.base_0);
        t.setText(R.string.binary);

        t = (TextView) findViewById(R.id.base_1);
        t.setText(R.string.hexadecimal);

        t = (TextView) findViewById(R.id.base_2);
        t.setText(R.string.decimal);
    }
}
