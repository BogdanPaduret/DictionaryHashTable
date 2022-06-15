package com.company.implemented;

import com.company.helpers.HelperMethods;

public class Dictionary<K, V> {

    //instance variables
    private Entry<K, V>[] hashtable;
    private static int size = 0;

    //constructor
    public Dictionary() {
        hashtable = new Entry[10];
    }

    //create
    public void put(K key, V value) {
        int position;
        position = getIndex(key);
        if (occupied(position)) {

        }
        if (occupied(position)) {
            System.out.println("Position not found for given key");
        } else {
            hashtable[position] = new Entry<>();
            hashtable[position].setKey(key);
            hashtable[position].setValue(value);
            size++;
        }
    }

    private double hashFunction(K key) {
        /*valoarea cheii. este un double intre 0 si 1 indiferent de caracterele introduse DACA nGlyphs=127 si minGlyph=0
        sau intre 0 si 1 doar daca sunt litere (caracterele speciale pot da putin peste cap functia) adica nGlyphs=27 si minGlyph=96
        se prefera 27/96 fiindca altfel tabelul va avea prima jumatate goala in majoritatea cazurilor
        */
        double value = 0;

        int nGlyphs = 27; //cate simboluri sunt in total folosite (127 tot tabelul standard sau 27 doar pentru litere)
        int minGlyph = 96; //de la cat incepe primul simbol in tabelul ASCII (0 pentru tot tabelul, 96 pentru 'a')

        String keyString = key.toString().toLowerCase();

        int keySize = keyString.length();

        for (int i = 0; i < keySize; i++) {
            double dividend = Math.pow(nGlyphs, (Math.pow((i + 1), 2)));

            char c = keyString.charAt(i);
            double asciiValue = (int) c;
            asciiValue = (nGlyphs-(asciiValue - minGlyph))/dividend;

            value += asciiValue;

            if (i == keySize - 1) {
                value += 1 / dividend;
            }

        }
        return value;
    }
    private int getIndex(double hashCode) {

        int index = hashtable.length - 1 - (int) HelperMethods.changeScale(hashCode, 0, 1, 0, hashtable.length - 1);

        return index;

    }

    //read
    public int getIndex(K key) {
        return getIndex(hashFunction(key));
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public String show() {
        String string = "";

        int c = 0;

        for (Entry<K, V> entry : hashtable) {
            if (entry != null) {
                string += c + ":\n";
            } else {
                string += c + ": " + entry.toString() + "n\";";
            }
        }

        return string;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Entry<K, V> []getTable() {
        return hashtable;
    }

    //remove
    public void remove(K key) {

    }





}
