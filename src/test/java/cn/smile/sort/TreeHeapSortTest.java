package cn.smile.sort;

import cn.smile.sort.heap.HeapSort;
import org.junit.Test;

import java.util.Arrays;

public class TreeHeapSortTest {

    @Test
    public void heapSortTest(){
        int [] arr = new int [] {1,3,2,6,5,7,8,9,10,0};
        HeapSort.HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
