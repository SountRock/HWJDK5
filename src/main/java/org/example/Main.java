package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fork> forks = new ArrayList<>();
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());

        Table table = new Table(forks);
        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            philosophers.add(new Philosopher("Phill" + (i + 1)));
            philosophers.get(i).setTable(table);
            new Thread(philosophers.get(i)).start();
        }
    }
}