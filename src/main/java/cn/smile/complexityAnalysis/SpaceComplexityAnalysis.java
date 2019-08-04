package cn.smile.complexityAnalysis;

/**
 * 空间复杂度分析-执行算法的空间成本（存储中间数据），不计算原数据存储
 * 算法的存储空间与数据规模之间的增长关系。
 * */
public class SpaceComplexityAnalysis {

    /**
     * 算法的存储空间大小固定，和输入没有直接关系，常量空间
     * O(1)
     * */
    void fun1(int n){
        int var = 3;
    }

    /**
     * 算法的存储空间是一个线性的集合（如数组），集合的大小与输入规模n成正比
     * O(n)
     * */
    void fun2(int n){
        int [] array = new int[n];
    }

    /**
     * 算法的存储空间是二位数组集合，集合的大小与输入规模n成正比
     * O(n²)
     * */
    void fun3(int n){
        int [] array = new int[n];
    }

    /**
     * 递归空间
     * 涉及到虚拟机栈对方法调用的处理，每个方法会在虚拟机栈上写入栈帧，方法执行和退出会有出栈，入栈操作
     * O(n)
     * */
    void fun4(int n){
        if(n < 1){
            return;
        }

        fun4(n -1);
    }
}
