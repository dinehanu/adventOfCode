package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day8Solver {

    private final FileReader fileReader;

    public Day8Solver(){
        this.fileReader = new FileReader();
    }

    public long solveFirstTask(){
        List<Integer> input = fileReader.getFileContent("input");
        return new Tree(input).getSummedMetadata();
    }

    public long solveSecondTask(){
        List<Integer> input = fileReader.getFileContent("input");
        return new Tree(input).getNodeValue();
    }

    public Tree getTree(List<Integer> input){
        return  new Tree(input);
    }

    public class Tree {
        private Node root;

        public Tree(List<Integer> rootData) {
            root = new Node(rootData, 0, null);
        }

        public int getSummedMetadata(){
            return root.getSummedMetadata();
        }

        public int getNodeValue(){
            return root.getNodeValue();
        }

        public class Node {
            private List<Integer> metadata;
            private Node parent;
            private List<Node> children;

            public Node(List<Integer> input, int nodeIndex, Node parent) {
                int numberOfChildren = input.get(nodeIndex);
                int numberOfMetadata = input.get(nodeIndex+1);
                children = new ArrayList<>(numberOfChildren);
                int childStartIndex = 2;
                for (int i = 0; i < numberOfChildren; i++) {
                    children.add(new Node(input, nodeIndex+childStartIndex, this));
                    childStartIndex += children.get(i).getSize();
                }

                int metadataStartIndex = nodeIndex + 2 + children.stream().mapToInt(Node::getSize).sum();
                metadata = input.subList(metadataStartIndex, metadataStartIndex+numberOfMetadata);
            }

            private int getSize(){
                return 2 + metadata.size() + children.stream().mapToInt(Node::getSize).sum();
            }

            public int getSummedMetadata(){
                return metadata.stream().mapToInt(Integer::intValue).sum() +
                        children.stream().mapToInt(Node::getSummedMetadata).sum();
            }

            public int getNodeValue(){
                int ret = 0;
                if(children.size() == 0){
                    return metadata.stream().mapToInt(Integer::intValue).sum();
                } else {
                    for (Integer childIndex : metadata) {
                        if(childIndex <= children.size())
                        ret += children.get(childIndex-1).getNodeValue();
                    }
                }
                return ret;
            }
        }
    }
}
