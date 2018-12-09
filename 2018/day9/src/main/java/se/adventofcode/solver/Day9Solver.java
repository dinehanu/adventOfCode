package se.adventofcode.solver;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Day9Solver {

    public long solveFirstTask(int numberOfPlayers, int lastMarbleValue) {
        return getGamePoints(numberOfPlayers, lastMarbleValue);
    }

    private long getGamePoints(int numberOfPlayers, int lastMarbleValue) {
        CircleDeque<Integer> circle = new CircleDeque<>();
        circle.addFirst(0);
        long[] scores = new long[numberOfPlayers];
        for (int i = 1; i <= lastMarbleValue; i++) {
            if (i % 100000 == 0) {
                System.out.println("På värde: " + i);
            }
            if (i % 23 == 0) {
                circle.rotate(-7);
                scores[i % numberOfPlayers] += i + circle.pop();

            } else {
                circle.rotate(2);
                circle.addLast(i);
            }
        }
        return Arrays.stream(scores).max().getAsLong();
    }

    class CircleDeque<T> extends ArrayDeque<T> {
        void rotate(int num) {
            if (num > 0) {
                for (int i = 0; i < num; i++) {
                    T t = this.removeLast();
                    this.addFirst(t);
                }
            } else {
                for (int i = 0; i < Math.abs(num) - 1; i++) {
                    T t = this.remove();
                    this.addLast(t);
                }
            }

        }
    }
}

