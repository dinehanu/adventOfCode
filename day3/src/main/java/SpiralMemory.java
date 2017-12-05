public class SpiralMemory {

    public int calculateNumberOfSteps(int position){

        int circleNumber = getCircleNumber(position);
        int lastIndex = getLastIndexOfCircle(position);

        if(circleNumber == 0){
            return 0;
        }
        int numberOfSteps = (circleNumber == 1 ? 2 : (circleNumber^2));


            if(lastIndex == position){
                return numberOfSteps;
            }
            else{
                int stepCounter = 1;
                int xCounter = 4;
                int yCounter = 0;
                while(lastIndex != position){

                }

            }

        return 0;
    }

    public int getCircleNumber(int index){
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

    public int getLastIndexOfCircle(int index){
        int lastIndexInCircle = 1;
        int increase = 0;
        while(lastIndexInCircle < index){
            increase += 8;
            lastIndexInCircle += increase;
        }
        return lastIndexInCircle;
    }
}
