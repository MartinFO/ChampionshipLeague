package com.example.android.championshipleague;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String current_keypad_string = ""; // Holds the number entered on the keypad
    String dart1_multiplier_string = "S";
    String dart1_points_string = "0";
    String dart2_multiplier_string = "S";
    String dart2_points_string = "0";
    String dart3_multiplier_string = "S";
    String dart3_points_string = "0";
    String current_team_string = "Team A"; // Can be "Team A" or "Team B"
    int int_current_dart = 1; // Can be 1, 2, or 3
    int int_teamA_score = 301;
    int int_teamB_score = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // User has pressed a numeric key or the bull
    public void press1(View view) {
        pressNumber("1");
    }

    public void press2(View view) {
        pressNumber("2");
    }

    public void press3(View view) {
        pressNumber("3");
    }

    public void press4(View view) {
        pressNumber("4");
    }

    public void press5(View view) {
        pressNumber("5");
    }

    public void press6(View view) {
        pressNumber("6");
    }

    public void press7(View view) {
        pressNumber("7");
    }

    public void press8(View view) {
        pressNumber("8");
    }

    public void press9(View view) {
        pressNumber("9");
    }

    public void press0(View view) {
        pressNumber("0");
    }

    public void pressBull(View view) {
        current_keypad_string = "";
        pressNumber("25");
    }

    public void pressNumber(String key_string) {
        current_keypad_string = current_keypad_string + key_string;
        switch (int_current_dart) {
            case 1:
                dart1_points_string = current_keypad_string;
                break;
            case 2:
                dart2_points_string = current_keypad_string;
                break;
            case 3:
                dart3_points_string = current_keypad_string;
                break;
            default:
                dart1_points_string = "X";
                break;
        }
        displayDartsStatusLine();
    }

    // User has pressed the S, D, or T  multiplier keys
    public void pressS(View view) {
        pressMultiplier("S");
    }

    public void pressD(View view) {
        pressMultiplier("D");
    }

    public void pressT(View view) {
        pressMultiplier("T");
    }

    public void pressMultiplier(String multiplier_string) {
        if (current_keypad_string != "") {
            int_current_dart = int_current_dart + 1;
        }
        switch (int_current_dart) {
            case 1:
                dart1_multiplier_string = multiplier_string;
                break;
            case 2:
                dart2_multiplier_string = multiplier_string;
                break;
            case 3:
                dart3_multiplier_string = multiplier_string;
                break;
            default:
                dart1_multiplier_string = "X";
                break;
        }
        current_keypad_string = "";
        displayDartsStatusLine();
    }

    public void pressPost(View view) {
        int int_dart1_multiplier = 1;
        int int_dart1_score = 0;
        int int_dart2_multiplier = 1;
        int int_dart2_score = 0;
        int int_dart3_multiplier = 1;
        int int_dart3_score = 0;
        int int_total_score = 0;

        // Compute total score for all three darts
        // Set the integer dart multiplier for dart 1
        switch (dart1_multiplier_string) {
            case "S":
                int_dart1_multiplier = 1;
                break;
            case "D":
                int_dart1_multiplier = 2;
                break;
            case "T":
                int_dart1_multiplier = 3;
                break;
            default:
                errorSignal();
                break;
        }
        // Set the integer dart score for dart 1
        int_dart1_score = Integer.parseInt(dart1_points_string);

        // Set the integer dart multiplier for dart 2
        switch (dart2_multiplier_string) {
            case "S":
                int_dart2_multiplier = 1;
                break;
            case "D":
                int_dart2_multiplier = 2;
                break;
            case "T":
                int_dart2_multiplier = 3;
                break;
            default:
                errorSignal();
                break;
        }
        // Set the integer dart score for dart 2
        int_dart2_score = Integer.parseInt(dart2_points_string);

        // Set the integer dart multiplier for dart 3
        switch (dart3_multiplier_string) {
            case "S":
                int_dart3_multiplier = 1;
                break;
            case "D":
                int_dart3_multiplier = 2;
                break;
            case "T":
                int_dart3_multiplier = 3;
                break;
            default:
                errorSignal();
                break;
        }
        // Set the integer dart score for dart 3
        int_dart3_score = Integer.parseInt(dart3_points_string);

        // Compute total score for all three darts
        int_total_score = (int_dart1_score * int_dart1_multiplier) + (int_dart2_score * int_dart2_multiplier) + (int_dart3_score * int_dart3_multiplier);

        // Compute the new score for the current team and post the score
        switch (current_team_string) {
            case "Team A":
                int_teamA_score = int_teamA_score - int_total_score;
                TextView teamA_score_TextView = (TextView) findViewById(R.id.scoreA);
                teamA_score_TextView.setText(Integer.toString(int_teamA_score));
                break;
            case "Team B":
                int_teamB_score = int_teamB_score - int_total_score;
                TextView teamB_score_TextView = (TextView) findViewById(R.id.scoreB);
                teamB_score_TextView.setText(Integer.toString(int_teamB_score));
                break;
            default:
                errorSignal();
                break;
        }
        // Initialize the variables for the next turn
        dart1_multiplier_string = "S";
        dart1_points_string = "0";
        dart2_multiplier_string = "S";
        dart2_points_string = "0";
        dart3_multiplier_string = "S";
        dart3_points_string = "0";
        current_keypad_string = "";
        int_current_dart = 1;
        displayDartsStatusLine();

        // Switch to the other team
        if (TextUtils.equals(current_team_string, "Team A")) {
            current_team_string = "Team B";
        } else if (TextUtils.equals(current_team_string, "Team B")) {
            current_team_string = "Team A";
        } else {
            errorSignal();
        }

    }

    public void pressAB (View view) {
        // Initialize variables for current turn
        dart1_multiplier_string = "S";
        dart1_points_string = "0";
        dart2_multiplier_string = "S";
        dart2_points_string = "0";
        dart3_multiplier_string = "S";
        dart3_points_string = "0";
        current_keypad_string = "";
        int_current_dart = 1;
        // Display initialized darts status
        displayDartsStatusLine();
        // Switch to the other team
        if (TextUtils.equals(current_team_string, "Team A")) {
            current_team_string = "Team B";
        } else if (TextUtils.equals(current_team_string, "Team B")) {
            current_team_string = "Team A";
        } else {
            errorSignal();
        }

    }

    public void pressReset (View view) {
        // Initialize variables for current turn
        dart1_multiplier_string = "S";
        dart1_points_string = "0";
        dart2_multiplier_string = "S";
        dart2_points_string = "0";
        dart3_multiplier_string = "S";
        dart3_points_string = "0";
        current_keypad_string = "";
        int_current_dart = 1;
        // Display initialized darts status
        displayDartsStatusLine();
    }

    public void pressGameReset (View view) {
        // Initialize variables for current turn
        dart1_multiplier_string = "S";
        dart1_points_string = "0";
        dart2_multiplier_string = "S";
        dart2_points_string = "0";
        dart3_multiplier_string = "S";
        dart3_points_string = "0";
        current_keypad_string = "";
        int_current_dart = 1;
        // Display initialized darts status
        displayDartsStatusLine();
        // Initialize both teams' scores
        int_teamA_score = 301;
        int_teamB_score = 301;
        // Post the new score for dart A
        TextView teamA_score_TextView = (TextView) findViewById(R.id.scoreA);
        teamA_score_TextView.setText(Integer.toString(int_teamA_score));
        // Post the new score for dart B
        TextView teamB_score_TextView = (TextView) findViewById(R.id.scoreB);
        teamB_score_TextView.setText(Integer.toString(int_teamB_score));
        // Let Team A take the first turn
        current_team_string = "Team A";
    }


    // Display entire darts status line
    private void displayDartsStatusLine() {
        // Display dart 1 multiplier and points
        TextView dart_1_multiplier_TextView = (TextView) findViewById(R.id.text_dart_1_multiplier);
        dart_1_multiplier_TextView.setText(dart1_multiplier_string);
        TextView dart1_points_TextView = (TextView) findViewById(R.id.text_dart_1_points);
        dart1_points_TextView.setText(dart1_points_string);
        // Display dart 2 multiplier and points
        TextView dart_2_multiplier_TextView = (TextView) findViewById(R.id.text_dart_2_multiplier);
        dart_2_multiplier_TextView.setText(dart2_multiplier_string);
        TextView dart2_points_TextView = (TextView) findViewById(R.id.text_dart_2_points);
        dart2_points_TextView.setText(dart2_points_string);
        // Display dart 3 multiplier and points
        TextView dart_3_multiplier_TextView = (TextView) findViewById(R.id.text_dart_3_multiplier);
        dart_3_multiplier_TextView.setText(dart3_multiplier_string);
        TextView dart3_points_TextView = (TextView) findViewById(R.id.text_dart_3_points);
        dart3_points_TextView.setText(dart3_points_string);
    }

    public void errorSignal() {
        // Signals an error by changing "Team A" and "Team B" to "Error"
        // Error is most likely an unexpected default in a case statement
        String error_string = "Error";
        TextView error_A_TextView = (TextView) findViewById(R.id.teamA);
        error_A_TextView.setText(error_string);
        TextView error_B_TextView = (TextView) findViewById(R.id.teamB);
        error_B_TextView.setText(error_string);

    }


}
