package com.example.anand.newapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.ParseException;
import java.util.List;


public class cendgame extends Activity {
    Button fin;
    int s;
    @Override public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cendgame);

        cgameplay currentGame = ((applica)getApplication()).getCurrentGame();

        String result = "You Got " + currentGame.getRight() + "/" + currentGame.getNumRounds() + ".. ";




        TextView results = (TextView)findViewById(R.id.endgameResult);

        results.setText( result );
        fin=(Button)findViewById(R.id.exit);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(cendgame.this,Home.class);
                startActivity(i2);

            }
        });
    }



    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK )return true;

        return super.onKeyDown(keyCode, event);
    }



    public void startNewGame( View v ) throws ParseException, com.parse.ParseException {

        ParseQuery<cparse> query = ParseQuery.getQuery("cquiz");

        query.fromLocalDatastore();

        List<cparse> questions = query.find();

        cgameplay c = new cgameplay();

        c.setQuestions(questions);

        c.setNumRounds( questions.size() );

        ((applica)getApplication()).setCurrentGame(c);


        //Start new game..

        Intent i = new Intent(this, cqstn.class);

        startActivityForResult(i, 1);
    }

    /*public void finish( View v ) {


        finish();

    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cendgame, menu);
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
