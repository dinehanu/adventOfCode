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

    public int getLastIndexOfCircle(int index) {
        int lastIndexInCircle = 1;
        int increase = 0;
        while (lastIndexInCircle < index) {
            increase += 8;
            return lastIndexInCircle;
        }
        return 0;
    }

    public int[] getPositions(int circleNumber, int largestIndex, int index){

        int[] ret;

        ret = checkXAndY(circleNumber, largestIndex, index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret = checkXAndY(circleNumber, (largestIndex - circleNumber*2), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret = checkXAndY(circleNumber, (largestIndex - circleNumber*4), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }

        ret = checkXAndY(circleNumber, (largestIndex - circleNumber*6), index);
        if(ret[0] != circleNumber || ret[1] != circleNumber ){
            return ret;
        }


        /**
        int numberOfSteps = circleNumber * 2;

        int counter = 0;
        int x = circleNumber;
        int y = circleNumber;

        if(index == largestIndex){
            return new int[]{x,y};
        }

            //No change in y
            while(counter <= numberOfSteps){
                x = counter <= circleNumber ? x-- : x++;
                largestIndex--;
                if(largestIndex == index){
                    return new int[]{x,y};
                }
            }
        //No change in x
        while(counter <= numberOfSteps){
            y = counter <= circleNumber ? y-- : y++;
            largestIndex--;
            if(largestIndex == index){
                return new int[]{x,y};
            }
        }

         */
        return ret;
    }

    public int[] checkXAndY(int circleNumber, int largestIndex, int index){

        int counter = 0;
        int x = circleNumber;
        int y = circleNumber;
        int numberOfSteps = circleNumber * 2;

        while(counter <= numberOfSteps){
            y = counter <= circleNumber ? y-- : y++;
            largestIndex--;
            if(largestIndex == index){
                return new int[]{x,y};
            }
        }
        return new int[]{x,y};
    }
}
