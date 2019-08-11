package cn.smile.sort.quick;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortUserStack {
    public static void quickSort(int [] arr,int startIndex,int endIndex){
        Stack<Map<String ,Integer>> quickSortStack = new Stack<Map<String,Integer>>();

        Map rootParam = new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);

        quickSortStack.push(rootParam);

        //代替递归
        while(!quickSortStack.isEmpty()){
            Map<String,Integer> param = quickSortStack.pop();

            int pivotIndex = patition(arr,param.get("startIndex"),param.get("endIndex"));

            if(param.get("startIndex") < pivotIndex - 1){
                Map<String,Integer> leftParam = new HashMap<String,Integer>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if(pivotIndex + 1 < param.get("endIndex") ){
                Map<String,Integer> rightParam = new HashMap<String,Integer>();
                rightParam.put("startIndex",pivotIndex + 1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }

        }


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
