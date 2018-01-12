package com.example.android.counter2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    static final String ALCOHOL_SCORE = "scoreAlcohol";
    static final String SOFT_DRINK_SCORE = "scoreSoftDrink";

    /**
     * Tracks score for Team A.
     */
    int scoreAlcohol = 0;
    /**
     * Tracks score for Team B.
     */
    int scoreSoftDrink = 0;


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(ALCOHOL_SCORE, scoreAlcohol);
        savedInstanceState.putInt(SOFT_DRINK_SCORE, scoreSoftDrink);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        scoreAlcohol = savedInstanceState.getInt(ALCOHOL_SCORE);
        scoreSoftDrink = savedInstanceState.getInt(SOFT_DRINK_SCORE);
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForAlcohol(0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForAlcohol(View v) {
        scoreAlcohol = scoreAlcohol + 1;
        scoreSoftDrink = scoreSoftDrink + 1;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForAlcohol(View v) {
        scoreAlcohol = scoreAlcohol + 3;
        scoreSoftDrink = scoreSoftDrink + 3;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Decrease the score for Team A by 1 point.
     */

    public void subtractOneForAlcohol(View v) {
        if (scoreAlcohol > 0) {
            scoreAlcohol = scoreAlcohol - 1;
            scoreSoftDrink = scoreSoftDrink - 1;
            displayForAlcohol(scoreAlcohol);
            displayForSoftDrink(scoreSoftDrink);
        }else {
            scoreAlcohol = 0;
            scoreSoftDrink = scoreSoftDrink;
            displayForAlcohol(scoreAlcohol);
            displayForSoftDrink(scoreSoftDrink);
        }
    }

    /**
     * Decrease the score for Team A by 3 points.
     */

    public void subtractThreeForAlcohol(View v) {
        if (scoreAlcohol > 0) {
            scoreAlcohol = scoreAlcohol - 3;
            scoreSoftDrink = scoreSoftDrink - 3;
            displayForAlcohol(scoreAlcohol);
            displayForSoftDrink(scoreSoftDrink);
        }else {
            scoreAlcohol = 0;
            scoreSoftDrink = scoreSoftDrink;
            displayForAlcohol(scoreAlcohol);
            displayForSoftDrink(scoreSoftDrink);
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForAlcohol(int alcScore) {
        TextView scoreView = (TextView) findViewById(R.id.alcohol_score);
        scoreView.setText(String.valueOf(alcScore));
        if (alcScore > 6 && alcScore < 11 && alcScore % 2 == 0) {
            Toast.makeText(getApplicationContext(), "Ouch! Too much alcohol!", Toast.LENGTH_SHORT).show();
        }
        else if (alcScore > 11 && alcScore % 2 == 0) {
            Toast.makeText(getApplicationContext(), "You can't drive today!", Toast.LENGTH_SHORT).show();
        }
    }



    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink + 1;
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink + 2;
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Decrease the score for Team B by 1 point.
     */

    public void subtractOneForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink - 1;
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Decrease the score for Team B by 2 points.
     */

    public void subtractTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink - 2;
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForSoftDrink(int waterScore) {
        TextView scoreView = (TextView) findViewById(R.id.soft_drink_score);
        scoreView.setText(String.valueOf(waterScore));
        if (waterScore > 6 && waterScore < 11 && waterScore % 2 == 1) {
            Toast.makeText(getApplicationContext(), "Drink more water!", Toast.LENGTH_SHORT).show();
        }
        else if (waterScore > 11 && waterScore % 2 == 1) {
            Toast.makeText(getApplicationContext(), "You're dehydrated", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Resets the score for both teams to 0.
     */
    public void resetScore(View v) {
        scoreAlcohol = 0;
        scoreSoftDrink = 0;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }
}