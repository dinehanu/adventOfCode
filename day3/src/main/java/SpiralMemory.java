public class SpiralMemory {

    public int calculateNumberOfSteps(int position){

        int rowValue = 1;
        int rowIndex = 0;

        rowValue += (4*(rowIndex + 2));
        return 0;
    }

    public int getRowNumber(int index){
        int ret = 0;
        int firstIndexInCircle = 1;
        while(firstIndexInCircle < index){
            firstIndexInCircle += (firstIndexInCircle+8);
            ret++;
        }
        return ret-1;
    }
}
