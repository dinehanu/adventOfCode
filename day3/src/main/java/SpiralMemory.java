public class SpiralMemory {

    public int calculateNumberOfSteps(int position){

        int rowValue = 1;
        int rowIndex = 0;

        rowValue += (4*(rowIndex + 2));
        return 0;
    }

    public int getRowNumber(int index){
        int ret = 1;
        int firstIndexInCircle = 1;
        int increase = 0;
        while(firstIndexInCircle < index){
            increase += 8;
            firstIndexInCircle += increase;
            ret++;
        }
        return ret-1;
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
