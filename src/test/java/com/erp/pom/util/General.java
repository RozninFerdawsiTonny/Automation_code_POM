package com.erp.pom.util;

public class General {

    public static void waitForDomSable(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
