package com.example.volumeconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

        private EditText inputValue;
        private RadioGroup radioGroupFrom;
        private RadioGroup radioGroupTo;
        private TextView resultTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            inputValue = findViewById(R.id.inputValue);
            radioGroupFrom = findViewById(R.id.radioGroupFrom);
            radioGroupTo = findViewById(R.id.radioGroupTo);
            resultTextView = findViewById(R.id.resultTextView);

            Button convertButton = findViewById(R.id.convertButton);
            convertButton.setOnClickListener(view -> {
                double input = Double.parseDouble(inputValue.getText().toString());
                double result = 0;

                int fromId = radioGroupFrom.getCheckedRadioButtonId();
                int toId = radioGroupTo.getCheckedRadioButtonId();

                if (fromId == R.id.literButton) {
                    if (toId == R.id.milliliterButton) {
                        result = input * 1000;
                    } else if (toId == R.id.gallonButton) {
                        result = input * 0.264172;
                    } else if (toId == R.id.cubicMeterButton) {
                        result = input;
                    }
                } else if (fromId == R.id.milliliterButton) {
                    if (toId == R.id.literButton) {
                        result = input / 1000;
                    } else if (toId == R.id.gallonButton) {
                        result = input * 0.000264172;
                    } else if (toId == R.id.cubicMeterButton) {
                        result = input / 1000;
                    }
                } else if (fromId == R.id.gallonButton) {
                    if (toId == R.id.literButton) {
                        result = input * 3.78541;
                    } else if (toId == R.id.milliliterButton) {
                        result = input * 3785.41;
                    } else if (toId == R.id.cubicMeterButton) {
                        result = input * 0.00378541;
                    }
                } else if (fromId == R.id.cubicMeterButton) {
                    if (toId == R.id.literButton) {
                        result = input * 1000;
                    } else if (toId == R.id.milliliterButton) {
                        result = input * 1000000;
                    } else if (toId == R.id.gallonButton) {
                        result = input * 264.172;
                    }
                }

                resultTextView.setText(String.format("%.2f", result));
            });
}}