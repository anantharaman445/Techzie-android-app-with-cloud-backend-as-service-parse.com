package com.example.anand.newapp;

import java.util.ArrayList;
import java.util.List;

public class cgameplay {

    private int numRounds;
    private int right=0;
    private int wrong=0;
    private int round=0;

    private List<cparse> questions = new ArrayList<cparse>();
    public int getRight() {
        return right;
    }
   /* public void setRight(int right) {
    this.right = right;
   }*/
    public int getWrong() {
        return wrong;
    }
    public void setWrong(int wrong) {
        this.wrong = wrong;
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public void setQuestions(List<cparse> questions) {
        this.questions = questions;
        this.setNumRounds(questions.size());
        this.setRound(0);
        //this.setRight(right);
        this.setWrong(0);
    }
    public List<cparse> getQuestions() {
        return questions;
    }

    public cparse getNextQuestion(){
        //get the question
        cparse next = questions.get(this.getRound());
        //update the round number to the next round
        this.setRound(this.getRound()+1);
        return next;
    }

    public void incrementRightAnswers(){
        right ++;
    }
    public void incrementWrongAnswers(){
        wrong ++;
    }
    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }
    public int getNumRounds() {
        return numRounds;
    }
    public boolean isGameOver(){
        return (getRound() >= getNumRounds());
    }
}
