package cn.smile.heap;

/***
 * 二叉堆是一种完全二叉树，分为最大堆和最小堆
 * 最大堆中任何一个父节点的值都大于或者等于他的左右孩子节点
 *      最大堆的堆顶是整个堆中的最大元素
 * 最小堆中任何一个父节点的值都小于或者等于它的左右孩子节点
 *      最小堆的堆顶是整个堆中的最小元素
 *
 *  二叉堆用数组来表示：
 *      假设父节点的下标是parent，左孩子下标是2*parent+1,右孩子下标是2*parent+2
 *
 *  二叉堆是实现堆排序和优先队列的基础
 */
public class TreeHeapStructure {

    public static void upAdjust(int [] array){
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
    public static void downAdjust(int [] array,int parentIndex,int length){
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

    public static void buildHeap(int [] array){
        for(int i = (array.length - 2) / 2 ; i > 0;i--){
            downAdjust(array,i,array.length);
        }
    }

}
