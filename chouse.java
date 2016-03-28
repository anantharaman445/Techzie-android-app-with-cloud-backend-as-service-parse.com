package com.example.anand.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.List;


public class chouse extends Activity {
    Button p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chouse);
        p=(Button)findViewById(R.id.play);
        //s=(Button)findViewById(R.id.score);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(chouse.this, cqstn.class);

                startActivityForResult(i, 1);
            }
        });

    }
    public void startNewGame( View v ) throws ParseException, com.parse.ParseException {

        ParseQuery<cparse> query = ParseQuery.getQuery("cquiz");

        query.fromLocalDatastore();

        final List<cparse> questions = query.find();


        if ( questions.size() > 0 ){

            startGameActivity( questions );

        } else {

            query = ParseQuery.getQuery("cquiz");

            final Activity ctx = this;

        query.findInBackground(new FindCallback<cparse>() {
            @Override
            public void done(List<cparse> questions, com.parse.ParseException e) {
                if ( e == null ){

                    ParseObject.unpinAllInBackground( "cquiz" );

                    ParseObject.pinAllInBackground( "cquiz",  questions );

                    startGameActivity(questions);

                } else {

                    Toast.makeText(ctx,

                            "Error updating questions - please make sure you have internet connection",

                            Toast.LENGTH_LONG).show();
                }

            }
        });
        }
    }



    private void startGameActivity( List<cparse> questions ){

//Initialise Game with retrieved question set

        cgameplay c = new cgameplay();

        c.setQuestions(questions);

        c.setNumRounds( questions.size() );

        ((applica)getApplication()).setCurrentGame(c);


        //Start Game Now.. //


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chouse, menu);
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
