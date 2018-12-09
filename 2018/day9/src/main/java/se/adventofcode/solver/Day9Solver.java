package se.adventofcode.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9Solver {

    public long solveFirstTask(int numberOfPlayers, int lastMarbleValue){
        return getGamePoints(numberOfPlayers, lastMarbleValue);
    }

    private long getGamePoints(int numberOfPlayers, int lastMarbleValue){

        List<Integer> players = new ArrayList<>(Collections.nCopies(numberOfPlayers, 0));
        int currentMarble = 0;
        int currentPlayer = 0;

        List<Integer> playingField = new ArrayList<>();
        playingField.add(0);

        for (int i = 1; i <= lastMarbleValue; i++) {
            if (i % 23 == 0) {
                int index6 = getIndex(playingField.indexOf(currentMarble)-6, playingField);
                int index7 = getIndex(playingField.indexOf(currentMarble)-7, playingField);
                int score = i + playingField.get(index7);
                players.set(currentPlayer, players.get(currentPlayer) + score);
                currentMarble = playingField.get(index6);
                playingField.remove(index7);
            } else {
                playingField = addMarbletoList(playingField, i, currentMarble);
                currentMarble = i;
            }
            currentPlayer = currentPlayer == numberOfPlayers-1 ? 0 : currentPlayer+1;
        }
        return Collections.max(players);
    }

    private int getIndex(int index, List<Integer> playingField){
        return index < 0 ? playingField.size() + index : index;
    }

    private List<Integer> addMarbletoList(List<Integer> playingField, int marble, int currentMarble){
        if(playingField.indexOf(currentMarble) == playingField.size()-1){
            playingField.add(1, marble);
        } else if(playingField.indexOf(currentMarble) == playingField.size()-2){
            playingField.add(marble);
        } else {
            playingField.add(playingField.indexOf(currentMarble)+2, marble);
        }
        return playingField;
    }
}
