package com.company;

public class Main {

    public static void main(String[] args) {

        Soldier []seldat = new Soldier[10];
        Comandor [] comd = new Comandor[10];
        General onlyGen = new General("8436798", comd, "Boss");
        comd[0] = new Comandor(43346,seldat,onlyGen, "Petro");
        comd[1] = new Comandor(445746, seldat, onlyGen,"Oleg");
        seldat[0] = new Soldier("first rank", "fly","Dima",comd[0]);
        seldat[1] = new Soldier("second rank", "swim","Force",comd[1]);
        seldat[2] = new Soldier("third rank", "leys","Igor",comd[0]);
        for(int i = 0; i < 2; i++) {
            System.out.println(comd[i].report());
        }
        for(int i = 0; i < 3; i++) {
            System.out.println(seldat[i].report());
        }

    }
}
