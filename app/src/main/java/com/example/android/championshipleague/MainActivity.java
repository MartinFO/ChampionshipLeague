package com.example.android.championshipleague;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String current_keypad_string = ""; // Holds the number entered on the keypad
    private String dart1_multiplier_string = "S";
    private String dart1_points_string = "0";
    private String dart2_multiplier_string = "S";
    private String dart2_points_string = "0";
    private String dart3_multiplier_string = "S";
    private String dart3_points_string = "0";
    private String current_team_string = "Team A"; // Can be "Team A" or "Team B"
    private int int_current_dart = 1; // Can be 1, 2, or 3
    private int int_teamA_score = 301;
    private int int_teamB_score = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable the Post key
        Button button = findViewById(R.id.button_post);
        button.setEnabled(false);

    }

    private void initializeVariablesForNextTurn() {
        dart1_multiplier_string = "S";
        dart1_points_string = "0";
        dart2_multiplier_string = "S";
        dart2_points_string = "0";
        dart3_multiplier_string = "S";
        dart3_points_string = "0";
        current_keypad_string = "";
        int_current_dart = 1;
        enableAllButtons();
        // Disable Post button
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(false);
        // Hide the "BUST" message for exceeding the remaining points
        TextView bust_TextView = findViewById(R.id.bust);
        bust_TextView.setVisibility(View.GONE);
        TextView game_TextView = findViewById(R.id.game_won);
        game_TextView.setVisibility(View.GONE);
    }

    private void disableNumericKeys() {
        Button button = findViewById(R.id.button_1);
        button.setEnabled(false);
        button = findViewById(R.id.button_2);
        button.setEnabled(false);
        button = findViewById(R.id.button_3);
        button.setEnabled(false);
        button = findViewById(R.id.button_4);
        button.setEnabled(false);
        button = findViewById(R.id.button_5);
        button.setEnabled(false);
        button = findViewById(R.id.button_6);
        button.setEnabled(false);
        button = findViewById(R.id.button_7);
        button.setEnabled(false);
        button = findViewById(R.id.button_8);
        button.setEnabled(false);
        button = findViewById(R.id.button_9);
        button.setEnabled(false);
        button = findViewById(R.id.button_0);
        button.setEnabled(false);
    }

    private void disableAllButtons() {
        Button button = findViewById(R.id.button_1);
        button.setEnabled(false);
        button = findViewById(R.id.button_2);
        button.setEnabled(false);
        button = findViewById(R.id.button_3);
        button.setEnabled(false);
        button = findViewById(R.id.button_4);
        button.setEnabled(false);
        button = findViewById(R.id.button_5);
        button.setEnabled(false);
        button = findViewById(R.id.button_6);
        button.setEnabled(false);
        button = findViewById(R.id.button_7);
        button.setEnabled(false);
        button = findViewById(R.id.button_8);
        button.setEnabled(false);
        button = findViewById(R.id.button_9);
        button.setEnabled(false);
        button = findViewById(R.id.button_0);
        button.setEnabled(false);
        button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        button = findViewById(R.id.button_post);
        button.setEnabled(false);
        button = findViewById(R.id.button_toggle_a_b);
        button.setEnabled(false);
        button = findViewById(R.id.button_S);
        button.setEnabled(false);
        button = findViewById(R.id.button_D);
        button.setEnabled(false);
        button = findViewById(R.id.button_T);
        button.setEnabled(false);
        button = findViewById(R.id.button_reset);
        button.setEnabled(false);
        button = findViewById(R.id.button_game_reset);
        button.setEnabled(false);
    }

    private void enableAllButtons() {
        Button button = findViewById(R.id.button_1);
        button.setEnabled(true);
        button = findViewById(R.id.button_2);
        button.setEnabled(true);
        button = findViewById(R.id.button_3);
        button.setEnabled(true);
        button = findViewById(R.id.button_4);
        button.setEnabled(true);
        button = findViewById(R.id.button_5);
        button.setEnabled(true);
        button = findViewById(R.id.button_6);
        button.setEnabled(true);
        button = findViewById(R.id.button_7);
        button.setEnabled(true);
        button = findViewById(R.id.button_8);
        button.setEnabled(true);
        button = findViewById(R.id.button_9);
        button.setEnabled(true);
        button = findViewById(R.id.button_0);
        button.setEnabled(true);
        button = findViewById(R.id.button_bull);
        button.setEnabled(true);
        button = findViewById(R.id.button_post);
        button.setEnabled(true);
        button = findViewById(R.id.button_toggle_a_b);
        button.setEnabled(true);
        button = findViewById(R.id.button_S);
        button.setEnabled(true);
        button = findViewById(R.id.button_D);
        button.setEnabled(true);
        button = findViewById(R.id.button_T);
        button.setEnabled(true);
        button = findViewById(R.id.button_reset);
        button.setEnabled(true);
        button = findViewById(R.id.button_game_reset);
        button.setEnabled(true);
    }

    private void enableNumericKeys() {
        Button button = findViewById(R.id.button_1);
        button.setEnabled(true);
        button = findViewById(R.id.button_2);
        button.setEnabled(true);
        button = findViewById(R.id.button_3);
        button.setEnabled(true);
        button = findViewById(R.id.button_4);
        button.setEnabled(true);
        button = findViewById(R.id.button_5);
        button.setEnabled(true);
        button = findViewById(R.id.button_6);
        button.setEnabled(true);
        button = findViewById(R.id.button_7);
        button.setEnabled(true);
        button = findViewById(R.id.button_8);
        button.setEnabled(true);
        button = findViewById(R.id.button_9);
        button.setEnabled(true);
        button = findViewById(R.id.button_0);
        button.setEnabled(true);
    }


    // User has pressed a numeric key
    public void press1(View view) {
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("1");
    }

    public void press2(View view) {
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("2");
    }

    public void press3(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("3");
    }

    public void press4(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("4");
    }

    public void press5(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("5");
    }

    public void press6(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("6");
    }

    public void press7(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("7");
    }

    public void press8(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("8");
    }

    public void press9(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("9");
    }

    public void press0(View view) {
        disableNumericKeys();
        Button button = findViewById(R.id.button_bull);
        button.setEnabled(false);
        postDartStatusPoints("0");
    }

    // User has pressed the Bull key
    public void pressBull(View view) {
        disableNumericKeys();
        current_keypad_string = "";
        postDartStatusPoints("B");
    }

    private void postDartStatusPoints(String key_string) {
        // Disable the A/B key
        Button button = findViewById(R.id.button_toggle_a_b);
        button.setEnabled(false);

        // Add the button press to the current keypad string
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
        // Enable the Post key
        button = findViewById(R.id.button_post);
        button.setEnabled(true);
        // Display the darts status line
        displayDartsStatusLine();
    }

    // User has pressed the S, D, or T  multiplier keys
    public void pressS(View view) {
        // Enable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(true);
        pressMultiplier("S");
    }

    public void pressD(View view) {
        // Enable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(true);
        pressMultiplier("D");
    }

    public void pressT(View view) {
        // Enable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        pressMultiplier("T");
    }

    private void pressMultiplier(String multiplier_string) {
        // Disable the A/B key
        Button button = findViewById(R.id.button_toggle_a_b);
        button.setEnabled(false);
        // Disable the Post key
        button = findViewById(R.id.button_post);
        button.setEnabled(false);
        enableNumericKeys();
        if (!current_keypad_string.isEmpty()) {
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
                // Disable the multiplier keys
                button = findViewById(R.id.button_S);
                button.setEnabled(false);
                button = findViewById(R.id.button_D);
                button.setEnabled(false);
                button = findViewById(R.id.button_T);
                button.setEnabled(false);

                break;
            default:
                dart1_multiplier_string = "X";
                break;
        }
        current_keypad_string = "";
        displayDartsStatusLine();
    }

    public void pressPost(View view) {
        // teamA_score_TextView is Team A's score view
        TextView teamA_score_TextView = findViewById(R.id.scoreA);
        // teamB_score_TextView is Team B's score view
        TextView teamB_score_TextView = findViewById(R.id.scoreB);

        // Declare and initialize local variables
        int int_dart1_multiplier = 1;
        int int_dart1_score;
        int int_dart2_multiplier = 1;
        int int_dart2_score;
        int int_dart3_multiplier = 1;
        int int_dart3_score;
        int int_temp_score;
        int int_total_score;
        // bust_TextView is used to indicate that the darts total exceeds the player's score
        TextView bust_TextView = findViewById(R.id.bust);
        // game_TextView is used to indicate that a player has won the game
        TextView game_TextView = findViewById(R.id.game_won);


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
        if (dart1_points_string.equals("B")) {
            int_dart1_score = 25;
        } else {
            int_dart1_score = Integer.parseInt(dart1_points_string);
        }

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
        if (dart2_points_string.equals("B")) {
            int_dart2_score = 25;
        } else {
            int_dart2_score = Integer.parseInt(dart2_points_string);
        }

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
        if (dart3_points_string.equals("B")) {
            int_dart3_score = 25;
        } else {
            int_dart3_score = Integer.parseInt(dart3_points_string);
        }

        // Compute total score for all three darts
        int_total_score = (int_dart1_score * int_dart1_multiplier) + (int_dart2_score * int_dart2_multiplier) + (int_dart3_score * int_dart3_multiplier);


        // Compute the new score for the current team and post the score
        switch (current_team_string) {
            case "Team A":
                int_temp_score = int_teamA_score - int_total_score;
                if (int_temp_score == 0) { // Team A has won the game
                    game_TextView.setVisibility(View.VISIBLE);
                }
                if (int_temp_score < 0) { // Team A has busted
                    bust_TextView.setVisibility(View.VISIBLE);
                    current_team_string = "Team B";
                    teamB_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
                    teamA_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

                } else { // Team A has a valid score
                    int_teamA_score = int_teamA_score - int_total_score;
                    teamA_score_TextView = findViewById(R.id.scoreA);
                    teamA_score_TextView.setText(String.format(Locale.ENGLISH, "%d", int_teamA_score));
                }
                break;
            case "Team B":
                int_temp_score = int_teamB_score - int_total_score;
                if (int_temp_score == 0) { // Team B has won the game
                    game_TextView.setVisibility(View.VISIBLE);
                }
                if (int_temp_score < 0) { // Team B has busted
                    bust_TextView.setVisibility(View.VISIBLE);
                    current_team_string = "Team A";
                    teamA_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
                    teamB_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

                } else { // Team B has a valid score
                    int_teamB_score = int_teamB_score - int_total_score;
                    teamB_score_TextView = findViewById(R.id.scoreB);
                    teamB_score_TextView.setText(String.format(Locale.ENGLISH, "%1d", int_teamB_score));
                }
                break;
            default:
                errorSignal();
                break;
        }
        if (bust_TextView.getVisibility() == View.GONE && game_TextView.getVisibility() == View.GONE) { // Player has not busted and Team has not won
            // Initialize the variables for the next turn
            initializeVariablesForNextTurn();
            // Display the new information on the darts status line
            displayDartsStatusLine();
            // Switch to the other team
            if (TextUtils.equals(current_team_string, "Team A")) {
                current_team_string = "Team B";
                teamB_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
                teamA_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

            } else if (TextUtils.equals(current_team_string, "Team B")) {
                current_team_string = "Team A";
                teamA_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
                teamB_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

            } else {
                errorSignal();
            }
        } else { // Player has busted
            if (bust_TextView.getVisibility() != View.GONE) {
                disableAllButtons();
                TextView reset_TextView = findViewById(R.id.button_reset);
                reset_TextView.setEnabled(true);
            } else { // Team has won
                disableAllButtons();
                TextView game_reset_TextView = findViewById(R.id.button_game_reset);
                game_reset_TextView.setEnabled(true);
            }
        }

    }

    public void pressAB(View view) {
        // teamA_score_TextView is Team A's score view
        TextView teamA_score_TextView = findViewById(R.id.scoreA);
        // teamB_score_TextView is Team B's score view
        TextView teamB_score_TextView = findViewById(R.id.scoreB);

        // Initialize variables for current turn
        initializeVariablesForNextTurn();
        // Display initialized darts status
        displayDartsStatusLine();
        // Switch to the other team
        if (TextUtils.equals(current_team_string, "Team A")) {
            current_team_string = "Team B";
            teamB_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
            teamA_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

        } else if (TextUtils.equals(current_team_string, "Team B")) {
            current_team_string = "Team A";
            teamA_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
            teamB_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

        } else {
            errorSignal();
        }

    }

    public void pressReset(View view) {
        // Initialize variables for current turn
        initializeVariablesForNextTurn();
        // Display initialized darts status
        displayDartsStatusLine();
    }

    public void pressGameReset(View view) {
        // teamA_score_TextView is Team A's score view
        TextView teamA_score_TextView = findViewById(R.id.scoreA);
        // teamB_score_TextView is Team B's score view
        TextView teamB_score_TextView = findViewById(R.id.scoreB);

        // Initialize variables for current turn
        initializeVariablesForNextTurn();
        // Display initialized darts status
        displayDartsStatusLine();
        // Initialize both teams' scores
        int_teamA_score = 301;
        int_teamB_score = 301;
        // Post the new score for team A
        teamA_score_TextView = findViewById(R.id.scoreA);
        teamA_score_TextView.setText(String.format(Locale.ENGLISH, "%d", int_teamA_score));
        // Post the new score for team B
        teamB_score_TextView = findViewById(R.id.scoreB);
        teamB_score_TextView.setText(String.format(Locale.ENGLISH, "%d", int_teamB_score));
        // Let Team A take the first turn
        current_team_string = "Team A";
        teamA_score_TextView.setBackgroundColor(Color.parseColor("#ccff90"));
        teamB_score_TextView.setBackgroundColor(Color.parseColor("#00ccff90"));

    }


    // Display entire darts status line
    private void displayDartsStatusLine() {
        // Display dart 1 multiplier and points
        TextView dart_1_multiplier_TextView = findViewById(R.id.text_dart_1_multiplier);
        dart_1_multiplier_TextView.setText(dart1_multiplier_string);
        TextView dart1_points_TextView = findViewById(R.id.text_dart_1_points);
        dart1_points_TextView.setText(dart1_points_string);
        // Display dart 2 multiplier and points
        TextView dart_2_multiplier_TextView = findViewById(R.id.text_dart_2_multiplier);
        dart_2_multiplier_TextView.setText(dart2_multiplier_string);
        TextView dart2_points_TextView = findViewById(R.id.text_dart_2_points);
        dart2_points_TextView.setText(dart2_points_string);
        // Display dart 3 multiplier and points
        TextView dart_3_multiplier_TextView = findViewById(R.id.text_dart_3_multiplier);
        dart_3_multiplier_TextView.setText(dart3_multiplier_string);
        TextView dart3_points_TextView = findViewById(R.id.text_dart_3_points);
        dart3_points_TextView.setText(dart3_points_string);
    }

    private void errorSignal() {
        // Signals an error by changing "Team A" and "Team B" to "Error"
        // Error is most likely an unexpected default in a case statement
        String error_string = "Error";
        TextView error_A_TextView = findViewById(R.id.teamA);
        error_A_TextView.setText(error_string);
        TextView error_B_TextView = findViewById(R.id.teamB);
        error_B_TextView.setText(error_string);

    }


}
