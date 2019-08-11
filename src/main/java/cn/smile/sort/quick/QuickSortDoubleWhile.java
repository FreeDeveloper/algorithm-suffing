package cn.smile.sort.quick;


public class QuickSortDoubleWhile {

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

        int left = startIndex;
        int right = endIndex;

        while(left != right){

            //控制right指针比较左移，如果right指针对应的值大于基准元素，则左移一位继续比较
            while(left < right && arr[right] > pivot){
                right --;
            }
            //控制left指针比较右移，如果left指针对应的值小于基准元素，则右移一位继续比较
            while(left < right && arr[left] <= pivot){
                left ++;
            }

            //如果作指针小于有指针，则开始值交换
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //如果左右指针重合，则说明本轮结束
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
