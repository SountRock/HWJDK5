package org.example;

import java.util.Random;

public class Philosopher implements Runnable {
    private String name;
    private Fork left;
    private Fork right;
    private Random random;
    private Table table;
    private enum Status{EATING, THINKING}
    private Status status;

    public Philosopher(String name) {
        status = Status.THINKING;
        random = new Random();
        this.name = name;
    }

    public void setTable(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        while (true){
            action();
        }
    }

    private void action(){
        try {
            if(status == Status.EATING){
                if(getForks()){
                    System.out.println(name + ": eating with Fork " + left.getForkID() +
                            " & Fork " + right.getForkID());
                    Thread.sleep(random.nextLong(500, 1200));
                    putDownForks();
                } else {
                    System.out.println(name + ": not find free Forks");
                }

                status = Status.THINKING;
            } else {
                System.out.println(name + ": thinking");
                Thread.sleep(random.nextLong(1000, 10_000));

                status = Status.EATING;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized boolean getForks(){
        if(left == null){ left = table.getFork(this); }
        if(right == null){ right = table.getFork(this); }

        return left != null && right != null;
    }

    private void putDownForks(){
        left.putDown();
        right.putDown();
        left = null;
        right = null;
    }

}
