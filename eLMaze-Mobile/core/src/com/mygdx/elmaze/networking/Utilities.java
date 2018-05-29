package com.mygdx.elmaze.networking;

import java.util.LinkedList;

/**
 * Generic utilities for the application's networking
 */
public class Utilities {

    /**
     * Parses an IP address represented by a size 8 hexadecimal digit linked list to a regular string IP address
     *
     * @param rawIP IP address represented by a size 8 hexadecimal digit linked list
     *
     * @return Returns the parsed IP address
     */
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
