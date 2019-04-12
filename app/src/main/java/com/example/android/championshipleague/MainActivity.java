package com.example.android.championshipleague;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String text_current_string = "";
    int int_current_dart = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void press1 (View view) {
        text_current_string = "1";
        switch (int_current_dart) {
            case 1:
                displayDart1Points(text_current_string);
                break;
            case 2:
                displayDart2Points(text_current_string);
                break;
            case 3:
                displayDart3Points(text_current_string);
                break;
            default:
                text_current_string = "X";
                displayDart1Points(text_current_string);
                displayDart2Points(text_current_string);
                displayDart3Points(text_current_string);
                break;
        }
    }
    private void displayDart1Multiplier (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_1_multiplier);
        quantityTextView.setText("" + dart_text);
    }
    private void displayDart1Points (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_1_points);
        quantityTextView.setText("" + dart_text);
    }
    private void displayDart2Multiplier (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_2_multiplier);
        quantityTextView.setText("" + dart_text);
    }
    private void displayDart2Points (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_2_points);
        quantityTextView.setText("" + dart_text);
    }
    private void displayDart3Multiplier (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_3_multiplier);
        quantityTextView.setText("" + dart_text);
    }
    private void displayDart3Points (String dart_text) {
        TextView quantityTextView = (TextView) findViewById(R.id.text_dart_3_points);
        quantityTextView.setText("" + dart_text);
    }

}
