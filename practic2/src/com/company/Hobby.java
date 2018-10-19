package com.company;

public class Hobby {
    private byte bytee;
    private char chare;
    private short shorte;
    private boolean bool;
    private int integer;
    private double doublee;
    private long longe;
    private float floate;

    public Hobby() {//constructors
    }

    public Hobby(byte bytee, char chare, short shorte, boolean bool, int integer, double doublee, long longe, float floate) {
        this.bytee = bytee;
        this.chare = chare;
        this.shorte = shorte;
        this.bool = bool;
        this.integer = integer;
        this.doublee = doublee;
        this.longe = longe;
        this.floate = floate;
    }

    public Hobby(byte bytee, char chare, short shorte) {
        this.bytee = bytee;
        this.chare = chare;
        this.shorte = shorte;
    }

    public byte getBytee() {//getters and setters
        return bytee;
    }

    public void setBytee(byte bytee) {
        this.bytee = bytee;
    }

    public char getChare() {
        return chare;
    }

    public void setChare(char chare) {
        this.chare = chare;
    }

    public short getShorte() {
        return shorte;
    }

    public void setShorte(short shorte) {
        this.shorte = shorte;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public double getDoublee() {
        return doublee;
    }

    public void setDoublee(double doublee) {
        this.doublee = doublee;
    }

    public long getLonge() {
        return longe;
    }

    public void setLonge(long longe) {
        this.longe = longe;
    }

    public float getFloate() {
        return floate;
    }

    public void setFloate(float floate) {
        this.floate = floate;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "bytee=" + bytee +
                ", chare=" + chare +
                ", shorte=" + shorte +
                ", bool=" + bool +
                ", integer=" + integer +
                ", doublee=" + doublee +
                ", longe=" + longe +
                ", floate=" + floate +
                '}';
    }
}
