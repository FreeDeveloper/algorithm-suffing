package cn.smile.sort;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void sortTestBasic(){
        int [] array = new int[]{5,8,6,3,9,2,1,7};
        BubbleSort.sortBasic(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void sortTestBoolean(){
        int [] array = new int[]{5,8,6,3,9,2,1,7};
        BubbleSort.sortBoolean(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void sortKnowLastchangeTest(){
        int [] array = new int[]{3,4,2,1,5,6,7,8};
        BubbleSort.sortKnowLastchange(array);
        System.out.println(Arrays.toString(array));
    }
}
