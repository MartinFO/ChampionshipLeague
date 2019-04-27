package com.example.android.championshipleague;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String current_team_string = "Team A"; // Can be "Team A" or "Team B"
    private int int_current_dart = 0; // Can be 0, 1, 2, or 3
    private int int_dart1_multiplier = 1;
    private int int_dart2_multiplier = 1;
    private int int_dart3_multiplier = 1;
    private int int_dart1_points = 0;
    private int int_dart2_points = 0;
    private int int_dart3_points = 0;
    private int int_teamA_score = 301;
    private int int_teamB_score = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(false);
        // Disable the Zero key
        Button button_zero = findViewById(R.id.button_0);
        button_zero.setEnabled(false);
        // Set the highlight for dart 1
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        text_highlight_1.setVisibility(View.VISIBLE);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        text_highlight_2.setVisibility(View.INVISIBLE);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        text_highlight_3.setVisibility(View.INVISIBLE);
    }

    private void initializeVariablesForNextTurn() {
        int_current_dart = 0;
        int_dart1_multiplier = 1;
        int_dart2_multiplier = 1;
        int_dart3_multiplier = 1;
        int_dart1_points = 0;
        int_dart2_points = 0;
        int_dart3_points = 0;
        // Enable all buttons except the zero and post buttons
        enableAllButtons();
        // Disable the zero and post buttons
        Button button_zero = findViewById(R.id.button_0);
        Button button_post = findViewById(R.id.button_post);
        button_zero.setEnabled(false);
        button_post.setEnabled(false);
        // Set the highlight for dart 1
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        text_highlight_1.setVisibility(View.VISIBLE);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        text_highlight_2.setVisibility(View.INVISIBLE);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        text_highlight_3.setVisibility(View.INVISIBLE);
        // Hide the "BUST" message for exceeding the remaining points
        TextView bust_TextView = findViewById(R.id.bust);
        bust_TextView.setVisibility(View.GONE);
        TextView game_TextView = findViewById(R.id.game_won);
        game_TextView.setVisibility(View.GONE);
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
        // Note: "0" is treated specially -- not enabled.
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
        button = findViewById(R.id.button_0); // "0" is a special case
        button.setEnabled(false); // "0" key is disabled
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
        button = findViewById(R.id.button_0); // "0" is a special case
        button.setEnabled(false); // "0" key is disabled
    }


    // User has pressed a numeric key
    public void press1(View view) {
        // Declare a boolean variable for the current dart having a single digit of points
        boolean bool_points_less_than_ten = true;
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 1;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 1;
                if (int_dart1_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 1;
                if (int_dart2_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 1;
                if (int_dart3_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            default:
                errorSignal();
                break;
        }
        if (bool_points_less_than_ten) { // If the dart has the value of 1
            // Enable the Zero key
            Button button_zero = findViewById(R.id.button_0);
            button_zero.setEnabled(true);
            // Disable the Bull key
            Button button_bull = findViewById(R.id.button_bull);
            button_bull.setEnabled(false);
        } else { // If the dart has the value of 11
            disableNumericKeys();
        }
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);

    }

    public void press2(View view) {
        // Declare a boolean variable for the current dart having a single digit of points
        boolean bool_points_less_than_ten = true;
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 2;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 2;
                if (int_dart1_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 2;
                if (int_dart2_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 2;
                if (int_dart3_points >= 10) {
                    bool_points_less_than_ten = false;
                }
                break;
            default:
                errorSignal();
                break;
        }
        if (bool_points_less_than_ten) { // If the dart has the value of 2
            // Disable the numeric keys except zero
            disableNumericKeys();
            // Enable the Zero key
            Button button_zero = findViewById(R.id.button_0);
            button_zero.setEnabled(true);
            // Disable the Bull key
            Button button_bull = findViewById(R.id.button_bull);
            button_bull.setEnabled(false);
        } else { // If the dart has the value of 12
            disableNumericKeys();
        }
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
        }

    public void press3(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 3;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 3;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 3;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 3;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press4(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 4;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 4;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 4;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 4;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press5(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 5;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 5;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 5;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 5;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press6(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 6;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 6;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 6;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 6;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press7(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 7;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 7;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 7;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 7;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press8(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 8;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 8;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 8;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 8;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press9(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 9;
                break;
            case 1:
                int_dart1_points = 10 * int_dart1_points + 9;
                break;
            case 2:
                int_dart2_points = 10 * int_dart2_points + 9;
                break;
            case 3:
                int_dart3_points = 10 * int_dart3_points + 9;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    public void press0(View view) {
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    // User has pressed the Bull key
    public void pressBull(View view) {
        // Increase the value of the points for the current dart
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_points = 25;
                break;
            case 1:
                int_dart1_points = 25;
                break;
            case 2:
                int_dart2_points = 25;
                break;
            case 3:
                int_dart3_points = 25;
                break;
            default:
                errorSignal();
                break;
        }
        disableNumericKeys();
        // Disable the Bull key
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        // Display the new set of multipliers and points
        displayDartsStatusLine();
        // Enable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(true);
    }

    // User has pressed the S, D, or T  multiplier keys
    public void pressS(View view) {
        // Create local variables for setting the darts line highlighting
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_multiplier = 1;
                break;
            case 1:
                int_current_dart = 2;
                int_dart2_multiplier = 1;
                text_highlight_1.setVisibility(View.INVISIBLE);
                text_highlight_2.setVisibility(View.VISIBLE);
                break;
            case 2:
                int_current_dart = 3;
                int_dart3_multiplier = 1;
                text_highlight_2.setVisibility(View.INVISIBLE);
                text_highlight_3.setVisibility(View.VISIBLE);
                break;
            default:
                errorSignal();
                break;
        }
        // Enable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(true);
        pressMultiplier();
    }

    public void pressD(View view) {
        // Create local variables for setting the darts line highlighting
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_multiplier = 2;
                break;
            case 1:
                int_current_dart = 2;
                int_dart2_multiplier = 2;
                text_highlight_1.setVisibility(View.INVISIBLE);
                text_highlight_2.setVisibility(View.VISIBLE);
                break;
            case 2:
                int_current_dart = 3;
                int_dart3_multiplier = 2;
                text_highlight_2.setVisibility(View.INVISIBLE);
                text_highlight_3.setVisibility(View.VISIBLE);
                break;
            default:
                errorSignal();
                break;
        }
        // Enable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(true);
        pressMultiplier();
    }

    public void pressT(View view) {
        // Create local variables for setting the darts line highlighting
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        switch (int_current_dart) {
            case 0:
                int_current_dart = 1;
                int_dart1_multiplier = 3;
                break;
            case 1:
                int_current_dart = 2;
                int_dart2_multiplier = 3;
                text_highlight_1.setVisibility(View.INVISIBLE);
                text_highlight_2.setVisibility(View.VISIBLE);
                break;
            case 2:
                int_current_dart = 3;
                int_dart3_multiplier = 3;
                text_highlight_2.setVisibility(View.INVISIBLE);
                text_highlight_3.setVisibility(View.VISIBLE);
                break;
            default:
                errorSignal();
                break;
        }
        // Disable the Bull button
        Button button_bull = findViewById(R.id.button_bull);
        button_bull.setEnabled(false);
        pressMultiplier();
    }

    private void pressMultiplier() {
        // Disable the A/B key
        Button buttonAB = findViewById(R.id.button_toggle_a_b);
        buttonAB.setEnabled(false);
        // Disable the Post key
        Button button_post = findViewById(R.id.button_post);
        button_post.setEnabled(false);
        // Create local variables for setting the darts line highlighting
        TextView text_highlight_1 = findViewById(R.id.highlight_1);
        TextView text_highlight_2 = findViewById(R.id.highlight_2);
        TextView text_highlight_3 = findViewById(R.id.highlight_3);
        // Enable the numeric keys
        enableNumericKeys();
        // If the current dart's points are not zero,
        // then the multiplier (S,D,T) is a signal to move on to the next dart.
        switch (int_current_dart) {
            case 0:
                errorSignal();
                break;
            case 1:
                if (int_dart1_points == 0) {
                    text_highlight_1.setVisibility(View.VISIBLE);
                } else {
                    int_current_dart = 2;
                    text_highlight_1.setVisibility(View.INVISIBLE);
                    text_highlight_2.setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                if (int_dart2_points == 0) {
                    text_highlight_2.setVisibility(View.VISIBLE);
                } else {
                    int_current_dart = 3;
                    text_highlight_2.setVisibility(View.INVISIBLE);
                    text_highlight_3.setVisibility(View.VISIBLE);
                }
                break;
            case 3:
                if (int_dart3_points == 0) {
                    // Disable the multiplier keys
                    Button button_S = findViewById(R.id.button_S);
                    button_S.setEnabled(false);
                    Button button_D = findViewById(R.id.button_D);
                    button_D.setEnabled(false);
                    Button button_T = findViewById(R.id.button_T);
                    button_T.setEnabled(false);
                    text_highlight_3.setVisibility(View.VISIBLE);
                } else {
                    errorSignal();
                }
                break;
            default:
                errorSignal();
                break;
        }
        displayDartsStatusLine();
    }

    public void pressPost(View view) {
        // Declare and initialize local variables
        int int_total_score;
        int int_temp_score;

        // teamA_score_TextView is Team A's score view
        TextView teamA_score_TextView = findViewById(R.id.scoreA);
        // teamB_score_TextView is Team B's score view
        TextView teamB_score_TextView = findViewById(R.id.scoreB);

        // bust_TextView is used to indicate that the darts total exceeds the player's score
        TextView bust_TextView = findViewById(R.id.bust);
        // game_TextView is used to indicate that a player has won the game
        TextView game_TextView = findViewById(R.id.game_won);


        // Compute total score for all three darts
        int_total_score = (int_dart1_points * int_dart1_multiplier) + (int_dart2_points * int_dart2_multiplier) + (int_dart3_points * int_dart3_multiplier);


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
        TextView teamA_score_TextView;
        // teamB_score_TextView is Team B's score view
        TextView teamB_score_TextView;

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

    // private void advanceToNextDart () {
        // int_current_dart = int_current_dart + 1;
        // switch (int_current_dart) {
            // case
        // }
    // }

    // Display entire darts status line
    private void displayDartsStatusLine() {
        String str_dart1_status;
        String str_dart2_status;
        String str_dart3_status;
        String str_dart1_multiplier = " ";
        String str_dart2_multiplier = " ";
        String str_dart3_multiplier = " ";
        String str_dart1_points = "  ";
        String str_dart2_points = "  ";
        String str_dart3_points = "  ";
        // Display dart 1 multiplier and points
        switch (int_dart1_multiplier) {
            case 1:
                str_dart1_multiplier = " ";
                break;
            case 2:
                str_dart1_multiplier = "D";
                break;
            case 3:
                str_dart1_multiplier = "T";
                break;
            default:
                errorSignal();
                break;
        }
        if (int_dart1_points == 0) {
            str_dart1_points = "  ";
        } else if (int_dart1_points == 25) {
            str_dart1_points = " B";
        } else {
            str_dart1_points = String.format("%1$2s", int_dart1_points);
        }
        str_dart1_status = " 1: " + str_dart1_multiplier + " " + str_dart1_points;
        TextView text_dart_1 = findViewById(R.id.text_dart_1);
        text_dart_1.setText(str_dart1_status);
        // Display dart 2 multiplier and points
        switch (int_dart2_multiplier) {
            case 1:
                str_dart2_multiplier = " ";
                break;
            case 2:
                str_dart2_multiplier = "D";
                break;
            case 3:
                str_dart2_multiplier = "T";
                break;
            default:
                errorSignal();
                break;
        }
        if (int_dart2_points == 0) {
            str_dart2_points = "  ";
        } else if (int_dart2_points == 25) {
            str_dart2_points = " B";
        } else {
            str_dart2_points = Integer.toString(int_dart2_points);
        }
        str_dart2_status = " 2: " + str_dart2_multiplier + " " + str_dart2_points;
        TextView text_dart_2 = findViewById(R.id.text_dart_2);
        text_dart_2.setText(str_dart2_status);
        // Display dart 3 multiplier and points
        switch (int_dart3_multiplier) {
            case 1:
                str_dart3_multiplier = " ";
                break;
            case 2:
                str_dart3_multiplier = "D";
                break;
            case 3:
                str_dart3_multiplier = "T";
                break;
            default:
                errorSignal();
                break;
        }
        if (int_dart3_points == 0) {
            str_dart3_points = " ";
        } else if (int_dart3_points == 25) {
            str_dart3_points = " B";
        } else {
            str_dart3_points = Integer.toString(int_dart3_points);
        }
        str_dart3_status = " 3: " + str_dart3_multiplier + " " + str_dart3_points;
        TextView text_dart_3 = findViewById(R.id.text_dart_3);
        text_dart_3.setText(str_dart3_status);
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
