package com.example.quizzapp;
public class Question {
    private boolean reponse;
    private int question;
    public  Question(boolean reponse,int question){
        this.reponse=reponse;
        this.question=question;
    }
    public boolean  isRerponse(){
        return reponse;
    }
    public int getQuestion(){
        return question;
    }
}
