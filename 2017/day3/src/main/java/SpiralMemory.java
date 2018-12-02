public class SpiralMemory {

    public int calculateTotalNumberOfSteps(int position){
        int[] coordinates = calculateNumberOfSteps(position);
        return (coordinates[0] + coordinates[1]);
    }

    private int[] calculateNumberOfSteps(int position){

        int[] ret = new int[]{0,0};
        int circleNumber = getCircleNumber(position);
        int lastIndex = getLastIndexOfCircle(position);

        if(circleNumber == 0){
            return ret;
        }

        ret = getPositions(circleNumber, lastIndex, position);
        return ret;
    }

    private int getCircleNumber(int index){
        int circleNumber = 0;
        int firstIndexInCircle = 1;
        int increase = 0;
        while(firstIndexInCircle < index){
            increase += 8;
            firstIndexInCircle += increase;
            circleNumber++;
        }
        return circleNumber;
    }

    private int getLastIndexOfCircle(int index) {
        int lastIndexInCircle = 1;
        int increase = 0;
        while (lastIndexInCircle < index) {
            increase += 8;
            lastIndexInCircle += increase;
        }
        return lastIndexInCircle;
    }

    private int[] getPositions(int circleNumber, int largestIndex, int index){

        //MaxNumber of steps
        int[] ret = {circleNumber, circleNumber};

        ret[0] = calculateValue(circleNumber, largestIndex, index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret[1] = calculateValue(circleNumber, (largestIndex - circleNumber*2), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret[0] = calculateValue(circleNumber, (largestIndex - circleNumber*4), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret[1] = calculateValue(circleNumber, (largestIndex - circleNumber*6), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        return ret;
    }

    private int calculateValue(int circleNumber, int largestIndex, int index){

        int counter = 0;
        int numberOfSteps = circleNumber;
        int numberOfStepsToGo = circleNumber * 2;

        while(counter < numberOfStepsToGo){
            numberOfSteps = counter < circleNumber ? --numberOfSteps : ++numberOfSteps;
            largestIndex--;
            counter++;
            if(largestIndex == index){
                return numberOfSteps;
            }
        }
        return numberOfSteps;
    }
}
