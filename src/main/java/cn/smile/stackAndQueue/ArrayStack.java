package cn.smile.stackAndQueue;

/**
 * 一种线性的数据结构，栈中的元素只能先入后出，最早进入的元素存放的位置叫做栈底
 *最后进入的元素存放的位置叫做栈顶
 *
 * 栈的使用：
 * 1、JVM虚拟机栈，存放方法的栈帧
 * 2、表达式求值，存放操作数和操作符
 * 3、括号匹配
 * 4、页面回退和前进
 *
 * */
public class ArrayStack {
    private String [] items;
    //栈当前元素数
    private int count;
    //栈的容量
    private int n;

    public ArrayStack(int n){
        items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String a){
        //栈满
        if(count == n){
            return false;
        }

        items[n] = a;
        ++ count;
        return true;
    }

    public String pop(){

        //栈是空的
        if(count == 0){
            return null;
        }

        String temp = items[count - 1];
        -- count;
        return  temp;
    }

}
