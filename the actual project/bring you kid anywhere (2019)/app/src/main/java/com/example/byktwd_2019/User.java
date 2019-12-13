package com.example.byktwd_2019;

public class User {
    private String uid, name, score;

    public User(String uid, String name, String score) {
        this.uid = uid;
        this.name = name;
        this.score = score;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid){this.uid = uid;}

    public String getName() {
        return name;
    }

    public void setName(String name){this.name = name;}

    public String getScore() {
        return score;
    }

    public void setScore(String score){this.score = score;}
}
