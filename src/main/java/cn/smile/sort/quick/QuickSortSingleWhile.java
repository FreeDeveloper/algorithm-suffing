package cn.smile.sort.quick;

/**
 * 每一轮都需要比较所有元素 n
 * 比较轮数，平均情况下是logn
 * 所以时间复杂度为n*logN
 * */
public class QuickSortSingleWhile {
    //双边循环法递归实现
    public static void quickSort(int [] arr,int startIndex,int endIndex){

        //递归结束条件
        if(startIndex >= endIndex){
            return;
        }

        int pivotIndex = patition(arr,startIndex,endIndex);

        //根据基准元素，分成两部分进行递归排序
        quickSort(arr,startIndex,pivotIndex-1);

        quickSort(arr,pivotIndex + 1,endIndex);
    }

    private static int patition(int [] arr,int startIndex,int endIndex){
        //取第一个元素作为基准元素（也可选择随机一个元素）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for(int i = startIndex+1;i <= endIndex;i++){
            if(arr[i] < pivot){
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;

    }
}
