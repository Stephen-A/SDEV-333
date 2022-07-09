package test;

import hashing.HashTable;

public class TestHash {

    public static void main(String[] args) {

        HashTable<String> animals = new HashTable<>();

        animals.add("Bear");
        animals.add("Panda");
        animals.add("Lion");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Rat");
        animals.add("Zebra");
        animals.add("Bear");
        animals.add("Panda");
        animals.add("Snake");
        animals.add("Frog");
        animals.add("Gold Fish");
        animals.add("Spider");
        animals.add("Dog");
        animals.add("Butterfly");
        animals.add("Parrot");
        animals.add("Moose");
        animals.add("Deer");

        System.out.println(animals);

    }
}
