package cn.smile.sort.countAndbucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 * 时间复杂度分析
 * 求数列最大最小值 n
 * 创建空桶 n
 * 把原始数列分配到各个桶中n
 * 在每个桶做排序，元素均匀分布的情况下，运算量之和为n
 * 输出排序数列 n
 *
 * 桶排序的总体时间复杂度为O(n
 *
 * 空间复杂度也是O(n)
 *
 * */
public class BucketSort {
    public static double[] bucketSort(double [] array){
        //得到数列的最大值和最小值，并算出差值
        double max = array[0];
        double min = array[0];

        for(int i = 1;i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }

            if(array[i] < min){
                min = array[i];
            }
        }

        double d = max - min;

        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);

        for(int i = 0; i < bucketNum ; i++){
            bucketList.add(new LinkedList<Double>());
        }

        //遍历原始数组，将每个元素放入桶中

        for(int i = 0; i< array.length; i++){
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i< bucketList.size();i++){
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素

        double [] sortArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double elelment : list) {
                sortArray[index] = elelment;
                index++;
            }
        }

        return sortArray;

    }
}
