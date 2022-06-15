package com.company.helpers;

public class HelperMethods {

    public static double changeScale(double value, double minOld, double maxOld, double minNew, double maxNew) {
        return ((maxNew-minNew)/(maxOld-minOld)) * (value-minOld) + minNew;
//        return ((maxNew-minNew)/(maxOld-minOld)) * (value-maxOld) + maxNew;
    }


}
