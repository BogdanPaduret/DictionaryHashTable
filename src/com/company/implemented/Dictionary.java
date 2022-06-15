package com.company.implemented;

import com.company.helpers.HelperMethods;

public class Dictionary<K, V> {

    //instance variables
    private Entry<K, V>[] hashtable;
    private static int occupiedCells;
    private static int tries;

    //constructor
    public Dictionary(int size) {
        hashtable = new Entry[size];
        occupiedCells = 0;
        tries = 0;
    }

    //create
    public void put(K key, V value) {
        int position;
        position = getIndex(key);

        if (occupied(position)) {
            System.out.println("Position not found for given key " + key.toString());
        } else {
            hashtable[position] = new Entry<>();
            hashtable[position].setKey(key);
            hashtable[position].setValue(value);
            occupiedCells++;
        }

        tries++;
    }

    private double hashFunction(K key) {
        /*valoarea cheii. este un double intre 0 si 1 indiferent de caracterele introduse DACA nGlyphs=127 si minGlyph=0
        sau intre 0 si 1 doar daca sunt litere (caracterele speciale pot da putin peste cap functia) adica nGlyphs=27 si minGlyph=96
        se prefera 27/96 fiindca altfel tabelul va avea prima jumatate goala in majoritatea cazurilor
        */
        double value = 0;
        /*
        nGlyphs - cate simboluri sunt in total folosite (ex: a-z =26)
        minGlyph - codul primului simbol -1 (ex: a=97, minGlyph=96)
        Grupuri de lucru gasite:
            - 127/0 (tot tabelul ascii. grad de umplere foarte mic)
            - 27/96 (litera singura la sfarsit, gradul cel mai mare umplere)*
            - 28/95 (litera singura la inceput, grad mare de umplere dar mai mic decat cel cu litera singura la sfarsit)*
            - 26/96 (elementele se "intind" pe aproape toata plaja DAR NU SE INTRODUC TOATE ELEMENTELE. Grad mare de umplere):
                - cu litera singura la INCEPUT: tabelul se ocupa incepand cu prima pozitie (pozitia 0, 'A' singular)
                - cu litera singura la SFARSIT: tabelul NU incepe de la prima pozitia dar 'Z' singular se afla pe ultima pozitie

            *grupurile 27/96 si 28/95 INTRODUC TOATE ELEMENTELE DAR PRIMELE SI ULTIMELE POZITII RAMAN MEREU NEOCUPATE

         */

        int nGlyphs = 27; //cate simboluri sunt in total folosite (127 tot tabelul standard sau 27 doar pentru litere)  127/27/ 28/ 26
        int minGlyph = 96; //de la cat incepe primul simbol in tabelul ASCII (0 pentru tot tabelul, 96 pentru 'a')      0/  96/ 95/ 96

        String keyString = key.toString().toLowerCase();

        int keySize = keyString.length();

        for (int i = 0; i < keySize; i++) {
            double dividend = Math.pow(nGlyphs, (Math.pow((i + 1), 1)));

            char c = keyString.charAt(i);

            double asciiValue = c;

            //cod pentru litera singura la inceput
//            if (i == keySize - 1) {
//                asciiValue = (int) c-1;
//            } else {
//                asciiValue = (int) c;
//            }
            //sfarsit cod pentru litera singura la inceput

            asciiValue = (nGlyphs-(asciiValue - minGlyph))/dividend;

            value += asciiValue;

        }
        return value;
    }
    private int getIndex(double hashCode) {

        double notInt = HelperMethods.changeScale(hashCode, 0, 1, 0, hashtable.length - 1);

        int index = hashtable.length - 1 - (int) notInt;

        return index;

    }

    //read
    public int getIndex(K key) {
        return getIndex(hashFunction(key));
    }
    public boolean occupied(int index) {
        return hashtable[index] != null;
    }
    public String show() {
        String string = "";

        int c = 0;

        for (Entry<K, V> entry : hashtable) {
            if (entry == null) {
                string += c + ": \n";
            } else {
                string += c + ": " + entry.getValue().toString() + "\n";
            }
            c++;
        }

        return string;
    }
    public boolean isEmpty() {
        return occupiedCells == 0;
    }

    public int findKey(K key) {
        int position;
        position = getIndex(key);

        if (occupied(position)) {
            if (hashtable[position].getKey().equals(key)) {
                return position;
            }
        }

        return -1;
    }

    public double getFillFactor() {
        return (double) occupiedCells / hashtable.length;
    }
    public int getFilledCells() {
        return occupiedCells;
    }
    public double getUsageFactor() {
        return (double) occupiedCells / tries;
    }

    private Entry<K, V> []getTable() {
        return hashtable;
    }

    //remove
    public void remove(K key) {
        int position;
        position = getIndex(key);

        if (occupied(position)) {
            if (hashtable[position].getKey().equals(key)) {
                hashtable[position] = null;
                occupiedCells--;
                tries--;
            } else {
                System.out.println("Invalid key. Object with another key stored on this position.");
            }
        } else {
            System.out.println("Object with given key not stored");
        }
    }





}
