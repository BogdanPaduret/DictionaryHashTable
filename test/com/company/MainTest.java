package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void hashFunctionTest() {

        String[] names = {"A","B","Z","Ana", "B1na", "Cna", "Ama", "Aba", "Abba", "Aza", "Amna","Ayazaoisadfasudnbf","Za","Az","Ba","Zz","Aa","Ab","!1273asd","{123}"};
        Double[] values = new Double[names.length];
        int length = 10;
        double constant = 5;
        for (int i=0; i < names.length; i++) {
            values[i] = hashFunction(names[i], length, constant);
        }
        sort(values, names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + values[i]);
        }
    }

    @Test
    void sumDigitsTest() {
        int[] ints = {1, 2, 3, 11, 22, 33, 111, 222, 333};

        for (int i : ints) {
            System.out.println(i + ": " + sumDigits(i));
        }
    }

    double hashFunction(String key, int length,double constant) {
        double value = 0;
        int nGlyphs = 26;
        int minGlyph = 96;
        String keyString = key.toString().toLowerCase();
        int keySize = keyString.length();
        for (int i = 0; i < keySize; i++) {
            double dividend = Math.pow(nGlyphs, (Math.pow((i + 1), 2)));

            char c = keyString.charAt(i);
            double asciiValue = (int) c;
            asciiValue = (nGlyphs-(asciiValue - minGlyph));///(25*(i+1));
            asciiValue = asciiValue / dividend;

            value += asciiValue;

            if (i == keySize - 1) {
                value += 1 / dividend;
            }

        }
//        value = sumDigits(value);
        return value;
    }

    int sumDigits(int value) {
        String valueString = value + "";
        value = 0;
        for (int i = 0; i < valueString.length(); i++) {
            value += Integer.parseInt(valueString.charAt(i) + "");
        }
//        value = value % length;
        return value;
    } //n-am mai avut nevoie de aceasta metoda

    void sort(Double[] values, String[] names) {
        boolean flag = false;
        do {
            flag = true;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] < values[i + 1]) {
                    moveSortElement(values, i);
                    moveSortElement(names, i);
                    flag = false;
                }
            }
        } while (flag == false);
    }

    <T> void moveSortElement(T[] v, int i) {
        T aux = v[i];
        v[i] = v[i + 1];
        v[i + 1] = aux;
    }

}