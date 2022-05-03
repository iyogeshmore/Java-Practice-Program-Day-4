package com.bridgelabz.day4;

import java.util.concurrent.atomic.AtomicInteger;

public class SnakeLadder {
    public SnakeLadder() {
    }

    public static int rollDie() {
        int var0 = (int)(Math.random() * 6.0D + 1.0D);
        System.out.println("The die value is " + var0);
        return var0;
    }

    public static int optionValue() {
        AtomicInteger var0 = new AtomicInteger((int) (Math.random() * 3.0D + 1.0D));
        return var0.get();
    }

    public static int playTurn(int var0) {
        int var1 = rollDie();
        int var2 = optionValue();
        switch(var2) {
            case 1:
                System.out.println("No Play");
                break;
            case 2:
                if (var0 + var1 > 100) {
                    System.out.println("Sorry, you must reach exactly 100 or lower position with the die roll");
                } else {
                    System.out.println("Ladder, so moving ahead by die value " + var1);
                    var0 += var1;
                }
                break;
            case 3:
                if (var0 < var1) {
                    System.out.println("Snake, but stops at starting position");
                    var0 = 0;
                } else {
                    System.out.println("Snake, moving backward by die value " + var1);
                    var0 -= var1;
                }
        }

        System.out.println("Player position: " + var0);
        return var0;
    }

    public static void playGame() {
        for(int var0 = 0; var0 < 100; var0 = playTurn(var0)) {
            System.out.println("-------------------------------");
        }

    }

    public static void main(String[] var0) {
        playGame();
    }
}
