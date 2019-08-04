package cn.smile.array;

import org.junit.Test;

public class ArrayStructureTest {

    @Test
    public void readTest(){
        ArrayStructure arrayStructure = new ArrayStructure();
        arrayStructure.read();
    }

    @Test
    public void updateTest(){
        ArrayStructure arrayStructure = new ArrayStructure();
        arrayStructure.update();
    }

    @Test
    public void middleInsertTest(){
        ArrayStructure arrayStructure = new ArrayStructure(10);
        arrayStructure.middleInsert(3,0);
        arrayStructure.middleInsert(7,1);
        arrayStructure.middleInsert(9,2);
        arrayStructure.middleInsert(5,3);
        arrayStructure.middleInsert(6,1);
        arrayStructure.output();
    }

    @Test
    public void middleResizeInsertTest(){
        ArrayStructure arrayStructure = new ArrayStructure(4);
        arrayStructure.middleResizeInsert(3,0);
        arrayStructure.middleResizeInsert(7,1);
        arrayStructure.middleResizeInsert(9,2);
        arrayStructure.middleResizeInsert(5,3);
        arrayStructure.middleResizeInsert(6,1);
        arrayStructure.output();
    }

    @Test
    public void deleteTest(){
        ArrayStructure arrayStructure = new ArrayStructure(4);
        arrayStructure.middleResizeInsert(3,0);
        arrayStructure.middleResizeInsert(7,1);
        arrayStructure.middleResizeInsert(9,2);
        arrayStructure.middleResizeInsert(5,3);
        System.out.println(arrayStructure.delete(1));
        arrayStructure.output();
    }
}
