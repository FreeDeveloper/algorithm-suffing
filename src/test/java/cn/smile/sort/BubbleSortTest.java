package cn.smile.sort;

import cn.smile.sort.bubble.BubbleJWJSort;
import cn.smile.sort.bubble.BubbleSort;
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

    @Test
    public void sortJWJTest(){
        int [] array = new int[]{2,3,4,5,6,7,8,1};
        BubbleJWJSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
