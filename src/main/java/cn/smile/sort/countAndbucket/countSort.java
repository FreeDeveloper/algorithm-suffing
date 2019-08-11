package cn.smile.sort.countAndbucket;

public class countSort {

    /**
     * 先根据数值范围创建统计数组，数值每出现一次，统计数组的对应下标的值+1
     * 然后循环统计数组，在最终的排序数组中增加如统计数组{0,2,3,1}
     * 最终结果{1,1,2,2,2,3}
     *
     * */
    public static int[] countSort(int [] array){

        //得到数列的最大值
        int max = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        //根据最大值确定统计数组的长度
        int [] countArray = new int[max+1];

        for(int i=0;i<array.length;i++){
            countArray[array[i]]++;
        }

        int index = 0;
        int [] sortArray = new int[array.length];
        for(int i=0; i< countArray.length;i++){
            for(int j=0;j<countArray[i];j++){
                sortArray[index++]=i;
            }
        }

        return sortArray;
    }
 }
