package com.company;

public class Comandor extends Human implements IFighting {
    private int numberOfGun;
    private Soldier[] sol;
    private General myGen;
    private String name;


    @Override
    public String getName() {
        return name;
    }

    public Comandor(int numberOfGun, Soldier[] sol, General myGen, String name) {
        this.numberOfGun = numberOfGun;
        this.sol = sol;
        this.myGen = myGen;
        this.name = name;
    }
    @Override

    public boolean war() throws Troble {
        if(sol.length > 3)
            return true;
        else
            if(sol.length < 4) {
            try {
                throw new Troble("Need more soldiers");
            }catch (Troble tr)
            {
                System.out.println(tr.getMessege());
            }
        }
            return false;
    }
    public String report() {
        return "I am comandor " + getName() + ". I have " + sol.length + " soldiers. I have gun number: " + numberOfGun +"  My general is " + myGen.getName();
    }
}
