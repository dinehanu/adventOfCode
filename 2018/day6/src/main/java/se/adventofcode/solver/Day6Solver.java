package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day6Solver {

    private final FileReader fileReader;

    public Day6Solver(){
        this.fileReader = new FileReader();
    }

    public long solveFirstTask(){
        List<String> lines = fileReader.getFileContentAsArray("input");
        List<Coordinate> coordinates = getCoordinates(lines);
        Point[][] matrix = getFilledMatrix(coordinates);
        return 0;
    }


    private Point[][] getFilledMatrix(List<Coordinate> coordinates){
        Point[][] matrix = new Point[1000][1000];

        for (int i = 0; i <coordinates.size() ; i++) {
            for (int x = 0; x <1000 ; x++) {
                for (int y = 0; y <1000 ; y++) {

                    Point point = new Point(i, calculateDistance(coordinates.get(i), new Coordinate(x, y)));

                    if(matrix[x][y] == null || matrix[x][y].compareTo(point) < 0){
                        matrix[x][y]= point;
                    } else if(matrix[x][y].compareTo(point) == 0){
                        matrix[x][y].equalDistance = true;
                    }
                }
            }
        }


    return matrix;
    }

    private int calculateDistance(Coordinate a, Coordinate b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private List<Coordinate> getCoordinates(List<String> lines){
        List<Coordinate> coordinates = new ArrayList<>();
        for (String line: lines) {
            coordinates.add(new Coordinate(line));
        }
        return coordinates;
    }

    private class Point{

        int index;
        int distance;
        boolean equalDistance = false;

        public Point(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Point a){
            return this.distance - a.distance;
        }
    }

    private class Coordinate{

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(String line) {
            String[] values = line.split(",");
            this.x = Integer.parseInt(values[0].trim());
            this.y = Integer.parseInt(values[1].trim());
        }
    }
}
