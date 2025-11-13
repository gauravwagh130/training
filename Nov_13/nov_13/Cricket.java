package com.java.training.nov_13;

public class Cricket {
    static int score=0;
    public void increment(int x) {
        score += x;
    }
    public static void main(String[] args) {
        Cricket ply1 = new Cricket();
        Cricket ply2 = new Cricket();
        Cricket ext = new Cricket();
        ply1.increment(50);
        ply2.increment(100);
        ext.increment(4);
        System.out.println("Total Score is :" + score);
    }
}
