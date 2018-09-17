package com.aa.travianbot.util;

public class Utils {

    public static int parseInt(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]+", ""));
    }

}
