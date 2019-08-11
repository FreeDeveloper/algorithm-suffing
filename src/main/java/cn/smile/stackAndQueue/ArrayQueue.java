package cn.smile.stackAndQueue;

/**
 * 队列是一种线性的数据结构，队列的元素先入先出，队列的出口叫队头，入口叫队尾
 * 队尾是不放元素 队列的实际长度为数组的容量-1
 *
 * 队列是按照历史的顺序，重演
 * 例如在多线程竞争锁的时候，可以按照顺序决定线程在队列中的次序
 *
 * */
public class ArrayQueue {
    private String [] items;
    private int n;

    //head表头队头下标，tail表示队尾下标
    private int head;
    private int tail;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        int n = capacity;
    }

    public boolean enQueue(String a){

        //如果队尾下标=n表明数组已经满了
        if(tail == n){
            return false;
        }
        items[tail] = a;

        ++tail;

        return true;
    }

    // 入队操作，将 item 放入队尾
    //如果尾指针指向了N说明队尾已经满了，如果头指针是0说明彻底满了，否则可以把队列整个往前挤
    public boolean enQueue2(String item) {
        // tail == n 表示队列末尾没有空间了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) return false;
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            // 搬移完之后重新更新 head 和 tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }


    public String deQueue(){
        //队列为空
        if(head == tail){
            return null;
        }

        String temp = items[head];
        ++ head;
        return temp;
    }




}
