package com.example.android.counter2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.counter2.R;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Declares global constants, setting the two variables storing a total score each as such.

    static final String STATE_ALCOHOL_SCORE = "scoreAlcohol";
    static final String STATE_SOFT_DRINK_SCORE = "scoreSoftDrink";

    /**
     * Initializes a variable that tracks the total score of alcohol already consumed by user.
     * This variable will later on be programmed not to go below 0.
     */

    int scoreAlcohol;

    /**
     * Initializes a variable that tracks the total score of NEEDED soft drink consumption for user.
     * This variable CAN go below zero (user can drink some soft drinks ahead and thus be rewarded with less
     * soft drink needed to be drank points with alcohol consumption.
     */

    int scoreSoftDrink;

    /**
     * Pulls out the value for the two total scores, alcohol consumption and needed soft drink consumption,
     * and saves their values.
     */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Saves user's current scores.
        savedInstanceState.putInt(STATE_ALCOHOL_SCORE, scoreAlcohol);
        savedInstanceState.putInt(STATE_SOFT_DRINK_SCORE, scoreSoftDrink);
        // Calls on the superclass to save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }

    // Continues or starts activity after checking if there was an ongoing saved activity to reload or not.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            setContentView(R.layout.activity_main);
            scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
            scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
        } else
            setContentView(R.layout.activity_main);
            scoreAlcohol = 0;
            scoreSoftDrink = 0;
    }

    // Gets the values of the two total scores for the saved states and displays those instead of the zero default value.

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
        scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
        displayForAlcohol (scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    // Inflates the menu.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Increases the score for alcohol consumed by 1 point.

    public void addOneForAlcohol(View v) {
        scoreAlcohol = scoreAlcohol + 1;
        scoreSoftDrink = scoreSoftDrink + 1;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreAlcohol > 6 && scoreAlcohol < 11 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), "Ouch! Too much alcohol!", Toast.LENGTH_SHORT).show();
        }
        else if (scoreAlcohol > 11 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), "You can't drive today!", Toast.LENGTH_SHORT).show();
        }
    }

    // Increases the score for alcohol consumed by 3 points.

    public void addThreeForAlcohol(View v) {
        scoreAlcohol = scoreAlcohol + 3;
        scoreSoftDrink = scoreSoftDrink + 3;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreAlcohol > 6 && scoreAlcohol < 11 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), "Ouch! Too much alcohol!", Toast.LENGTH_SHORT).show();
        }
        else if (scoreAlcohol > 11 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), "You can't drive today!", Toast.LENGTH_SHORT).show();
        }
    }

    // Decreases the score for alcohol consumed by 1 point.

    public void subtractOneForAlcohol(View v) {
        if (scoreAlcohol > 0) {
            scoreAlcohol = scoreAlcohol - 1;
            scoreSoftDrink = scoreSoftDrink - 1;
        }else {
            scoreAlcohol = 0;
        }
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    // Decreases the score for alcohol consumed by 3 points.

    public void subtractThreeForAlcohol(View v) {
        if (scoreAlcohol >= 3) {
            scoreAlcohol = scoreAlcohol - 3;
            scoreSoftDrink = scoreSoftDrink - 3;
        }
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Displays the total score for the alcohol consumed (in made-up units).
     * Signifies the amount of alcohol user already consumed.
     * User should keep it low.
     */
    public void displayForAlcohol(int alcScore) {
        TextView scoreView = (TextView) findViewById(R.id.alcohol_score);
        scoreView.setText(String.valueOf(alcScore));
    }


    // Increases the score for needed soft drink consumption by 1 point.

    public void addOneForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink + 1;
        displayForSoftDrink(scoreSoftDrink);
    }


    // Increases the score for alcohol consumed by 2 points.

    public void addTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink + 2;
        displayForSoftDrink(scoreSoftDrink);
    }


    // Decreases the score for needed soft drink consumption by 1 point.

    public void subtractOneForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink - 1;
        displayForSoftDrink(scoreSoftDrink);
        if (scoreSoftDrink > 6 && scoreSoftDrink < 11 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), "More water, sailor!", Toast.LENGTH_SHORT).show();
        }
        else if (scoreSoftDrink > 11 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), "You're still dehydrated", Toast.LENGTH_SHORT).show();
        }
    }


    // Decrease the score for needed soft drink consumption by 2 points.


    public void subtractTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink - 2;
        displayForSoftDrink(scoreSoftDrink);
        if (scoreSoftDrink > 6 && scoreSoftDrink < 11 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), "More water, sailor!", Toast.LENGTH_SHORT).show();
        }
        else if (scoreSoftDrink > 11 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), "You're still dehydrated", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Displays the total score for soft drinks (in made-up units).
     * Signifies the amount of soft drinks user still needs to drink.
     * User should keep it low.
     */

    public void displayForSoftDrink(int waterScore) {
        TextView scoreView = (TextView) findViewById(R.id.soft_drink_score);
        scoreView.setText(String.valueOf(waterScore));
    }

    // Resets the score for both the alcohol and soft drink score to 0.

    public void resetScore(View v) {
        scoreAlcohol = 0;
        scoreSoftDrink = 0;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }
}