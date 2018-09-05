package com.example.mohamed.yourhero.SQLite;

public class Questions {

    private int id;
    private String questions;

    public Questions() {
    }

    public Questions(String questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }


}
