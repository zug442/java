package com.company;

public class Troble extends Throwable {
    private String messege;

    public String getMessege() {
        return messege;
    }

    public Troble(String messege) {
        this.messege = messege;
    }

    public Troble(String message, String messege) {
        super(message);
        this.messege = messege;
    }
}
