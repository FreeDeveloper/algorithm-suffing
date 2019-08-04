package cn.smile.array;

/**
 * 有限个 相同类型 的变量组成的 集合，数组中的每一个变量被称为元素
 * 数组在内存中是顺序存储
 *
 * 高效的随机访问能力，只要给出下标，可以在常量时间返回数据
 * 插入和删除元素方面，需要大量的元素移动
 * 适用于读多写少的场景
 * */
public class ArrayStructure {

    int arraySize;
    int [] array;

    public ArrayStructure(){
        super();
    }

    public ArrayStructure(int capacity){
        this.array = new int[capacity];
        arraySize = 0;
    }

    /**
     *通过下标读取 时间复杂度为O(1)
     * */
    public void read(){
        int [] array = new int [] {3,1,2,5,4,9,7,2};
        //输出数组中下标为3的元素
        System.out.println(array[3]);
    }

    /**
     *通过下标更新 时间复杂度为O(1)
     * */
    public void update(){
        int [] array = new int [] {3,1,2,5,4,9,7,2};
        array[5] = 10;
        System.out.println(array[5]);
    }

    /**
     * 不需要扩容的情况下，移动数据的时间复杂度O(n)
     * 时间负责度为O(n)
     * */
    public void middleInsert(int element,int index){

        //判断数据下标是否超过范围
        if(index < 0 || index > arraySize){
            throw new IndexOutOfBoundsException("超标");
        }
        System.out.println("开始插入"+index+"值："+element);

        //从右往左循环，将元素逐个向右挪一位
        for(int i = arraySize -1;i >= index;i--){
            System.out.println("开始位移"+i+"到"+(i+1));
            array[i+1] = array[i];
        }

        //腾出位置放新元素
        array[index] = element;
        arraySize++;
    }

    /**
     * 扩容的时间负责度O(n),插入并移动元素的时间负责度是O(n)
     * 时间负责度为O(n)
     * */
    public void middleResizeInsert(int element,int index){
        //判断数据下标是否超过范围
        if(index < 0 || index > arraySize){
            throw new IndexOutOfBoundsException("超标");
        }

        System.out.println("开始插入"+index+"值："+element);

        if(arraySize >= array.length){
            resize();
        }

        //从右往左循环，将元素逐个向右挪一位
        for(int i = arraySize -1;i >= index;i--){
            System.out.println("开始位移"+i+"到"+(i+1));
            array[i+1] = array[i];
        }

        //腾出位置放新元素
        array[index] = element;
        arraySize++;
    }

    /**
     *正常删除移动数据需要的时间复杂度是O(n)
     * 如果删除时，把最后一个元素换过来，时间复杂度可以简化为O(1) 不常用
     * */
    public int delete (int index){
        //判断数据下标是否超过范围
        if(index < 0 || index > arraySize){
            throw new IndexOutOfBoundsException("超标");
        }

        int deletedElemet = array[index];
        for(int i = index;i< arraySize -1;i++){
            array[i] = array[i+1];
        }

        arraySize -- ;
        return deletedElemet;

    }

    public void output(){
        for (int i =0; i< arraySize; i++){
            System.out.println(array[i]);
        }
    }

    public void resize(){
        System.out.println("数组长度不足，开始扩容~");
        int [] arrayNew = new int[array.length * 2];
        //从旧数据拷贝数据到新数组
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

}
