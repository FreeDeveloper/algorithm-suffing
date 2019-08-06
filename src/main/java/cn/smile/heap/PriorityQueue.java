package cn.smile.heap;

import java.util.Arrays;

public class PriorityQueue {
    private int [] array;
    private int size;

    public PriorityQueue(){
        //初始化队列长度为32
        array = new int[32];
    }

    public void enQueue(int key){
        if(size >= array.length){
            resize();
        }

        array[size ++] = key;
        upAdjust();
    }

    public int deQueue () throws Exception {
        if(size < 0){
            throw new Exception("");
        }

        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void resize(){
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }

    public void upAdjust(){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;

        //temp保留插入的叶子节点的值，用于最后的赋值
        int temp = array[childIndex];
        while(childIndex > 0 && temp < array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }

        array[childIndex] = temp;
    }

    /**
     *下沉调整
     * array 待调整的堆
     * parentIndex 要下沉的父节点
     * length 堆的有效大小
     * */
    public void downAdjust(){
        int parentIndex = 0;
        int length = size;
        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        //查询到左孩子节点的下标
        int childIndex = 2 * parentIndex + 1;
        while(childIndex < length){

            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex ++ ;
            }

            //如果父节点小于任何一个孩子的值，则退出
            if(temp <= array[childIndex]){
                break;
            }

            //无须真正交换，单项赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }

        array[parentIndex] = temp;

    }
}
