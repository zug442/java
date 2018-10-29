package com.company;

public class General extends Human implements IFighting{
    private String passNumber;
    private Comandor [] com;
    private String name;

    public General(String passNumber, Comandor[] com, String name) {
        this.passNumber = passNumber;
        this.com = com;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPassNumber() {
        return passNumber;
    }



    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public boolean war() throws  Troble{
        if(com.length > 0)
            return true;
        else
            if(com.length == 0) {
                try {
                    throw new Troble("Need more commandors");
                }catch (Troble tr)
                {
                    System.out.println(tr.getMessege());
                }
            }
        return false;
    }
    public String report() {
        int leng = 0;
        try{
            leng = com.length;
        }catch (NullPointerException ex){
            System.out.println("No commandors");
        }
        return "I am general" + getName() + ". I have " + leng + " comandors";
    }
}
