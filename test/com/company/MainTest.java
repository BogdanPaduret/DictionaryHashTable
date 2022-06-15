package com.company;

import com.company.helpers.HelperMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void hashFunctionTest() {

//        String[] names = {"\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!","A","B","Z","Ana", "B1na", "Cna", "Ama", "Aba", "Abba", "Aza", "Amna","Ayazaoisadfasudnbf","Za","Az","Ba","Zz","Aa","Ab","!1273asd","{123}","}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}","Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz!","Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz","A!!!!!!!!!!!!!!!!!!"};
//        String[] names = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//        String[] names = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] names = {"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz","az", "bz", "cz", "dz", "ez", "fz", "gz", "hz", "iz", "jz", "kz", "lz", "mz", "nz", "oz", "pz", "qz", "rz", "sz", "tz", "uz", "vz", "wz", "xz", "yz", "zz","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Double[] values = new Double[names.length];
        int length = 10;
        double constant = 5;
        for (int i=0; i < names.length; i++) {
            double hash = hashFunction(names[i], length, constant);
            values[i] = (double) hashIndex(hash, length);
        }
        sort(values, names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + values[i]);
        }
    }

    double hashFunction(String key, int length,double constant) {
        double value = 0;

        int nGlyphs = 27;
        int minGlyph = 96;

        String keyString = key.toString().toLowerCase();

        int keySize = keyString.length();

        for (int i = 0; i < keySize; i++) {
            double dividend = Math.pow(nGlyphs, (Math.pow((i + 1), 1)));

            char c = keyString.charAt(i);
            double asciiValue = (int) c;
            asciiValue = (nGlyphs - (asciiValue - minGlyph));
            asciiValue = asciiValue / dividend;
//            System.out.println(asciiValue);
            value += asciiValue;

            if (i == keySize - 1) {
                value += 1 / dividend;
            }

        }
        return value;
    }

    int hashIndex(double hash,int length) {
        return length - (int) HelperMethods.changeScale(hash, 0, 1, 0, length);
    }

    @Test
    void sumDigitsTest() {
        int[] ints = {1, 2, 3, 11, 22, 33, 111, 222, 333};

        for (int i : ints) {
            System.out.println(i + ": " + sumDigits(i));
        }
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