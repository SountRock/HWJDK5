package org.example;

public class Fork {
    private Philosopher philosopher;
    private int forkID;
    private static int index = 1;

    public Fork() {
        forkID = index++;
    }

    public int getForkID() {
        return forkID;
    }

    public boolean getStatus() {
        return philosopher != null;
    }

    public void setOwner(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    public void putDown() {
        this.philosopher = null;
    }
}
