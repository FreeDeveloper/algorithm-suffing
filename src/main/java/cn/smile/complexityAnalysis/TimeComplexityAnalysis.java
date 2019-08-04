package cn.smile.complexityAnalysis;

/**
 *大O复杂度表示法:
 * 存在函数f(n),使得当n趋近于无穷大时，T(n)/f(n)的极限值为不等于0的常数，
 * 则f(n)是T(n)的同数量级函数记做T(n) = O(f(n)),称为O(f(n)),O为算法的渐进式时间复杂度简称时间复杂度
 *
 * 时间复杂度分析
 * 如果运行时间是常量级，用常数1表示
 * 只保留时间函数中的最高阶项
 * 如果最高阶项存在，则省区最高阶项前的常数
 *
 * 1. 只关注循环执行次数最多的一段代码
 * 2. 加法法则：总复杂度等于量级最大的那段代码的复杂度
 * 3. 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积
 *
 * */
public class TimeComplexityAnalysis {



    /**
     *
     * 场景：10cm面包，每三分钟吃掉一厘米，吃掉整个面包多久
     * 面包长度为n
     *
     * T(n) = 3n
     * 最高阶项为3n，去掉系数3，则
     * T(n) = O(n)
     * */
    public void eat1(int n){
        for(int i = 0; i< n; i++){
            System.out.println("等待一分钟");
            System.out.println("等待一分钟");
            System.out.println("吃1CM面包");
        }
    }

    /**
     *
     * 场景：16cm面包,五分钟吃点剩余面包的一半，吃到剩1cm需要多久
     * 面包长度n
     *
     * T(n) = 5logn
     * 最高阶项为5logn，去掉系数5，则
     * T(n) = O(Logn)
     * */
    public void eat2(int n){
        for(int i = n; i > 1; i /= 2){
            System.out.println("等待一分钟");
            System.out.println("等待一分钟");
            System.out.println("等待一分钟");
            System.out.println("等待一分钟");
            System.out.println("吃一半面包");
        }
    }

    /**
     *
     * 场景：2分钟吃掉一个鸡腿
     *
     * T(n) = 2
     * 常量级转换为时间复杂度为
     * T(n) = O(1)
     * */
    public void eat3(int n){
        System.out.println("等待一分钟");
        System.out.println("吃一个鸡腿");
    }

    /**
     *
     * 场景：10cm的面包，吃掉第一个1cm，休息一分钟，吃掉第二个1cm，休息两分钟。。。
     * 面包长度n
     * 1+2+3+4...+(n-1)+n
     *
     * T(n) = 0.5n²+0.5n
     * 最高阶0.5n²，省去系数
     * T(n) = O(n²)
     * */
    public void eat4(int n){
        for(int i = 0;i < n;i++){
            for (int j = 0; j < i; j++){
                System.out.println("等待一分钟");
            }
            System.out.println("吃1cm面包");
        }
    }

    /****************************************另外一种评估方式**************************************************/



    /**
     * 第 2、3 行代码分别需要 1 个 unit_time 的执行时间，
     * 第 4、5 行都运行了 n 遍，所以需要 2n*unit_time 的执行时间，
     * 所以这段代码总的执行时间就是 (2n+2)*unit_time。
     * 可以看出来，所有代码的执行时间 T(n) 与每行代码的执行次数成正比。
     *
     *
     * 第 2、3 行代码都是常量级的执行时间，与 n 的大小无关，所以对于复杂度并没有影响。
     * 4、5行代码被执行了 n 次，所以总的时间复杂度就是 O(n)。
     * */
    int cal(int n) {
        int sum = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 第 2、3、4 行代码，每行都需要 1 个 unit_time 的执行时间，
     * 第 5、6 行代码循环执行了 n 遍，需要 2n * unit_time 的执行时间，
     * 第 7、8 行代码循环执行了 n2遍，所以需要 2n² * unit_time 的执行时间。
     * 所以，整段代码总的执行时间 T(n) = (2n²+2n+3)*unit_time。
     * 尽管我们不知道 unit_time 的具体值，但是通过这两段代码执行时间的推导过程，
     * 我们可以得到一个非常重要的规律，那就是，所有代码的执行时间 T(n) 与每行代码的执行次数 n 成正比。
     * */
    int cal2(int n) {
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum = sum +  i * j;
            }
        }
        return sum;
    }

    /**
     * 这个代码分为三部分，分别是求 sum_1、sum_2、sum_3。我们可以分别分析每一部分的时间复杂度，然后把它们放到一块儿，再取一个量级最大的作为整段代码的复杂度。
     * 第一段的时间复杂度是多少呢？这段代码循环执行了 100 次，所以是一个常量的执行时间，跟 n 的规模无关。
     * 这里我要再强调一下，即便这段代码循环 10000 次、100000 次，只要是一个已知的数，跟 n 无关，照样也是常量级的执行时间。当 n 无限大的时候，就可以忽略。尽管对代码的执行时间会有很大影响，但是回到时间复杂度的概念来说，它表示的是一个算法执行效率与数据规模增长的变化趋势，所以不管常量的执行时间多大，我们都可以忽略掉。因为它本身对增长趋势并没有影响。
     * 那第二段代码和第三段代码的时间复杂度是多少呢？答案是 O(n) 和 O(n2)，你应该能容易就分析出来，我就不啰嗦了。
     * 综合这三段代码的时间复杂度，我们取其中最大的量级。所以，整段代码的时间复杂度就为 O(n2)。也就是说：总的时间复杂度就等于量级最大的那段代码的时间复杂度。那我们将这个规律抽象成公式就是：
     * 如果 T1(n)=O(f(n))，T2(n)=O(g(n))；那么 T(n)=T1(n)+T2(n)=max(O(f(n)), O(g(n))) =O(max(f(n), g(n))).
     *
     * */
    int cal3(int n) {
        int sum_1 = 0;
        int p = 1;
        for (; p < 100; ++p) {
            sum_1 = sum_1 + p;
        }

        int sum_2 = 0;
        int q = 1;
        for (; q < n; ++q) {
            sum_2 = sum_2 + q;
        }

        int sum_3 = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum_3 = sum_3 +  i * j;
            }
        }

        return sum_1 + sum_2 + sum_3;
    }

    /**
     * O(1)
     * */
    void O1Method(){
        int i = 8;
        int j = 6;
        int sum = i + j;
    }

    /**
     * O(log2n)
     *
     * O(log3n)
     * */
    void OLog2Method(int n){
        int i=1;
        while (i <= n)  {
            i = i * 2;
        }

        while (i <= n)  {
            i = i * 3;
        }
    }

}
