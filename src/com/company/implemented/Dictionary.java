package com.company.implemented;

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
        position = hashKey(key);
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

    private int hashKey(K key) {
        int value = 0;
        String keyString = key.toString();
        int keySize = keyString.length();
        for (int i = 0; i < keySize; i++) {
            char c = keyString.charAt(keySize - i - 1);
            value = c * (i + 1);
        }
        value = value % hashtable.length;
        return value;
    }

    //read
//    public int getIndex(K key) {
//
//    }

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
