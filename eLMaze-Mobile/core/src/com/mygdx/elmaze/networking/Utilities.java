package com.mygdx.elmaze.networking;

import java.util.LinkedList;

public class Utilities {

    public static String parse(LinkedList<Integer> rawIP) {
        if (rawIP.size() != 8) {
            return "";
        }

        String parsedIP = "";

        for (int i=0 ; i<8 ; i+=2) {
            parsedIP += (16*rawIP.get(i)+rawIP.get(i+1)) + (i != 6 ? "." : "");
        }

        return parsedIP;
    }

}
