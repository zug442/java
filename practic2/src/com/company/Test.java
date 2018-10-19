package com.company;

import org.apache.log4j.Logger;

public class Test {

    final static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        Test test = new Test();
        Hobby myHobby = new Hobby();
        Hobby myHobby2 = new Hobby((byte) 127, 'g', (short) 45);
        Hobby myHobby3 = new Hobby((byte) 8, 'f', (short) 16, true, 2147483647, 3.2132143225, 92233720368545807L, 3.2132143225f);
        Hobby myHobby4 = new Hobby((byte) 7, 'k', (short) 75, false, 2147483647, 3.2225, 93463775L, 65.236725f);

        System.out.println(myHobby.toString());
        test.logMethod(myHobby);

        System.out.println(myHobby2.toString());
        test.logMethod(myHobby2);

        System.out.println(myHobby3.toString());
        test.logMethod(myHobby3);

        System.out.println(myHobby4.toString());
        test.logMethod(myHobby4);
    }

    public void logMethod(Hobby param){
        if (logger.isDebugEnabled())
            logger.debug("Debug mode: " + param.toString());

        if (logger.isInfoEnabled())
            logger.info("Info mode: " + param.toString());

        if (param.getLonge() != 0) {
            try {
                if (param.getLonge() > 2147483647L) {
                    throw new Exception("integer is overflow");
                }
            } catch (Exception ex) {
                logger.error("Here exception: ", ex);
            }
        }
    }
}
