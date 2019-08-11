package cn.smile.sort.bubble;

public class BubbleSort {

    /**
     * 冒泡排序，时间复杂度O(n²)
     * */
    public static void sortBasic(int [] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i -1; j ++){
                int temp = 0;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 提前结束对比，如果本轮没有任何要交换的元素，则认为已经有序
     * */
    public static void sortBoolean(int [] array){
        for(int i = 0; i< array.length;i++){
            boolean isSorted = true;
            for(int j = 0;j<array.length - i - 1;j++){
                int temp = 0;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[i+1];
                    array[i+1] = temp;

                    //因为有元素要交换，所以不是有序的，标记为false
                    isSorted = false;
                }
            }

            if(isSorted){
                break;
            }
        }
    }

    public static void sortKnowLastchange(int [] array){

        //记录一下最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只比较到这里为止
        int sortBorder = array.length - 1;
        for(int i = 0; i< array.length;i++){
            boolean isSorted = true;

            for(int j = 0; j < sortBorder; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }
}
