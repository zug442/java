package com.company;

public class Soldier extends Human implements IFighting{
    private String rank;
    private String division;
    private String name;

    @Override
    public String getName() {
        return name;
    }


    public Soldier(String rank, String division, String name, Comandor myComd) {
        this.rank = rank;
        this.division = division;
        this.name = name;
        this.myComd = myComd;
    }

    private Comandor myComd;
    public boolean war() {
            return true; //always ready
    }
    public String report() {
        return "I am soldier" + getName() + ". My comandor " + myComd.getName();
    }

}
