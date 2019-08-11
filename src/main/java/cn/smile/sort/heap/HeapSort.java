package cn.smile.sort.heap;

import cn.smile.heap.TreeHeapStructure;

import java.util.Arrays;

/**
 * 把无序数组构建成二叉堆，需要从小到大排序，则构建成最大堆，需要从大到小排序，则构建成最小堆,时间复杂度O(n)
 *
 * 循环删除堆顶元素，替换到二叉树的末尾，调整堆生成新的堆顶,需要进行n-1此循环，每次调用downAdjust方法，时间复杂度（n-1）*logn
 *
 *总体时间复杂度O(n*LogN)
 *
 *
 *
 * */
public class HeapSort {
    public static void HeapSort(int [] array){

        for(int i = (array.length - 2) / 2 ; i >= 0; i--){
            TreeHeapStructure.downAdjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));

        for(int i = array.length - 1;i >0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            TreeHeapStructure.downAdjust(array,0,i);
        }
    }
}
