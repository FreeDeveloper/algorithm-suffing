package cn.smile.sort.bubble;

public class BubbleJWJSort {
    public static void sort(int array[]){
        int temp = 0;
        for(int i = 0; i<array.length/2;i++){
            boolean isSorted = true;
            for(int j = i;j< array.length - i - 1;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }

            if(isSorted){
                break;
            }

            isSorted = true;
            for(int j = array.length - i - 1;j>i;j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
