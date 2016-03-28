package com.example.anand.newapp;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("cquiz")//Thisis the parse objct
public class cparse extends ParseObject{
    public cparse()
    {
        //default constructor is required
    }
    public void setTitle(String question) {

        put("question", question);
    }
    public String getQuestion() {

        return getString("question");
    }




    public String getOptionOne() {

        return getString("option1");
    }

    public void setOptionOne(String option1) {

        put("option1", option1);
    }

    public String getOptionTwo() {

        return getString("option2");
    }

    public void setOptionTwo(String option2) {

        put("option2", option2);
    }

    public String getOptionThree() {

        return getString("option3");
    }

    public void setOptionThree(String option3) {

        put("option3", option3);
    }

    public String getOptionFour() {

        return getString("option4");
    }

    public void setOptionFour(String option4) {

        put("option4", option4);
    }


    public Integer getCorrectAnswer() {

        return getInt("correct");
    }

    public void setCorrect(Integer correct) {

        put("correct", correct);
    }
    public static ParseQuery<cparse> getQuery(){
        return ParseQuery.getQuery(cparse.class);
    }
    }
