package cn.smile.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void doubleWhileQuickSortTest(){
        int [] arr = new int [] {4,4,6,5,3,2,8,1};
        QuickSortDoubleWhile.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void singleWhileQuickSortTest(){
        int [] arr = new int [] {4,4,6,5,3,2,8,1};
        QuickSortSingleWhile.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
