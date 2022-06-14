package com.company.implemented;

public class Entry<K, V> {

    //instance variables
    private K key;
    private V value;

    //constructors
    public Entry(){}
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //getter+setter
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }

    //override methods
    @Override
    public String toString() {
        String string = "";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        Entry<K, V> entry = (Entry) o;
        return this.key.equals(entry.key) && this.value.equals(entry.value);
    }
}
