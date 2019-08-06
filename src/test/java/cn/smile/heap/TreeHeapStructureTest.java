package cn.smile.heap;

import org.junit.Test;

import java.util.Arrays;

public class TreeHeapStructureTest {

    @Test
    public void treeHeapTest(){
        int [] array = new int [] {1,3,2,6,5,7,8,9,10,0};
        TreeHeapStructure.upAdjust(array);
        System.out.println(Arrays.toString(array));

        int [] array2 = new int [] {7,1,3,10,5,2,8,9,6};
        TreeHeapStructure.buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
