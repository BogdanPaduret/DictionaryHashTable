package com.company.implemented;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    Dictionary<String, String> dictionary;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void put() {
        /*
        size 732 se introduc toate elementele din lista cu nGlyphs=27 si minGlyph=96 ->litera singura la final de lista. Grad de umplere: 95.90%
        size 778 se introduc toate elementele din lista cu nGlyphs=28 si minGlyph=95 ->litera singura la inceput de lista. Grad de umplere: 89.38%
         */

        String input = "Ana,Mirela,Bianca,Georgiana,Gheorghe,Bogdan,Marcel,Victor,Zaiafet,Grigore,Grigoras,Iepure,Tudorel,Marsupiu,Arma,Pusca,Alabama,Chistoc,Tudorache,Artizanal,Artizanat,Aaron,Aron,Arcus,Anapoda,Zicala,Zdrobit,Maus,Tastatura,Keyboard";
        String[] names = input.split(",");

        dictionary = new Dictionary<>((int) (names.length * 1));

        for (int i = 0; i < names.length; i++) {
            dictionary.put(names[i], names[i]);
        }


        System.out.println(dictionary.getFillFactor());
        System.out.println(dictionary.getUsageFactor());
        System.out.println(dictionary.show());

        System.out.println("\n\n");

        int tableSize = 732;

        populate2Digits(tableSize);

        System.out.println(dictionary.show());
        System.out.println(dictionary.getFillFactor());
        System.out.println(dictionary.getUsageFactor());



    }

    @Test
    void getIndex() {
        String input = "Ana,Mirela,Bianca,Georgiana,Gheorghe,Bogdan,Marcel,Victor,Zaiafet,Grigore,Grigoras,Iepure,Tudorel,Marsupiu,Arma,Pusca,Alabama,Chistoc,Tudorache,Artizanal,Artizanat,Aaron,Aron,Arcus,Anapoda,Zicala,Zdrobit,Maus,Tastatura,Keyboard";
        String[] names = input.split(",");

        dictionary = new Dictionary<>((int) (names.length * 1));

        for (int i = 0; i < names.length; i++) {
            dictionary.put(names[i], names[i]);
        }

        //bianca 2
        //ana 1

        assertEquals(1, dictionary.getIndex("ana"));
        assertEquals(2, dictionary.getIndex("bianca"));
        assertEquals(3, dictionary.getIndex("chistoc"));
        assertEquals(7, dictionary.getIndex("georgiana"));

    }

    @Test
    void isEmpty() {
        String input = "Ana,Mirela,Bianca,Georgiana,Gheorghe,Bogdan,Marcel,Victor,Zaiafet,Grigore,Grigoras,Iepure,Tudorel,Marsupiu,Arma,Pusca,Alabama,Chistoc,Tudorache,Artizanal,Artizanat,Aaron,Aron,Arcus,Anapoda,Zicala,Zdrobit,Maus,Tastatura,Keyboard";
        String[] names = input.split(",");

        dictionary = new Dictionary<>((int) (names.length * 1));

        assertTrue(dictionary.isEmpty());

        for (int i = 0; i < names.length; i++) {
            dictionary.put(names[i], names[i]);
        }

        assertFalse(dictionary.isEmpty());

    }

    @Test
    void findKey() {
        String input = "Ana,Mirela,Bianca,Georgiana,Gheorghe,Bogdan,Marcel,Victor,Zaiafet,Grigore,Grigoras,Iepure,Tudorel,Marsupiu,Arma,Pusca,Alabama,Chistoc,Tudorache,Artizanal,Artizanat,Aaron,Aron,Arcus,Anapoda,Zicala,Zdrobit,Maus,Tastatura,Keyboard";
        String[] names = input.split(",");

        dictionary = new Dictionary<>((int) (names.length * 1));

        for (int i = 0; i < names.length; i++) {
            dictionary.put(names[i], names[i]);
        }

        assertEquals(1, dictionary.findKey("Ana"));
        assertEquals(-1, dictionary.findKey("ana"));
        assertEquals(2, dictionary.findKey("Bianca"));
        assertEquals(-1, dictionary.findKey("bianca"));

    }

    @Test
    void remove() {

        String input = "Ana,Mirela,Bianca,Georgiana,Gheorghe,Bogdan,Marcel,Victor,Zaiafet,Grigore,Grigoras,Iepure,Tudorel,Marsupiu,Arma,Pusca,Alabama,Chistoc,Tudorache,Artizanal,Artizanat,Aaron,Aron,Arcus,Anapoda,Zicala,Zdrobit,Maus,Tastatura,Keyboard";
        String[] names = input.split(",");

        dictionary = new Dictionary<>((int) (names.length * 1));

        for (int i = 0; i < names.length; i++) {
            dictionary.put(names[i], names[i]);
        }

        assertEquals(2,dictionary.findKey("Bianca"));

        dictionary.remove("Bianca");

        assertEquals(-1,dictionary.findKey("Bianca"));


    }


    private void populate2Digits(int tableSize) {
        dictionary = new Dictionary<>(tableSize);

        String input = "";

        //creaza litere singure gen a, b, c, etc in string-ul input
        for (int i = 97; i < 123; i++) {
            input += (char) i;
            input += ",";
        }

        //populeaza cu grupuri de doua litere gen aa, ab, ac, etc in string-ul input
        for (int i = 97; i < 123; i++) {
            for (int j = 97; j < 123; j++) {
                input += (char) i;
                input += (char) j;
                if (i != 122 || j != 122) {
                    input += ",";
                }
            }
        }

        System.out.println(input);

        String[] strings = input.split(",");

        System.out.println(strings.length);

        //populeaza dictionarul
        for (int i = 0; i < strings.length; i++) {
            dictionary.put(strings[i], strings[i]);
        }

    }
}