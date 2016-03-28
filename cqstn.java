package com.example.anand.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class cqstn extends Activity implements View.OnClickListener {

    private cparse currentQ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cqstn);
        /**
         * Configure current game and get question
         */
        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
        ParseQuery<cparse> query = ParseQuery.getQuery("cquiz");
        query.findInBackground(new FindCallback<cparse>() {
            @Override
            public void done(List<cparse> questions, ParseException e) {
                if (e == null) {
                    applica.currentGame = new cgameplay();
                    applica.currentGame.setQuestions(questions);
                    currentQ = applica.currentGame.getNextQuestion();
                    setQuestions();
                } else {

                    Toast.makeText(getApplicationContext(), "Error updating questions - please make sure you have internet connection", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    /**
     * Method to set the text for the question and answers from the current games
     * current question
     */
    private void setQuestions() {
        //set the question text from current question
        String question = currentQ.getQuestion() + "?";
        TextView qText = (TextView) findViewById(R.id.question);
        qText.setText(question);

        //set the available options
        TextView option1 = (TextView) findViewById(R.id.answer1);
        option1.setText( currentQ.getOptionOne() );

        TextView option2 = (TextView) findViewById(R.id.answer2);
        option2.setText( currentQ.getOptionTwo() );

        TextView option3 = (TextView) findViewById(R.id.answer3);
        option3.setText( currentQ.getOptionThree() );

        TextView option4 = (TextView) findViewById(R.id.answer4);
        option4.setText( currentQ.getOptionFour() );
    }


    @Override public void onClick(View v) {
        //validate a checkbox has been selected
        if (!checkAnswer()) return;

        // check if end of game
        if (applica.currentGame.isGameOver()){
            Intent i = new Intent(this, cendgame.class);
            startActivity(i);
            finish();
        } else {
            currentQ = applica.currentGame.getNextQuestion();
            setQuestions();
        }
    }


    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK : return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * Check if a checkbox has been selected, and if it
     * has then check if its correct and update gamescore
     */
    private boolean checkAnswer() {
        RadioGroup options = (RadioGroup)findViewById(R.id.group1);
        Integer selected = options.getCheckedRadioButtonId();
        if ( selected < 0){
            return false;
        } else {
            int useranswer = 1;
            switch (selected)
            {
                case R.id.answer1:
                    useranswer = 1;
                    break;
                case R.id.answer2:
                    useranswer = 2;
                    break;
                case R.id.answer3:
                    useranswer = 3;
                    break;
                case R.id.answer4:
                    useranswer = 4;
                    break;

            }
            if (currentQ.getCorrectAnswer() == useranswer) {
                applica.currentGame.incrementRightAnswers();
            } else {
                applica.currentGame.incrementWrongAnswers();
            }
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cqstn, menu);
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
}
