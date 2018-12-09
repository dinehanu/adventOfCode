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
        int currentMarbleIndex = 0;
        int currentPlayer = 0;

        List<Integer> playingField = new ArrayList<>();
        playingField.add(0);

        for (int i = 1; i <= lastMarbleValue; i++) {
            if (i % 23 == 0) {
                int index6 = getIndex(currentMarbleIndex-6, playingField);
                int index7 = getIndex(currentMarbleIndex-7, playingField);
                int score = i + playingField.get(index7);
                players.set(currentPlayer, players.get(currentPlayer) + score);
                currentMarbleIndex = index6-1;
                playingField.remove(index7);
            } else {
                int index = getAddIndex(currentMarbleIndex, playingField);
                if(index >=playingField.size()){
                    playingField.add(i);
                    currentMarbleIndex = playingField.size()-1;
                } else {
                    playingField.add(index, i);
                    currentMarbleIndex = index;
                }
            }
            currentPlayer = currentPlayer == numberOfPlayers-1 ? 0 : currentPlayer+1;
        }
        return Collections.max(players);
    }

    private int getIndex(int index, List<Integer> playingField){
        return index < 0 ? playingField.size() + index : index;
    }

    private int getAddIndex(int index, List<Integer> playingField){
        if(index == playingField.size()-1){
            return 1;
        } else if(index == playingField.size()-2){
           return playingField.size()+1;
        } else {
            return index+2;
        }
    }

}
