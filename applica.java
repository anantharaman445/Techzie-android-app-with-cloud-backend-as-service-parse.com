package com.example.anand.newapp;

import android.app.Application;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by anand on 07-03-2016.
 */
public class applica extends Application {

    public static cngameplay cnCurrentGame;
    public static cgameplay currentGame;
    public static jgameplay jcurrentGame;
    public static wtgameplay wtCurrentGame;
    public static dbgameplay dbCurrentGame;
    public static osgameplay oscurrentGame;
   public static ssgameplay ssCurrentGame;
    void setCurrentGame(cgameplay currentGame)
    {
        this.currentGame = currentGame;

    }

    public cgameplay getCurrentGame() {
        this.currentGame=currentGame;

        return currentGame;
    }
    void setjcurrentGame(jgameplay jcurrentGame)
    {
        this.jcurrentGame = jcurrentGame;

    }

    public jgameplay getjcurrentGame() {
        this.jcurrentGame=jcurrentGame;

        return jcurrentGame;
    }
    void setwtCurrentGame(wtgameplay wtCurrentGame)
    {
        this.wtCurrentGame = wtCurrentGame;

    }

    public wtgameplay getwtCurrentGame() {
        this.wtCurrentGame=wtCurrentGame;

        return wtCurrentGame;
    }
    void setdbCurrentGame(dbgameplay dbCurrentGame)
    {
        this.dbCurrentGame = dbCurrentGame;

    }

    public dbgameplay getdbCurrentGame() {
        this.dbCurrentGame=dbCurrentGame;

        return dbCurrentGame;
    }
    void setoscurrentGame(osgameplay oscurrentGame)
    {
        this.oscurrentGame = oscurrentGame;

    }

    public osgameplay getoscurrentGame() {
        this.oscurrentGame=oscurrentGame;

        return oscurrentGame;
    }

    void setssCurrentGame(ssgameplay ssCurrentGame)
    {
        this.ssCurrentGame = ssCurrentGame;

    }

    public ssgameplay getssCurrentGame() {
        this.ssCurrentGame=ssCurrentGame;

        return ssCurrentGame;
    }
    void setcnCurrentGame(cngameplay cnCurrentGame)
    {
        this.cnCurrentGame = cnCurrentGame;

    }

    public cngameplay getcnCurrentGame() {
        this.cnCurrentGame=cnCurrentGame;

        return cnCurrentGame;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(cparse.class);
        ParseObject.registerSubclass(jparse.class);
        ParseObject.registerSubclass(wtparse.class);
        ParseObject.registerSubclass(dbparse.class);
        ParseObject.registerSubclass(ssparse.class);
        ParseObject.registerSubclass(cnparse.class);
        ParseObject.registerSubclass(osparse.class);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "96cZHVTdZBNtOOiLUuPgqyaZW1uja58lf6xRnAAA", "bNq5aBxriEcLgN9L6vR1Y28pGTBLXrTW4CkmMO0r");
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        ParseQuery<cparse> query = ParseQuery.getQuery("cquiz");
        final Application app = this;
        query.findInBackground(new FindCallback<cparse>() {
            @Override
            public void done(List<cparse> questions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("cquiz");

                    ParseObject.pinAllInBackground("cquiz", questions);

                } else {

                    Toast.makeText(app, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });
        ParseQuery<jparse> jquery = ParseQuery.getQuery("javaquiz");
        final Application japp = this;
        jquery.findInBackground(new FindCallback<jparse>() {
            @Override
            public void done(List<jparse> jquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("javaquiz");

                    ParseObject.pinAllInBackground("javaquiz", jquestions);

                } else {

                    Toast.makeText(app, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });

        ParseQuery<wtparse> wtquery = ParseQuery.getQuery("wtquiz");
        final Application app3 = this;
        wtquery.findInBackground(new FindCallback<wtparse>() {
            @Override
            public void done(List<wtparse> wtquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("wtquiz");

                    ParseObject.pinAllInBackground("wtquiz", wtquestions);

                } else {

                    Toast.makeText(app3, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });
        ParseQuery<dbparse> dbquery = ParseQuery.getQuery("dbquiz");
        final Application app4 = this;
        dbquery.findInBackground(new FindCallback<dbparse>() {
            @Override
            public void done(List<dbparse> dbquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("dbquiz");

                    ParseObject.pinAllInBackground("dbquiz", dbquestions);

                } else {

                    Toast.makeText(app4, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

    }
});
        ParseQuery<osparse> osquery = ParseQuery.getQuery("osquiz");
        final Application oapp = this;
        osquery.findInBackground(new FindCallback<osparse>() {
            @Override
            public void done(List<osparse> osquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("osquiz");

                    ParseObject.pinAllInBackground("osquiz", osquestions);

                } else {

                    Toast.makeText(oapp, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });
        ParseQuery<ssparse> ssquery = ParseQuery.getQuery("ssquiz");
        final Application sapp = this;
        ssquery.findInBackground(new FindCallback<ssparse>() {
            @Override
            public void done(List<ssparse> ssquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("ssquiz");

                    ParseObject.pinAllInBackground("ssquiz", ssquestions);

                } else {

                    Toast.makeText(sapp, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });
        ParseQuery<cnparse> cnquery = ParseQuery.getQuery("cnquiz");
        final Application cnapp = this;
        cnquery.findInBackground(new FindCallback<cnparse>() {
            @Override
            public void done(List<cnparse> cnquestions, ParseException e) {

                if (e == null) {


                    ParseObject.unpinAllInBackground("cnquiz");

                    ParseObject.pinAllInBackground("cnquiz", cnquestions);

                } else {

                    Toast.makeText(cnapp, "Error updating questions - please make sure you have internet connection",


                            Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}
