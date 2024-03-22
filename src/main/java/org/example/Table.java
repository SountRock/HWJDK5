package org.example;

import java.util.List;

public class Table {
    private List<Fork> forks;

    public Table(List<Fork> forks) {
        this.forks = forks;
    }

    public Fork getFork(Philosopher philosopher){
        for (Fork fork : forks ) {
            if(!fork.getStatus()){
                fork.setOwner(philosopher);
                return fork;
            }
        }

        return null;
    }
}
